package com.example.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Profile_Activity extends AppCompatActivity {

    EditText et_name ,et_body ,et_followers ,et_following ,et_date , et_posts ;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        et_date = findViewById(R.id.et_date);
        et_name = findViewById(R.id.et_name);
        et_followers = findViewById(R.id.et_followers);
        et_following = findViewById(R.id.et_Following);
        et_posts = findViewById(R.id.et_posts);
        et_body = findViewById(R.id.et_body);
        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String body = et_body.getText().toString();
                String date = et_date.getText().toString();
                int followers = Integer.parseInt(et_followers.getText().toString());
                int following = Integer.parseInt(et_following.getText().toString());
                int posts = Integer.parseInt(et_posts.getText().toString());

                //هجمع البيانات فى اوبجيكت وابعتها افضل
                // بخلى الكلاس امبليمنت من serializable عشان
                Data_For_Exercise data = new Data_For_Exercise(date,name,body,followers,posts,following);

                Intent intent = new Intent();

// بخلى الكلاس امبليمنت من serializable عشان ابعتله اوبجيكت فيتحول ل استرنج بطريقه كويسه فى الكلاس اروح استقبله انا اوبجيكت زى م بعته فى الاكتيفتى التانيه
//او ممكن استحدم طريقه الانتنت العاديه put لكل متغير عادى واستخدم ActivityForResult


                intent.putExtra("data" ,data);
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }
}