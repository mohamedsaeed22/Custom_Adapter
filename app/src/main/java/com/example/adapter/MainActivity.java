package com.example.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;                // ممكن اخليها جريد فيو او اسبينر من غير م اعدل حاجه فى الكود كمان
    EditText et_add;
    Button btn_add;
    CustomAdapter adapter;
    int positionUpdate = -1;     //عشان اضمن ان مفيش حاجه تكون متحدده

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        et_add = findViewById(R.id.et_add);
        btn_add = findViewById(R.id.btn_add);

        ArrayList<String> names = new ArrayList<String>();
        names.add("Ali");
        names.add("mohamed");
        names.add("Ahmed");
        names.add("Mostafa");
        names.add("Ali");
        names.add("mohamed");
        names.add("Ahmed");
        names.add("Mostafa");

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);
//        adapter = new CustomAdapter(this,android.R.layout.simple_list_item_1 ,names);  // ArrayAdapter

        adapter = new CustomAdapter(this, names);                          // BaseAdapter

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String getItem = adapter.getItem(position);
                et_add.setText(getItem);

                positionUpdate = position;
                btn_add.setText("Update");

//                Toast.makeText(getBaseContext(), getItem+position, Toast.LENGTH_SHORT).show();

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_add.getText().toString().equals("")) {

                    Toast.makeText(getBaseContext(), "Enter valid Value ", Toast.LENGTH_SHORT).show();

                } else {

                    if (positionUpdate >= 0) {

                        adapter.setItem(positionUpdate, et_add.getText().toString());
                        btn_add.setText("Add");
                        positionUpdate = -1;      //عشان يخرج من الحاله الى هو وفيها ويعمل اضافه عادى

                    } else {
                        adapter.addItem(et_add.getText().toString());

                    }
                    et_add.setText("");
                    adapter.notifyDataSetChanged(); //عشان يحدث الليست علول ميستناش لحد م اعمل اسكرول

                }
            }
        });


    }

}