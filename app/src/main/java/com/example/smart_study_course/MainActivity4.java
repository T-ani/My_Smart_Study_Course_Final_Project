package com.example.smart_study_course;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.health.UidHealthStats;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {

    Button tani_log_out;
    Map<String,Object> update= new HashMap<>();

    LinearLayout home_click,account_click;
    private SharedPreferenceConfig sharedPreferenceConfig;
    FirebaseAuth firebaseAuth;
    LinearLayout tani_home_page,tani_account_view_page,TANI_CSE_HOME_PAGE;
    ScrollView cse_2103_page;
    LinearLayout CSE_2103_click;
    RelativeLayout image;
    TextView account_view_name,account_view_mail,account_view_position,save_button;
    DatabaseReference User;
    String USER_UID;
    DatabaseReference Selected_Chapter,Members;
    DatabaseReference CT_Child,CT_Chlid_READ,Notification_Child,Notification_child_read,firebase;
    FirebaseDatabase Members_to_show,CT_Chlid_READ_FIREBASE,Notification_Child_Firebase;
    String position_account_view;
    Toolbar toolbar;
    int i;
    String temp_position,Name,CT_NAME,KEY_NAME_CT,New_Line;
    SearchView searchView;
    Integer Notification_Count=1,Notification_Count_1=0;
    Date currentTime;

    TextView Teachers_member_click,Students_member_click;
    LinearLayout registered_member_view_page,teachers_class_mates_click_button;
    ListView Teachers_list_view,Students_list_view;

    LinearLayout course_ct_page_view,list_course_ct_click;
    ListView list_view_2_course_ct;

    LinearLayout couse_according_to_semester;
    CardView cardView_CSE_2103_click;
    LinearLayout create_course_view_page_with_chapters;

    TextView Observe_Course,CT;
    LinearLayout Create_CT_Syllabus;
    ListView CT_LIST_VIEW;
    ScrollView CT_SCROLL_VIEW;
    String CT_KEY_NAME_OF_CT_CREATE_NAME;

    ListView notification_list_view;

    LinearLayout round_view,notification_page_view,notification_click_button;

    ListView listView;

    ArrayList<String> list;
    ArrayList<String>list2;
    ArrayList<String>list3;
    ArrayList<String>list4;
    ArrayList<String>list5;
    ArrayList<String>list7;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;
    ArrayAdapter<String> adapter4;
    ArrayAdapter<String> adapter5;
    ArrayAdapter<String> adapter7;

    int flag_for_name_match;

    String count;
    int flag1=0,flag2=0,flag3=0,flag4=0,flag5=0,flag6=0,flag7=0,flag8=0,flag9=0,flag10=0,flag11=0,flag12=0,flag13=0,flag14=0,flag15=0,flag16=0,flag17=0,flag18=0,flag19=0,flag20=0;
    int flag21=0,flag22=0,flag23=0,flag24=0,flag25=0,flag26=0,flag27=0,flag28=0,flag29=0,flag30=0,flag31=0,flag32=0,flag33=0,flag34=0,flag35=0,flag36=0,flag37=0,flag38=0;

    int temp;

    CheckBox checkBox1_2103,checkBox2_2103,checkBox3_2103,checkBox4_2103,checkBox5_2103,checkBox6_2103,checkBox7_2103,checkBox8_2103;
    CheckBox checkBox9_2103,checkBox10_2103,checkBox11_2103,checkBox12_2103,checkBox13_2103,checkBox14_2103,checkBox15_2103,checkBox16_2103;
    CheckBox checkBox17_2103,checkBox18_2103,checkBox19_2103,checkBox20_2103,checkBox21_2103,checkBox22_2103,checkBox23_2103,checkBox24_2103;
    CheckBox checkBox25_2103,checkBox26_2103,checkBox27_2103,checkBox28_2103,checkBox29_2103,checkBox30_2103,checkBox31_2103,checkBox32_2103;
    CheckBox checkBox33_2103,checkBox34_2103,checkBox35_2103,checkBox36_2103,checkBox37_2103,checkBox38_2103;
    String cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb38,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29;
    String cb30,cb31,cb32,cb33,cb34,cb35,cb36,cb37;
    String CT_cb1,CT_cb2,CT_cb3,CT_cb4,CT_cb5,CT_cb6,CT_cb7,CT_cb8,CT_cb9,CT_cb10;
    Member member;
    CheckBox CT_Check_Box_1,CT_Check_Box_2,CT_Check_Box_3,CT_Check_Box_4,CT_Check_Box_5,CT_Check_Box_6,CT_Check_Box_7,CT_Check_Box_8,CT_Check_Box_9,CT_Check_Box_10;
    TextView Log_Out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        firebaseAuth = FirebaseAuth.getInstance();


        update.put("K","Hello");


        toolbar=findViewById(R.id.customized_tool_bar);
        setSupportActionBar(toolbar);
        //Read Portion Id
        account_view_name = findViewById(R.id.account_view_name);
        account_view_mail = findViewById(R.id.account_view_mail);
        account_view_position = findViewById(R.id.account_view_position);

        //Read Portion
        User = FirebaseDatabase.getInstance().getReference().child("Users");
        FirebaseUser user2 = firebaseAuth.getCurrentUser();
        USER_UID = user2.getUid();

        home_click = findViewById(R.id.tani_2_click1);
        account_click = findViewById(R.id.tani_2_click2);
        CSE_2103_click = findViewById(R.id.TANI_CSE_2103_Click);
        save_button = findViewById(R.id.save_button);
        teachers_class_mates_click_button=findViewById(R.id.teachers_class_mates_click);

        round_view=findViewById(R.id.round_view);



        Log_Out = findViewById(R.id.tani_log_out);

        tani_home_page = findViewById(R.id.tani_home_page);
        tani_account_view_page = findViewById(R.id.tani_account_view_page);
        TANI_CSE_HOME_PAGE = findViewById(R.id.TANI_CSE_HOME_PAGE);
        cse_2103_page = findViewById(R.id.page_CSE_2103_scroll_view);
        registered_member_view_page=findViewById(R.id.registered_members_view_page);


        Teachers_member_click=findViewById(R.id.teacher_members_click);
        Students_member_click=findViewById(R.id.student_member_click);
        Teachers_list_view=findViewById(R.id.Teachers_list_view);
        Students_list_view=findViewById(R.id.Students_list_view);

        course_ct_page_view=findViewById(R.id.course_ct_page_view);
        list_course_ct_click=findViewById(R.id.list_course_ct_click);
        list_view_2_course_ct=findViewById(R.id.list_view_2_course_ct);
        //image=findViewById(R.id.relative_image);


        couse_according_to_semester=findViewById(R.id.couse_according_to_semester);
        cardView_CSE_2103_click=findViewById(R.id.CSE_2103_CT_COURSE_CLICK);
        create_course_view_page_with_chapters=findViewById(R.id.create_course_view_page_with_chapters);

        Observe_Course=findViewById(R.id.Observe_Course);
        CT=findViewById(R.id.CT);
        Create_CT_Syllabus=findViewById(R.id.Create_Ct_Syllabus);
        CT_SCROLL_VIEW=findViewById(R.id.ct_scroll_view);
        CT_LIST_VIEW=findViewById(R.id.CT_LIST_VIEW);

        notification_page_view=findViewById(R.id.notification_view_page);
        notification_click_button=findViewById(R.id.notification_click_button);
        notification_list_view=findViewById(R.id.notification_list_view);

        //----CT Check Box----//
        CT_Check_Box_1=findViewById(R.id.CT_Check_Box_1);
        CT_Check_Box_2=findViewById(R.id.CT_Check_Box_2);
        CT_Check_Box_3=findViewById(R.id.CT_Check_Box_3);
        CT_Check_Box_4=findViewById(R.id.CT_Check_Box_4);
        CT_Check_Box_5=findViewById(R.id.CT_Check_Box_5);
        CT_Check_Box_6=findViewById(R.id.CT_Check_Box_6);
        CT_Check_Box_7=findViewById(R.id.CT_Check_Box_7);
        CT_Check_Box_8=findViewById(R.id.CT_Check_Box_8);
        CT_Check_Box_9=findViewById(R.id.CT_Check_Box_9);
        CT_Check_Box_10=findViewById(R.id.CT_Check_Box_10);


        //---Check Box 2103---//
        checkBox1_2103 = findViewById(R.id.check_box_1_cse_2103);
        checkBox2_2103 = findViewById(R.id.check_box_2_cse_2103);
        checkBox3_2103 = findViewById(R.id.check_box_3_cse_2103);
        checkBox4_2103 = findViewById(R.id.check_box_4_cse_2103);
        checkBox5_2103 = findViewById(R.id.check_box_5_cse_2103);
        checkBox6_2103 = findViewById(R.id.check_box_6_cse_2103);
        checkBox7_2103 = findViewById(R.id.check_box_7_cse_2103);
        checkBox8_2103 = findViewById(R.id.check_box_8_cse_2103);
        checkBox9_2103 = findViewById(R.id.check_box_9_cse_2103);
        checkBox10_2103 = findViewById(R.id.check_box_10_cse_2103);
        checkBox11_2103 = findViewById(R.id.check_box_11_cse_2103);
        checkBox12_2103 = findViewById(R.id.check_box_12_cse_2103);
        checkBox13_2103 = findViewById(R.id.check_box_13_cse_2103);
        checkBox14_2103 = findViewById(R.id.check_box_14_cse_2103);
        checkBox15_2103 = findViewById(R.id.check_box_15_cse_2103);
        checkBox16_2103 = findViewById(R.id.check_box_16_cse_2103);
        checkBox17_2103 = findViewById(R.id.check_box_17_cse_2103);
        checkBox18_2103 = findViewById(R.id.check_box_18_cse_2103);
        checkBox19_2103 = findViewById(R.id.check_box_19_cse_2103);
        checkBox20_2103 = findViewById(R.id.check_box_20_cse_2103);
        checkBox21_2103 = findViewById(R.id.check_box_21_cse_2103);
        checkBox22_2103 = findViewById(R.id.check_box_22_cse_2103);
        checkBox23_2103 = findViewById(R.id.check_box_23_cse_2103);
        checkBox24_2103 = findViewById(R.id.check_box_24_cse_2103);
        checkBox25_2103 = findViewById(R.id.check_box_25_cse_2103);
        checkBox26_2103 = findViewById(R.id.check_box_26_cse_2103);
        checkBox27_2103 = findViewById(R.id.check_box_27_cse_2103);
        checkBox28_2103 = findViewById(R.id.check_box_28_cse_2103);
        checkBox29_2103 = findViewById(R.id.check_box_29_cse_2103);
        checkBox30_2103 = findViewById(R.id.check_box_30_cse_2103);
        checkBox31_2103 = findViewById(R.id.check_box_31_cse_2103);
        checkBox32_2103 = findViewById(R.id.check_box_32_cse_2103);
        checkBox33_2103 = findViewById(R.id.check_box_33_cse_2103);
        checkBox34_2103 = findViewById(R.id.check_box_34_cse_2103);
        checkBox35_2103 = findViewById(R.id.check_box_35_cse_2103);
        checkBox36_2103 = findViewById(R.id.check_box_36_cse_2103);
        checkBox37_2103 = findViewById(R.id.check_box_37_cse_2103);
        checkBox38_2103 = findViewById(R.id.check_box_38_cse_2103);
        //searchView=findViewById(R.id.search_view);
        listView=findViewById(R.id.department_list);


        list=new ArrayList<String>();

        list.add("CSE-Computer Science & Engineering");
        list.add("EEE-Electrical & Electronics Engineering");
        list.add("ETE-Electrical & Telecommunication Engineering");
        list.add("ECE-Electrical & Computer Engineering");
        list.add("CE-Civil Engineering");
        list.add("ME-Mechanical Engineering");
        list.add("GCE-Glass & Ceramic Engineering");
        list.add("MSE-Materials Science Engineering");
        list.add("IPE-Industrial & Production Engineering");
        list.add("MTE-Mechatronics Engineering");
        list.add("URP-Urban & Regional Planning");
        list.add("Arch-Architecture");
        list.add("CFPE-Chemical & Food Process Engineering");
        list.add("BECM-Building Engineering & Construction Management");

        adapter=new ArrayAdapter<>(this, R.layout.row, list);

        listView.setAdapter(adapter);


        list4=new ArrayList<String>();

        list4.add("CSE First Semester");
        list4.add("CSE Second Semester");
        list4.add("CSE Third Semester");
        list4.add("CSE Fourth Semester");
        list4.add("CSE Fifth Semester");
        list4.add("CSE Sixth Semester");
        list4.add("CSE Seventh Semester");
        list4.add("CSE Eighth Semester");

        list4.add("EEE First Semester");
        list4.add("EEE Second Semester");
        list4.add("EEE Third Semester");
        list4.add("EEE Fourth Semester");
        list4.add("EEE Fifth Semester");
        list4.add("EEE Sixth Semester");
        list4.add("EEE Seventh Semester");
        list4.add("EEE Eighth Semester");

        list4.add("ECE First Semester");
        list4.add("ECE Second Semester");
        list4.add("ECE Third Semester");
        list4.add("ECE Fourth Semester");
        list4.add("ECE Fifth Semester");
        list4.add("ECE Sixth Semester");
        list4.add("ECE Seventh Semester");
        list4.add("ECE Eighth Semester");


        adapter4=new ArrayAdapter<>(this, R.layout.customized_row, list4);

        list_view_2_course_ct.setAdapter(adapter4);


        firebaseAuth = FirebaseAuth.getInstance();

        Members_to_show=FirebaseDatabase.getInstance();
        Members=Members_to_show.getReference("Users");
        CT_Chlid_READ_FIREBASE=FirebaseDatabase.getInstance();
        CT_Chlid_READ=CT_Chlid_READ_FIREBASE.getReference("CT_CHILD");
        Notification_Child_Firebase=FirebaseDatabase.getInstance();
        Notification_child_read=Notification_Child_Firebase.getReference("Notifications");

        list2=new ArrayList<String>();
        list3=new ArrayList<String>();


        list5=new ArrayList<String>();
        list7=new ArrayList<String>();


        Members.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

               for(DataSnapshot snapshot1:snapshot.getChildren())
                {

                    Map<String,Object> data=(Map<String, Object>)snapshot1.getValue();
                    temp_position= (String) data.get("Position");
                    if(temp_position.equals("Teacher"))
                    {
                    Name=(String) data.get("Name");
                    list2.add(Name);
                    System.out.println(Name+"TeacherTeacher");
                    }
                    if(temp_position.equals("Student") || temp_position.equals("CR"))
                    {
                        if(temp_position.equals("CR"))
                        {
                        Name=(String) data.get("Name");
                        Name=Name+"----(CR)";
                        list3.add(Name);
                        System.out.println(Name+"StudentStudent");
                        }
                        if(temp_position.equals("Student"))
                        {
                            Name=(String) data.get("Name");
                            list3.add(Name);
                            System.out.println(Name+"StudentStudent");
                        }
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter2=new ArrayAdapter<>(this, R.layout.row, list2);
        Teachers_list_view.setAdapter(adapter2);

        adapter3=new ArrayAdapter<>(this, R.layout.row, list3);
        Students_list_view.setAdapter(adapter3);


        Selected_Chapter = FirebaseDatabase.getInstance().getReference().child("Selected_Chapters");
        CT_Child=FirebaseDatabase.getInstance().getReference().child("CT_CHILD");
        Notification_Child=FirebaseDatabase.getInstance().getReference().child("Notifications");

        Notification_child_read.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(((String)snapshot.child(USER_UID).child("K").getValue(String.class)).equals("Hello"))
                {
                    if (position_account_view.equals("Student") || position_account_view.equals("CR"))
                    {

                        round_view.setVisibility(View.VISIBLE);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            NotificationChannel channel = new NotificationChannel("n", "n", NotificationManager.IMPORTANCE_DEFAULT);
                            NotificationManager manager = getSystemService(NotificationManager.class);
                            manager.createNotificationChannel(channel);
                        }
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity4.this, "n");
                        builder.setContentText("Hello");
                        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
                        builder.setAutoCancel(true);
                        builder.setContentText("New data is added");
                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity4.this);
                        managerCompat.notify(999, builder.build());
                    }
                }
                if((snapshot.child(USER_UID).child("K").getValue(String.class)).equals("Bye"))
                {
                    round_view.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //--Reading Data--//
        User.child(USER_UID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String name_account_view = snapshot.child("Name").getValue(String.class);
                String email_account_view = snapshot.child("Email").getValue(String.class);
                position_account_view = snapshot.child("Position").getValue(String.class);

                System.out.println(name_account_view + "00000000000000000000000");
                System.out.println(email_account_view + "00000007880000000000000000");
                System.out.println(position_account_view + "000000000000000009090000000");
                account_view_name.setText(name_account_view);
                account_view_name.setTextColor(getResources().getColor(R.color.blue));
                account_view_mail.setText(email_account_view);
                account_view_mail.setTextColor(getResources().getColor(R.color.blue));
                account_view_position.setText(position_account_view);
                account_view_position.setTextColor(getResources().getColor(R.color.blue));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //--Reading Data--//



        cardView_CSE_2103_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CT_KEY_NAME_OF_CT_CREATE_NAME="CSE 2103 : ";
                create_course_view_page_with_chapters.setVisibility(View.VISIBLE);
                tani_home_page.setVisibility(View.GONE);
                tani_account_view_page.setVisibility(View.GONE);
                TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                cse_2103_page.setVisibility(View.GONE);
                registered_member_view_page.setVisibility(View.GONE);
                //Teachers_list_view.setVisibility(View.GONE);
                Students_list_view.setVisibility(View.GONE);
                course_ct_page_view.setVisibility(View.GONE);
                couse_according_to_semester.setVisibility(View.GONE);
                //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                CT_LIST_VIEW.setVisibility(View.GONE);
                notification_page_view.setVisibility(View.GONE);
                notification_list_view.setVisibility(View.GONE);

            }
        });

        list_course_ct_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tani_home_page.setVisibility(View.GONE);
                tani_account_view_page.setVisibility(View.GONE);
                TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                cse_2103_page.setVisibility(View.GONE);
                registered_member_view_page.setVisibility(View.GONE);
                //Teachers_list_view.setVisibility(View.GONE);
                Students_list_view.setVisibility(View.GONE);
                course_ct_page_view.setVisibility(View.VISIBLE);
                couse_according_to_semester.setVisibility(View.GONE);
                create_course_view_page_with_chapters.setVisibility(View.GONE);
                //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                CT_LIST_VIEW.setVisibility(View.GONE);
                notification_page_view.setVisibility(View.GONE);
                notification_list_view.setVisibility(View.GONE);



            }
        });


        home_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tani_home_page.setVisibility(View.VISIBLE);
                tani_account_view_page.setVisibility(View.GONE);
                TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                cse_2103_page.setVisibility(View.GONE);
                registered_member_view_page.setVisibility(View.GONE);
                //Teachers_list_view.setVisibility(View.GONE);
                Students_list_view.setVisibility(View.GONE);
                course_ct_page_view.setVisibility(View.GONE);
                couse_according_to_semester.setVisibility(View.GONE);
                create_course_view_page_with_chapters.setVisibility(View.GONE);
               //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                CT_LIST_VIEW.setVisibility(View.GONE);
                notification_page_view.setVisibility(View.GONE);
                notification_list_view.setVisibility(View.GONE);


            }
        });

        account_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tani_account_view_page.setVisibility(View.VISIBLE);
                tani_home_page.setVisibility(View.GONE);
                TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                cse_2103_page.setVisibility(View.GONE);
                registered_member_view_page.setVisibility(View.GONE);
                //Teachers_list_view.setVisibility(View.GONE);
                Students_list_view.setVisibility(View.GONE);
                course_ct_page_view.setVisibility(View.GONE);
                couse_according_to_semester.setVisibility(View.GONE);
                create_course_view_page_with_chapters.setVisibility(View.GONE);
                //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                CT_LIST_VIEW.setVisibility(View.GONE);
                notification_page_view.setVisibility(View.GONE);
                notification_list_view.setVisibility(View.GONE);


            }
        });

        //list view will be added
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    TANI_CSE_HOME_PAGE.setVisibility(View.VISIBLE);
                    tani_home_page.setVisibility(View.GONE);
                    tani_account_view_page.setVisibility(View.GONE);
                    cse_2103_page.setVisibility(View.GONE);
                    registered_member_view_page.setVisibility(View.GONE);
                    //Teachers_list_view.setVisibility(View.GONE);
                    Students_list_view.setVisibility(View.GONE);
                    course_ct_page_view.setVisibility(View.GONE);
                    couse_according_to_semester.setVisibility(View.GONE);
                    create_course_view_page_with_chapters.setVisibility(View.GONE);
                    //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                    CT_LIST_VIEW.setVisibility(View.GONE);
                    notification_page_view.setVisibility(View.GONE);
                    notification_list_view.setVisibility(View.GONE);

                }
            }
        });
        list_view_2_course_ct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==2)
                {
                    couse_according_to_semester.setVisibility(View.VISIBLE);
                    TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                    tani_home_page.setVisibility(View.GONE);
                    tani_account_view_page.setVisibility(View.GONE);
                    cse_2103_page.setVisibility(View.GONE);
                    registered_member_view_page.setVisibility(View.GONE);
                    //Teachers_list_view.setVisibility(View.GONE);
                    Students_list_view.setVisibility(View.GONE);
                    course_ct_page_view.setVisibility(View.GONE);
                    create_course_view_page_with_chapters.setVisibility(View.GONE);
                    //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                    CT_LIST_VIEW.setVisibility(View.GONE);
                    notification_page_view.setVisibility(View.GONE);
                    notification_list_view.setVisibility(View.GONE);


                }
            }
        });


        teachers_class_mates_click_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registered_member_view_page.setVisibility(View.VISIBLE);
                tani_account_view_page.setVisibility(View.GONE);
                tani_home_page.setVisibility(View.GONE);
                TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                cse_2103_page.setVisibility(View.GONE);
                Students_list_view.setVisibility(View.GONE);
                Teachers_list_view.setVisibility(View.VISIBLE);
                course_ct_page_view.setVisibility(View.GONE);
                couse_according_to_semester.setVisibility(View.GONE);
                create_course_view_page_with_chapters.setVisibility(View.GONE);
                //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                CT_LIST_VIEW.setVisibility(View.GONE);
                notification_page_view.setVisibility(View.GONE);
                notification_list_view.setVisibility(View.GONE);



            }
        });
            Teachers_member_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Teachers_list_view.setVisibility(View.VISIBLE);
                    Students_list_view.setVisibility(View.GONE);
                    tani_account_view_page.setVisibility(View.GONE);
                    tani_home_page.setVisibility(View.GONE);
                    TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                    cse_2103_page.setVisibility(View.GONE);
                    course_ct_page_view.setVisibility(View.GONE);
                    couse_according_to_semester.setVisibility(View.GONE);
                    Teachers_member_click.setBackgroundColor(getResources().getColor(R.color.white));
                    Teachers_member_click.setTextColor(getResources().getColor(R.color.blue));
                    Students_member_click.setBackgroundColor(getResources().getColor(R.color.blue));
                    Students_member_click.setTextColor(getResources().getColor(R.color.white));
                    create_course_view_page_with_chapters.setVisibility(View.GONE);
                    //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                    CT_LIST_VIEW.setVisibility(View.GONE);
                    notification_page_view.setVisibility(View.GONE);
                    notification_list_view.setVisibility(View.GONE);



                }
            });
            Students_member_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Teachers_list_view.setVisibility(View.GONE);
                    Students_list_view.setVisibility(View.VISIBLE);
                    tani_account_view_page.setVisibility(View.GONE);
                    tani_home_page.setVisibility(View.GONE);
                    TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                    cse_2103_page.setVisibility(View.GONE);
                    course_ct_page_view.setVisibility(View.GONE);
                    couse_according_to_semester.setVisibility(View.GONE);
                    Students_member_click.setBackgroundColor(getResources().getColor(R.color.white));
                    Students_member_click.setTextColor(getResources().getColor(R.color.blue));
                    Teachers_member_click.setBackgroundColor(getResources().getColor(R.color.blue));
                    Teachers_member_click.setTextColor(getResources().getColor(R.color.white));
                    create_course_view_page_with_chapters.setVisibility(View.GONE);
                    //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                    CT_LIST_VIEW.setVisibility(View.GONE);
                    notification_page_view.setVisibility(View.GONE);
                    notification_list_view.setVisibility(View.GONE);



                }
            });


        CSE_2103_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registered_member_view_page.setVisibility(View.GONE);
                TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                tani_home_page.setVisibility(View.GONE);
                tani_account_view_page.setVisibility(View.GONE);
                cse_2103_page.setVisibility(View.VISIBLE);
                //Teachers_list_view.setVisibility(View.GONE);
                Students_list_view.setVisibility(View.GONE);
                course_ct_page_view.setVisibility(View.GONE);
                couse_according_to_semester.setVisibility(View.GONE);
                create_course_view_page_with_chapters.setVisibility(View.GONE);
                //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                CT_LIST_VIEW.setVisibility(View.GONE);
                notification_page_view.setVisibility(View.GONE);
                notification_list_view.setVisibility(View.GONE);




                if(position_account_view.equals("Cr")||position_account_view.equals("Teacher"))
                {
                    save_button.setVisibility(View.VISIBLE);
                }
                if(position_account_view.equals("Student"))
                {
                    checkBox1_2103.setClickable(false);
                    checkBox2_2103.setClickable(false);
                    checkBox3_2103.setClickable(false);
                    checkBox4_2103.setClickable(false);
                    checkBox5_2103.setClickable(false);
                    checkBox6_2103.setClickable(false);
                    checkBox7_2103.setClickable(false);
                    checkBox8_2103.setClickable(false);
                    checkBox9_2103.setClickable(false);
                    checkBox10_2103.setClickable(false);
                    checkBox11_2103.setClickable(false);
                    checkBox12_2103.setClickable(false);
                    checkBox13_2103.setClickable(false);
                    checkBox14_2103.setClickable(false);
                    checkBox15_2103.setClickable(false);
                    checkBox16_2103.setClickable(false);
                    checkBox17_2103.setClickable(false);
                    checkBox18_2103.setClickable(false);
                    checkBox19_2103.setClickable(false);
                    checkBox20_2103.setClickable(false);
                    checkBox21_2103.setClickable(false);
                    checkBox22_2103.setClickable(false);
                    checkBox23_2103.setClickable(false);
                    checkBox24_2103.setClickable(false);
                    checkBox25_2103.setClickable(false);
                    checkBox26_2103.setClickable(false);
                    checkBox27_2103.setClickable(false);
                    checkBox29_2103.setClickable(false);
                    checkBox30_2103.setClickable(false);
                    checkBox31_2103.setClickable(false);
                    checkBox32_2103.setClickable(false);
                    checkBox33_2103.setClickable(false);
                    checkBox34_2103.setClickable(false);
                    checkBox35_2103.setClickable(false);
                    checkBox36_2103.setClickable(false);
                    checkBox37_2103.setClickable(false);
                    checkBox38_2103.setClickable(false);

                }
            }
        });



        cb1 = checkBox1_2103.getText().toString();
        cb2 = checkBox2_2103.getText().toString();
        cb3 = checkBox3_2103.getText().toString();
        cb4 = checkBox4_2103.getText().toString();
        cb5 = checkBox5_2103.getText().toString();
        cb6 = checkBox6_2103.getText().toString();
        cb7 = checkBox7_2103.getText().toString();
        cb8 = checkBox8_2103.getText().toString();
        cb9 = checkBox9_2103.getText().toString();
        cb38 = checkBox38_2103.getText().toString();
        cb10=checkBox10_2103.getText().toString();
        cb11=checkBox11_2103.getText().toString();
        cb12=checkBox12_2103.getText().toString();
        cb13=checkBox13_2103.getText().toString();
        cb14=checkBox14_2103.getText().toString();
        cb15=checkBox15_2103.getText().toString();
        cb16=checkBox16_2103.getText().toString();
        cb17=checkBox17_2103.getText().toString();
        cb18=checkBox18_2103.getText().toString();
        cb19=checkBox19_2103.getText().toString();
        cb20=checkBox20_2103.getText().toString();
        cb21=checkBox21_2103.getText().toString();
        cb22=checkBox22_2103.getText().toString();
        cb23=checkBox23_2103.getText().toString();
        cb24=checkBox24_2103.getText().toString();
        cb25=checkBox25_2103.getText().toString();
        cb26=checkBox26_2103.getText().toString();
        cb27=checkBox27_2103.getText().toString();
        cb28=checkBox28_2103.getText().toString();
        cb29=checkBox29_2103.getText().toString();
        cb30=checkBox30_2103.getText().toString();
        cb31=checkBox31_2103.getText().toString();
        cb32=checkBox32_2103.getText().toString();
        cb33=checkBox33_2103.getText().toString();
        cb34=checkBox34_2103.getText().toString();
        cb35=checkBox35_2103.getText().toString();
        cb36=checkBox36_2103.getText().toString();
        cb37=checkBox37_2103.getText().toString();


        //CT-Check_box_string
        CT_cb1=CT_Check_Box_1.getText().toString();
        CT_cb2=CT_Check_Box_2.getText().toString();
        CT_cb3=CT_Check_Box_3.getText().toString();
        CT_cb4=CT_Check_Box_4.getText().toString();
        CT_cb5=CT_Check_Box_5.getText().toString();
        CT_cb6=CT_Check_Box_6.getText().toString();
        CT_cb7=CT_Check_Box_7.getText().toString();
        CT_cb8=CT_Check_Box_8.getText().toString();
        CT_cb9=CT_Check_Box_9.getText().toString();
        CT_cb10=CT_Check_Box_10.getText().toString();

        //CT-Check_box_string

        CT_Chlid_READ.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot2 : snapshot.getChildren())
                {

                    if(snapshot2.getKey().contains("_b"))
                    {
                        New_Line=snapshot2.getKey().replace("_b","\n");
                        list5.add(New_Line);
                        list7.add(New_Line);
                    }
                    KEY_NAME_CT = snapshot2.getKey();
                    if (CT_cb1.equals(snapshot2.child("1").getValue()))
                        list5.add(CT_cb1);
                    if (CT_cb2.equals(snapshot2.child("2").getValue()))
                        list5.add(CT_cb2);
                    if (CT_cb3.equals(snapshot2.child("3").getValue()))
                        list5.add(CT_cb3);
                    if (CT_cb4.equals(snapshot2.child("4").getValue()))
                        list5.add(CT_cb4);
                    if (CT_cb5.equals(snapshot2.child("5").getValue()))
                        list5.add(CT_cb1);
                    if (CT_cb6.equals(snapshot2.child("6").getValue()))
                        list5.add(CT_cb6);
                    if (CT_cb7.equals(snapshot2.child("7").getValue()))
                        list5.add(CT_cb7);
                    if (CT_cb8.equals(snapshot2.child("8").getValue()))
                        list5.add(CT_cb8);
                    if (CT_cb9.equals(snapshot2.child("9").getValue()))
                        list5.add(CT_cb9);
                    if (CT_cb10.equals(snapshot2.child("10").getValue()))
                        list5.add(CT_cb10);
                    System.out.println(snapshot2.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        /*Notification_child_read.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Notification_Count= Math.toIntExact(snapshot.getChildrenCount());
                for(int v=0;v<=Notification_Count;v++)
                {
                    list6.add((String) snapshot.child(String.valueOf(v)).getValue());
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        //----DialogBox Code-----//

        Create_CT_Syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(position_account_view.equals("Teacher") || position_account_view.equals("CR")){
                AlertDialog.Builder my_first_dialog=new AlertDialog.Builder(MainActivity4.this);
                my_first_dialog.setTitle("Enter the CT Number/CT Name");

                final EditText CT_Input=new EditText(MainActivity4.this);
                CT_Input.setInputType(InputType.TYPE_CLASS_TEXT);
                my_first_dialog.setView(CT_Input);

                my_first_dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        round_view.setVisibility(View.VISIBLE);
                        CT_NAME = CT_Input.getText().toString();
                        CT_NAME=CT_NAME+"_b";
                        currentTime = Calendar.getInstance().getTime();

                        CT_KEY_NAME_OF_CT_CREATE_NAME=CT_KEY_NAME_OF_CT_CREATE_NAME+CT_NAME+currentTime+"_b";
                        if (CT_Check_Box_1.isChecked() || CT_Check_Box_2.isChecked() || CT_Check_Box_3.isChecked() || CT_Check_Box_4.isChecked() || CT_Check_Box_5.isChecked() || CT_Check_Box_6.isChecked() || CT_Check_Box_7.isChecked() || CT_Check_Box_8.isChecked() || CT_Check_Box_9.isChecked() || CT_Check_Box_10.isChecked())
                        {
                            Toast.makeText(MainActivity4.this, "You have created a CT syllabus named :" + CT_NAME, Toast.LENGTH_SHORT).show();
                            //Notification_Child.child(USER_UID).child("K").setValue("Hello");
                            Notification_child_read.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot child: snapshot.getChildren()) {
                                        child.getRef().updateChildren(update);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

                            //Notification_Count=Notification_Count+1;
                        }
                        else
                            Toast.makeText(MainActivity4.this, "You have to select a chapter first", Toast.LENGTH_SHORT).show();

                        if (CT_Check_Box_1.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("1").setValue(CT_cb1);
                            CT_Check_Box_1.setChecked(false);
                        }
                        if (CT_Check_Box_2.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("2").setValue(CT_cb2);
                            CT_Check_Box_2.setChecked(false);

                        }
                        if (CT_Check_Box_3.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("3").setValue(CT_cb3);
                            CT_Check_Box_3.setChecked(false);
                        }
                        if (CT_Check_Box_4.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("4").setValue(CT_cb4);
                            CT_Check_Box_4.setChecked(false);
                        }
                        if (CT_Check_Box_5.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("5").setValue(CT_cb5);
                            CT_Check_Box_5.setChecked(false);
                        }
                        if (CT_Check_Box_6.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("6").setValue(CT_cb6);
                            CT_Check_Box_6.setChecked(false);
                        }
                        if (CT_Check_Box_7.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("1").setValue(CT_cb7);
                            CT_Check_Box_7.setChecked(false);
                        }
                        if (CT_Check_Box_8.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("1").setValue(CT_cb8);
                            CT_Check_Box_8.setChecked(false);
                        }
                        if (CT_Check_Box_9.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("1").setValue(CT_cb9);
                            CT_Check_Box_9.setChecked(false);
                        }
                        if (CT_Check_Box_10.isChecked()) {
                            CT_Child.child(CT_KEY_NAME_OF_CT_CREATE_NAME).child("1").setValue(CT_cb10);
                            CT_Check_Box_10.setChecked(false);
                        }
                        list5.clear();
                        list7.clear();
                        CT_Chlid_READ.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot snapshot2 : snapshot.getChildren())
                                {
                                    if(snapshot2.getKey().contains("_b"))
                                    {
                                     New_Line=snapshot2.getKey().replace("_b","\n");
                                    list5.add(New_Line);
                                    list7.add(New_Line);
                                    }
                                    System.out.println(list7.size()+"sizesizesizesizesizee");
                                    KEY_NAME_CT = snapshot2.getKey();
                                    if (CT_cb1.equals(snapshot2.child("1").getValue()))
                                        list5.add(CT_cb1);
                                    if (CT_cb2.equals(snapshot2.child("2").getValue()))
                                        list5.add(CT_cb2);
                                    if (CT_cb3.equals(snapshot2.child("3").getValue()))
                                        list5.add(CT_cb3);
                                    if (CT_cb4.equals(snapshot2.child("4").getValue()))
                                        list5.add(CT_cb4);
                                    if (CT_cb5.equals(snapshot2.child("5").getValue()))
                                        list5.add(CT_cb1);
                                    if (CT_cb6.equals(snapshot2.child("6").getValue()))
                                        list5.add(CT_cb6);
                                    if (CT_cb7.equals(snapshot2.child("7").getValue()))
                                        list5.add(CT_cb7);
                                    if (CT_cb8.equals(snapshot2.child("8").getValue()))
                                        list5.add(CT_cb8);
                                    if (CT_cb9.equals(snapshot2.child("9").getValue()))
                                        list5.add(CT_cb9);
                                    if (CT_cb10.equals(snapshot2.child("10").getValue()))
                                        list5.add(CT_cb10);
                                    System.out.println(snapshot2.getKey());
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                        /*if (position_account_view.equals("Student") || position_account_view.equals("CR")) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                NotificationChannel channel = new NotificationChannel("n", "n", NotificationManager.IMPORTANCE_DEFAULT);
                                NotificationManager manager = getSystemService(NotificationManager.class);
                                manager.createNotificationChannel(channel);
                            }
                            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity4.this, "n");
                            builder.setContentText("Hello");
                            builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
                            builder.setAutoCancel(true);
                            builder.setContentText("New data is added");
                            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity4.this);
                            managerCompat.notify(999, builder.build());
                        }*/
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();


                    }
                });//Point
                my_first_dialog.show();
            }
                else
                {

                    Toast.makeText(MainActivity4.this, "You are not allowed", Toast.LENGTH_SHORT).show();

                }
            }

        });

        adapter5=new ArrayAdapter<>(this, R.layout.row, list5);
        CT_LIST_VIEW.setAdapter(adapter5);

        adapter7=new ArrayAdapter<>(this, R.layout.row, list7);
        notification_list_view.setAdapter(adapter7);

        Observe_Course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                CT_LIST_VIEW.setVisibility(View.GONE);
                Observe_Course.setBackgroundColor(getResources().getColor(R.color.white));
                Observe_Course.setTextColor(getResources().getColor(R.color.blue));
                CT.setBackgroundColor(getResources().getColor(R.color.blue));
                CT.setTextColor(getResources().getColor(R.color.white));



            }
        });
        CT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CT_SCROLL_VIEW.setVisibility(View.GONE);
                CT_LIST_VIEW.setVisibility(View.VISIBLE);
                Observe_Course.setBackgroundColor(getResources().getColor(R.color.blue));
                Observe_Course.setTextColor(getResources().getColor(R.color.white));
                CT.setBackgroundColor(getResources().getColor(R.color.white));
                CT.setTextColor(getResources().getColor(R.color.blue));



            }
        });
        notification_click_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification_Child.child(USER_UID).child("K").setValue("Bye");
                notification_page_view.setVisibility(View.VISIBLE);
                notification_list_view.setVisibility(View.VISIBLE);
                tani_home_page.setVisibility(View.GONE);
                tani_account_view_page.setVisibility(View.GONE);
                TANI_CSE_HOME_PAGE.setVisibility(View.GONE);
                cse_2103_page.setVisibility(View.GONE);
                registered_member_view_page.setVisibility(View.GONE);
                //Teachers_list_view.setVisibility(View.GONE);
                Students_list_view.setVisibility(View.GONE);
                course_ct_page_view.setVisibility(View.GONE);
                couse_according_to_semester.setVisibility(View.GONE);
                create_course_view_page_with_chapters.setVisibility(View.GONE);
                //CT_SCROLL_VIEW.setVisibility(View.VISIBLE);
                CT_LIST_VIEW.setVisibility(View.GONE);
                round_view.setVisibility(View.GONE);

            }
        });
        Selected_Chapter.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    i = (int) snapshot.getChildrenCount();
                    System.out.println("kkkkkkkkkkkkkkkkk"+i+"kkkkkkkkkkkkkkkkkkkkkk");



                        if(cb1.equals(snapshot.child("1").getValue(String.class)))
                        {
                        checkBox1_2103.setChecked(true);
                        flag1=1;
                        }
                        if(cb2.equals(snapshot.child("2").getValue(String.class)))
                        {
                            checkBox2_2103.setChecked(true);
                            flag2=2;
                        }
                        if(cb3.equals(snapshot.child("3").getValue(String.class)))
                        {
                            checkBox3_2103.setChecked(true);
                            flag3=3;
                        }
                        if(cb4.equals(snapshot.child("4").getValue(String.class)))
                        {
                            checkBox4_2103.setChecked(true);
                            flag4=4;
                        }
                        if(cb5.equals(snapshot.child("5").getValue(String.class)))
                        {
                            checkBox5_2103.setChecked(true);
                            flag5=5;
                        }
                        if(cb6.equals(snapshot.child("6").getValue(String.class)))
                        {
                            checkBox6_2103.setChecked(true);
                            flag6=6;
                        }
                        if(cb7.equals(snapshot.child("7").getValue(String.class)))
                        {
                            checkBox7_2103.setChecked(true);
                            flag7=7;
                        }
                        if(cb8.equals(snapshot.child("8").getValue(String.class)))
                        {
                        checkBox8_2103.setChecked(true);
                        flag8=8;
                        }
                        if(cb9.equals(snapshot.child("9").getValue(String.class)))
                        {
                            checkBox9_2103.setChecked(true);
                            flag9=9;
                        }
                        if(cb38.equals(snapshot.child("38").getValue(String.class)))
                        {
                            checkBox38_2103.setChecked(true);
                            flag38=38;
                        }
                        if(cb10.equals(snapshot.child("10").getValue(String.class)))
                        {
                            checkBox10_2103.setChecked(true);
                            flag10=10;
                        }
                        if(cb11.equals(snapshot.child("11").getValue(String.class)))
                        {
                            checkBox11_2103.setChecked(true);
                            flag11=11;
                        }
                        if(cb12.equals(snapshot.child("12").getValue(String.class)))
                        {
                            checkBox12_2103.setChecked(true);
                            flag12=12;
                        }
                        if(cb13.equals(snapshot.child("13").getValue(String.class)))
                        {
                            checkBox13_2103.setChecked(true);
                            flag13=13;
                        }
                        if(cb14.equals(snapshot.child("14").getValue(String.class)))
                        {
                            checkBox14_2103.setChecked(true);
                            flag14=14;
                        }
                        if(cb15.equals(snapshot.child("15").getValue(String.class)))
                        {
                            checkBox15_2103.setChecked(true);
                            flag15=15;
                        }
                        if(cb16.equals(snapshot.child("16").getValue(String.class)))
                        {
                            checkBox16_2103.setChecked(true);
                            flag16=16;
                        }
                        if(cb17.equals(snapshot.child("17").getValue(String.class)))
                        {
                            checkBox17_2103.setChecked(true);
                            flag17=17;
                        }
                        if(cb18.equals(snapshot.child("18").getValue(String.class)))
                        {
                            checkBox18_2103.setChecked(true);
                            flag18=18;
                        }
                        if(cb19.equals(snapshot.child("19").getValue(String.class)))
                        {
                            checkBox19_2103.setChecked(true);
                            flag19=19;
                        }
                        if(cb20.equals(snapshot.child("20").getValue(String.class)))
                        {
                            checkBox20_2103.setChecked(true);
                            flag20=20;
                        }
                        if(cb21.equals(snapshot.child("21").getValue(String.class)))
                        {
                            checkBox21_2103.setChecked(true);
                            flag21=21;
                        }
                        if(cb22.equals(snapshot.child("22").getValue(String.class)))
                        {
                            checkBox22_2103.setChecked(true);
                            flag22=22;
                        }
                        if(cb23.equals(snapshot.child("23").getValue(String.class)))
                        {
                            checkBox23_2103.setChecked(true);
                            flag23=23;
                        }
                        if(cb24.equals(snapshot.child("24").getValue(String.class)))
                        {
                            checkBox24_2103.setChecked(true);
                            flag24=24;
                        }
                        if(cb25.equals(snapshot.child("25").getValue(String.class)))
                        {
                            checkBox25_2103.setChecked(true);
                            flag25=25;
                        }
                        if(cb26.equals(snapshot.child("26").getValue(String.class)))
                        {
                            checkBox26_2103.setChecked(true);
                            flag26=26;
                        }
                        if(cb27.equals(snapshot.child("27").getValue(String.class)))
                        {
                            checkBox27_2103.setChecked(true);
                            flag27=27;
                        }
                        if(cb28.equals(snapshot.child("28").getValue(String.class)))
                        {
                            checkBox28_2103.setChecked(true);
                            flag28=28;
                        }
                        if(cb29.equals(snapshot.child("29").getValue(String.class)))
                        {
                            checkBox29_2103.setChecked(true);
                            flag29=29;
                        }
                        if(cb30.equals(snapshot.child("30").getValue(String.class)))
                        {
                            checkBox30_2103.setChecked(true);
                            flag30=30;
                        }
                        if(cb31.equals(snapshot.child("31").getValue(String.class)))
                        {
                            checkBox31_2103.setChecked(true);
                            flag31=31;
                        }
                        if(cb32.equals(snapshot.child("32").getValue(String.class)))
                        {
                            checkBox32_2103.setChecked(true);
                            flag32=32;
                        }
                        if(cb33.equals(snapshot.child("33").getValue(String.class)))
                        {
                            checkBox33_2103.setChecked(true);
                            flag33=33;
                        }
                        if(cb34.equals(snapshot.child("34").getValue(String.class)))
                        {
                            checkBox34_2103.setChecked(true);
                            flag34=34;
                        }
                        if(cb35.equals(snapshot.child("35").getValue(String.class)))
                        {
                            checkBox35_2103.setChecked(true);
                            flag35=35;
                        }
                        if(cb36.equals(snapshot.child("36").getValue(String.class)))
                        {
                            checkBox36_2103.setChecked(true);
                            flag36=36;
                        }
                        if(cb37.equals(snapshot.child("37").getValue(String.class)))
                        {
                            checkBox37_2103.setChecked(true);
                            flag37=37;
                        }


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        final HashMap<Integer, String> map_2 = new HashMap<>();
            //save_button.setVisibility(View.VISIBLE);
            save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity4.this, "You have clicked", Toast.LENGTH_SHORT).show();


                if (checkBox1_2103.isChecked()) {
                    //cb1=checkBox1_2103.getText().toString();
                    map_2.put(map_2.size() + i + 1, cb1);
                    if(flag1==0)
                    {
                    Selected_Chapter.child(String.valueOf("1")).setValue(cb1);
                    }
                }
                else
                {
                Selected_Chapter.child("1").removeValue();
                flag1=0;
                }
                if (checkBox2_2103.isChecked())
                {
                    //cb2=checkBox2_2103.getText().toString();
                    map_2.put(map_2.size() + i + 1, cb2);
                    if(flag2==0)
                    {
                    Selected_Chapter.child(String.valueOf("2")).setValue(cb2);
                    }
                }
                else
                {
                    Selected_Chapter.child(String.valueOf("2")).removeValue();
                    flag2=0;
                }
                if (checkBox3_2103.isChecked())
                {
                    //cb3=checkBox3_2103.getText().toString();
                    map_2.put(map_2.size() + i + 1, cb3);
                    if(flag3==0)
                    {
                    Selected_Chapter.child(String.valueOf("3")).setValue(cb3);
                    }
                }
                else
                {
                    Selected_Chapter.child(String.valueOf("3")).removeValue();
                    flag3=0;
                }
                if (checkBox4_2103.isChecked())
                {
                    //cb4=checkBox4_2103.getText().toString();
                    map_2.put(map_2.size() + i + 1, cb3);
                    if(flag4==0)
                    {
                    Selected_Chapter.child(String.valueOf("4")).setValue(cb4);
                    }
                }
                else
                {
                    Selected_Chapter.child("4").removeValue();
                    flag4=0;
                }
                if (checkBox5_2103.isChecked()) {
                    //cb5=checkBox5_2103.getText().toString();
                    map_2.put(map_2.size() + i + 1, cb5);
                    if(flag5==0)
                    {
                    Selected_Chapter.child(String.valueOf("5")).setValue(cb5);
                    }
                }
                else
                {
                    Selected_Chapter.child("5").removeValue();
                    flag5=0;
                }
                if (checkBox6_2103.isChecked()) {
                    //cb6=checkBox6_2103.getText().toString();
                    map_2.put(map_2.size() + i + 1, cb6);
                    if(flag6==0)
                    {
                    Selected_Chapter.child("6").setValue(cb6);
                    }
                }
                else
                {
                    Selected_Chapter.child("6").removeValue();
                    flag6=0;
                }
                if (checkBox7_2103.isChecked()) {
                    //cb7=checkBox7_2103.getText().toString();
                    map_2.put(map_2.size() + i + 1, cb7);
                    if(flag7==0)
                    {

                    Selected_Chapter.child(String.valueOf("7")).setValue(cb7);
                    }
                }
                else
                {
                    Selected_Chapter.child("7").removeValue();
                    flag7=0;
                }
                if (checkBox8_2103.isChecked()) {
                    map_2.put(map_2.size() + i + 1, cb8);
                    if(flag8==0)
                    {
                    Selected_Chapter.child("8").setValue(cb8);
                    }
                }
                else
                {
                    Selected_Chapter.child("8").removeValue();
                    flag8=0;
                }
                if (checkBox9_2103.isChecked()) {
                    map_2.put(map_2.size() + i + 1, cb9);
                    if(flag9==0)
                    {
                    Selected_Chapter.child("9").setValue(cb9);
                    }
                }
                else
                {
                    Selected_Chapter.child("9").removeValue();
                    flag9=0;
                }
                if (checkBox38_2103.isChecked()) {
                    map_2.put(map_2.size() + i + 1, cb38);
                    if(flag38==0)
                    {
                    Selected_Chapter.child("38").setValue(cb38);
                    }
                }
                else
                {
                    Selected_Chapter.child("38").removeValue();
                    flag38=0;
                }
                if (checkBox10_2103.isChecked())
                {
                    if(flag10==0)
                    {
                        Selected_Chapter.child("10").setValue(cb10);
                    }
                }
                else
                {
                    Selected_Chapter.child("10").removeValue();
                    flag10=0;
                }
                if (checkBox11_2103.isChecked()) {

                    if(flag11==0)
                    {
                        Selected_Chapter.child("11").setValue(cb11);
                    }
                }
                else
                {
                    Selected_Chapter.child("11").removeValue();
                    flag11=0;
                }
                if (checkBox12_2103.isChecked()) {

                    if(flag12==0)
                    {
                        Selected_Chapter.child("12").setValue(cb12);
                    }
                }
                else
                {
                    Selected_Chapter.child("12").removeValue();
                    flag12=0;
                }
                if (checkBox13_2103.isChecked()) {

                    if(flag13==0)
                    {
                        Selected_Chapter.child("13").setValue(cb13);
                    }
                }
                else
                {
                    Selected_Chapter.child("13").removeValue();
                    flag13=0;
                }
                if (checkBox14_2103.isChecked()) {

                    if(flag14==0)
                    {
                        Selected_Chapter.child("14").setValue(cb14);
                    }
                }
                else
                {
                    Selected_Chapter.child("14").removeValue();
                    flag14=0;
                }
                if (checkBox15_2103.isChecked()) {

                    if(flag15==0)
                    {
                        Selected_Chapter.child("15").setValue(cb13);
                    }
                }
                else
                {
                    Selected_Chapter.child("15").removeValue();
                    flag15=0;
                }
                if (checkBox16_2103.isChecked()) {

                    if(flag16==0)
                    {
                        Selected_Chapter.child("16").setValue(cb16);
                    }
                }
                else
                {
                    Selected_Chapter.child("16").removeValue();
                    flag16=0;
                }
                if (checkBox17_2103.isChecked()) {

                    if(flag17==0)
                    {
                        Selected_Chapter.child("17").setValue(cb17);
                    }
                }
                else
                {
                    Selected_Chapter.child("17").removeValue();
                    flag17=0;
                }
                if (checkBox18_2103.isChecked()) {

                    if(flag18==0)
                    {
                        Selected_Chapter.child("18").setValue(cb18);
                    }
                }
                else
                {
                    Selected_Chapter.child("18").removeValue();
                    flag18=0;
                }
                if (checkBox19_2103.isChecked()) {

                    if(flag19==0)
                    {
                        Selected_Chapter.child("19").setValue(cb19);
                    }
                }
                else
                {
                    Selected_Chapter.child("19").removeValue();
                    flag19=0;
                }
                if (checkBox20_2103.isChecked()) {

                    if(flag20==0)
                    {
                        Selected_Chapter.child("20").setValue(cb20);
                    }
                }
                else
                {
                    Selected_Chapter.child("20").removeValue();
                    flag20=0;
                }
                if (checkBox21_2103.isChecked()) {

                    if(flag21==0)
                    {
                        Selected_Chapter.child("21").setValue(cb21);
                    }
                }
                else
                {
                    Selected_Chapter.child("21").removeValue();
                    flag21=0;
                }
                if (checkBox22_2103.isChecked()) {

                    if(flag22==0)
                    {
                        Selected_Chapter.child("22").setValue(cb22);
                    }
                }
                else
                {
                    Selected_Chapter.child("22").removeValue();
                    flag22=0;
                }
                if (checkBox23_2103.isChecked()) {

                    if(flag23==0)
                    {
                        Selected_Chapter.child("23").setValue(cb23);
                    }
                }
                else
                {
                    Selected_Chapter.child("23").removeValue();
                    flag23=0;
                }
                if (checkBox24_2103.isChecked()) {

                    if(flag24==0)
                    {
                        Selected_Chapter.child("24").setValue(cb24);
                    }
                }
                else
                {
                    Selected_Chapter.child("24").removeValue();
                    flag24=0;
                }
                if (checkBox25_2103.isChecked()) {

                    if(flag25==0)
                    {
                        Selected_Chapter.child("25").setValue(cb25);
                    }
                }
                else
                {
                    Selected_Chapter.child("25").removeValue();
                    flag25=0;
                }
                if (checkBox26_2103.isChecked()) {

                    if(flag26==0)
                    {
                        Selected_Chapter.child("26").setValue(cb26);
                    }
                }
                else
                {
                    Selected_Chapter.child("26").removeValue();
                    flag26=0;
                }
                if (checkBox27_2103.isChecked()) {

                    if(flag27==0)
                    {
                        Selected_Chapter.child("27").setValue(cb27);
                    }
                }
                else
                {
                    Selected_Chapter.child("27").removeValue();
                    flag27=0;
                }
                if (checkBox28_2103.isChecked()) {

                    if(flag28==0)
                    {
                        Selected_Chapter.child("28").setValue(cb28);
                    }
                }
                else
                {
                    Selected_Chapter.child("28").removeValue();
                    flag28=0;
                }
                if (checkBox29_2103.isChecked()) {

                    if(flag29==0)
                    {
                        Selected_Chapter.child("29").setValue(cb29);
                    }
                }
                else
                {
                    Selected_Chapter.child("29").removeValue();
                    flag29=0;
                }
                if (checkBox30_2103.isChecked()) {

                    if(flag30==0)
                    {
                        Selected_Chapter.child("30").setValue(cb30);
                    }
                }
                else
                {
                    Selected_Chapter.child("30").removeValue();
                    flag30=0;
                }
                if (checkBox31_2103.isChecked()) {

                    if(flag31==0)
                    {
                        Selected_Chapter.child("31").setValue(cb31);
                    }
                }
                else
                {
                    Selected_Chapter.child("31").removeValue();
                    flag31=0;
                }
                if (checkBox32_2103.isChecked()) {

                    if(flag32==0)
                    {
                        Selected_Chapter.child("32").setValue(cb32);
                    }
                }
                else
                {
                    Selected_Chapter.child("32").removeValue();
                    flag32=0;
                }
                if (checkBox33_2103.isChecked()) {

                    if(flag33==0)
                    {
                        Selected_Chapter.child("33").setValue(cb33);
                    }
                }
                else
                {
                    Selected_Chapter.child("33").removeValue();
                    flag33=0;
                }
                if (checkBox34_2103.isChecked()) {

                    if(flag34==0)
                    {
                        Selected_Chapter.child("34").setValue(cb34);
                    }
                }
                else
                {
                    Selected_Chapter.child("34").removeValue();
                    flag34=0;
                }
                if (checkBox35_2103.isChecked()) {

                    if(flag35==0)
                    {
                        Selected_Chapter.child("35").setValue(cb35);
                    }
                }
                else
                {
                    Selected_Chapter.child("35").removeValue();
                    flag35=0;
                }
                if (checkBox36_2103.isChecked()) {

                    if(flag36==0)
                    {
                        Selected_Chapter.child("36").setValue(cb36);
                    }
                }
                else
                {
                    Selected_Chapter.child("36").removeValue();
                    flag36=0;
                }
                if (checkBox37_2103.isChecked()) {

                    if(flag37==0)
                    {
                        Selected_Chapter.child("37").setValue(cb37);
                    }
                }
                else
                {
                    Selected_Chapter.child("37").removeValue();
                    flag37=0;
                }




            }
        });





        sharedPreferenceConfig=new SharedPreferenceConfig(getApplicationContext());
        Log_Out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferenceConfig.login_status(false);
                //firebaseAuth.signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_search_view,menu);

        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}