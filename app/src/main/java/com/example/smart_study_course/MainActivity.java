package com.example.smart_study_course;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email_log_in,password_log_in,name_log_in;
    Button btn_log_in,btn_register_2;
    TextView forgotten_password;
    FirebaseAuth firebaseAuth2;
    SharedPreferences sharedPreferences;
    String l="Hello";
    SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth2=FirebaseAuth.getInstance();

        //name_log_in=findViewById(R.id.name_log_in);
        email_log_in=findViewById(R.id.email_log_in);
        password_log_in=findViewById(R.id.password_log_in);

        btn_log_in=findViewById(R.id.btn_login);
        btn_register_2=findViewById(R.id.btn_register2);
        forgotten_password=findViewById(R.id.forgotten_password);

        //sharedPreferences=getSharedPreferences(l, Context.MODE_PRIVATE);
        //Context k=getApplicationContext();
        sharedPreferenceConfig=new SharedPreferenceConfig(getApplicationContext());
        /*boolean status;
        status=sharedPreferences.getBoolean(l,false);*/
        if(sharedPreferenceConfig.read_login_status())
        {
            startActivity(new Intent(getApplicationContext(),MainActivity4.class));
            finish();
        }

        btn_log_in.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String email_log_in_string=email_log_in.getText().toString().trim();
                String password_log_in_string=password_log_in.getText().toString().trim();
               // String name_log_in_string=password_log_in.getText().toString().trim();
               /*if(TextUtils.isEmpty(name_log_in_string))
                {
                    name_log_in.setError("E-mail id is required");
                    return;
                }*/
                if(TextUtils.isEmpty(email_log_in_string))
                {
                    email_log_in.setError("E-mail id is required");
                    return;
                }
                if(TextUtils.isEmpty(password_log_in_string))
                {
                    password_log_in.setError("Password is required");
                    return;
                }
                if(password_log_in_string.length()<6)
                {
                    password_log_in.setError("Password must be of 6 characters ");
                    return;
                }
                firebaseAuth2.signInWithEmailAndPassword(email_log_in_string,password_log_in_string).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            email_log_in.setText("");
                            password_log_in.setText("");
                           // startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                            sharedPreferenceConfig.login_status(true);
                            startActivity(new Intent(getApplicationContext(),MainActivity4.class));
                            finish();
                            /*SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putBoolean(l,true);
                            editor.commit();*/
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            email_log_in.setText("");
                            password_log_in.setText("");
                        }

                    }
                });
               /*if(email_log_in_string.equals(getResources().getString(R.string.username))&&password_log_in_string.equals(getResources().getString(R.string.password)))
                {
                    startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                    sharedPreferenceConfig.login_status(true);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Not valid", Toast.LENGTH_SHORT).show();
                    email_log_in.setText("");
                    password_log_in.setText("");

                }*/

            }
        });
        btn_register_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                finish();
            }
        });
    }

    }
