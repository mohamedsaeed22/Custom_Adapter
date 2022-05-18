package com.example.adapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity_For_Exercise extends AppCompatActivity {

    final int REQUEST_CODE_ADD = 1;
    ListView lv_profile;
    Button btn_add_profile;
    Adapter_For_Exercise adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ativity_for_exersise);

        lv_profile = findViewById(R.id.lv_profile);
        btn_add_profile = findViewById(R.id.btn_add_profile);

        ArrayList<Data_For_Exercise> data = new ArrayList<>();

        //        data.add(new Data_For_Exercise("10/5/2000","Mohamed",
        //                "Welcome to My Profile",100,50,800));
        //
        //        data.add(new Data_For_Exercise("15/8/2021","Ali",
        //                "Welcome to My Profile 2",800,90,80));
        //
        //        data.add(new Data_For_Exercise("13/7/2024","Samy",
        //                "Welcome to My Profile 3",80,70,870));

        adapter = new Adapter_For_Exercise(this, R.layout.activity_exercise_for_adapter, data);
        lv_profile.setAdapter(adapter);

        btn_add_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Add_Profile_Activity.class);

                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD) {

            Data_For_Exercise post = (Data_For_Exercise) data.getSerializableExtra("data");
            adapter.addItem(post);
            adapter.notifyDataSetChanged();

        }
    }
}