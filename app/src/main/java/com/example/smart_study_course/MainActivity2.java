package com.example.smart_study_course;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {
    EditText name_register,email_register,password_register,confirm_password_register;
    RadioGroup radioGroup;
    RadioButton radiobutton;
    Button btn_register;
    TextView back_to_log_in_page;
    FirebaseAuth firebaseAuth;
    String user_uid,position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name_register=findViewById(R.id.name_register);
        email_register=findViewById(R.id.email_register);
        password_register=findViewById(R.id.password_register);
        confirm_password_register=findViewById(R.id.confirm_password_register);



        btn_register=findViewById(R.id.btn_register);
        back_to_log_in_page=findViewById(R.id.back_to_log_in_page);

        radioGroup=findViewById(R.id.radio_grp);

        firebaseAuth=FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String password_register_string=password_register.getText().toString().trim();
                String confirm_password_register_string=confirm_password_register.getText().toString().trim();
                String name_register_string=name_register.getText().toString().trim();
                String email_register_string=email_register.getText().toString().trim();

                if(TextUtils.isEmpty(name_register_string))
                {
                    name_register.setError("Name is required");
                    return;
                }
                if(TextUtils.isEmpty(email_register_string))
                {
                    email_register.setError("Email id is required");
                    return;
                }
                if(TextUtils.isEmpty(password_register_string))
                {
                    password_register.setError("Password id is required");
                    return;
                }
                if(password_register_string.length()<6)
                {
                    password_register.setError("Password should be at least of length 6");
                    return;
                }
                if(TextUtils.isEmpty(confirm_password_register_string))
                {
                    confirm_password_register.setError("Confirm the password");
                    return;
                }
                if(!password_register_string.equals(confirm_password_register_string))
                {
                   System.out.println("onClick: "+password_register_string+" tani "+confirm_password_register_string);
                    confirm_password_register.setError("Passwords are not matched");
                    return;
                }
                int radioId = radioGroup.getCheckedRadioButtonId();
                radiobutton = findViewById(radioId);
                position= radiobutton.getText().toString();
                if(radioGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(MainActivity2.this, "You have to select your occupation", Toast.LENGTH_SHORT).show();

                }

                 /*
                if(Teacher.isChecked()&&!Cr.isChecked()&&!Student.isChecked())
                {
                     position=Teacher.getText().toString();
                }
                else if(!Teacher.isChecked()&&Cr.isChecked()&&!Student.isChecked())
                {
                     position=Cr.getText().toString();
                }
                else if(!Teacher.isChecked()&&!Cr.isChecked()&&Student.isChecked())
                {
                     position=Student.getText().toString();
                }*/


                //Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                firebaseAuth.createUserWithEmailAndPassword(email_register_string,password_register_string).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity2.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            FirebaseUser user=firebaseAuth.getCurrentUser();
                            user_uid=user.getUid();
                            System.out.println(user_uid);
                            HashMap<String,Object>map=new HashMap<>();
                            map.put("Name",name_register.getText().toString());
                            map.put("Email",email_register.getText().toString());
                            map.put("Password",password_register.getText().toString());
                            map.put("Position",position);
                            FirebaseDatabase.getInstance().getReference().child("Users").child(user_uid).
                                    setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Log.i("dcn", "onComplete: ");
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.i("dcn", "OnFailure "+e.toString());

                                }
                            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.i("dcn", "onSuccess: ");
                                }
                            });

                            name_register.setText("");
                            email_register.setText("");
                            password_register.setText("");
                            confirm_password_register.setText("");
                            radioGroup.clearCheck();
                            FirebaseDatabase.getInstance().getReference().
                                    child("Notifications").child(user_uid).child("K").setValue("Bye");

                        }
                        else
                        {
                            Toast.makeText(MainActivity2.this, "Error in registration"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                /*if(!email_register_string.equals("")&&!password_register_string.equals(""))
                {
                    firebaseAuth.signInWithEmailAndPassword(email_register_string,password_register_string);
                    Toast.makeText(MainActivity2.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    name_register.setText("");
                    email_register.setText("");
                    password_register.setText("");
                    confirm_password_register.setText("");
                    teacher_cr_student.setText("");
                }*/





            }
        });

        back_to_log_in_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });



    }

    public void checkButton(View v)
    {
        int radioId=radioGroup.getCheckedRadioButtonId();

        radiobutton=findViewById(radioId);
    }
}