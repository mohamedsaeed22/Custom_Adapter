package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

 public class CustomAdapter extends BaseAdapter {    // ArrayAdapter تحت



     private Context c;                              // عشان لما استقبل الداتا من الكونستراكتر احطهم فيهم عشان اقدر استخدمهم فى الفانكشن الى تحت
     private ArrayList<String> data;
     private int resource;                // عشان لو المستخدم حب يبعت التصميم

    public CustomAdapter(Context c , int resource,  ArrayList<String>data){
        this.c = c;
        this.data = data;
        this.resource = resource;

    }
    public CustomAdapter(Context c ,  ArrayList<String>data){
        this.c=c;
        this.data=data;

    }

    public void addItem(String item){
        data.add(item);
    }
     public void setItem(int pos,String item){
         data.set(pos,item);
     }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v =convertView;

        if (v==null){        //لو مفيش فيو او اى حاجه معروضه اعرضلى

            // عشان اعمل عرض ل layout تحويله من  xml ل كود LayoutInflater ----- java
            //null -- false  عشان مربطوش مع حد (الاب) عشان لما ارجع الفيو ميحصلش مشكله لانه مربوط قبل كده
            // c الكونتكست المبعوت لى

          v =  LayoutInflater.from(c).inflate(android.R.layout.simple_list_item_1,null,false);

        }

        // android.R.layout.simple_list_item_1  عشان انا مستخدم وهو موجود جوا  text1
       // v.findViewById(android.R.id.text1) ابحث عن العنصر دا الموجود فى  v

        TextView textView = v.findViewById(android.R.id.text1);

        String name = data.get(position);

        textView.setText(name);


        return v;
    }
}


//   -------------- ArrayAdapter --------------
//
// public class CustomAdapter extends ArrayAdapter<String> {
//
//    Context c;                              // عشان لما استقبل الداتا من الكونستراكتر احطهم فيهم عشان اقدر استخدمهم فى الفانكشن الى تحت
//    ArrayList<String> data;
//    int resource;                // عشان لو المستخدم حب يبعت التصميم
//
//    public CustomAdapter(Context c , int resource,  ArrayList<String> data){
//        super(c,resource,data);
//        this.c = c;
//        this.data = data;
//        this.resource = resource;
//
//    }
//
//    public void addItem(String item){
//        data.add(item);
//    }
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View v =convertView;
//
//        if (v==null){        //لو مفيش فيو او اى حاجه معروضه اعرضلى
//
//            // عشان اعمل عرض ل layout تحويله من  xml ل كود LayoutInflater ----- java
//            //null -- false  عشان مربطوش مع حد (الاب) عشان لما ارجع الفيو ميحصلش مشكله لانه مربوط قبل كده
//            // c الكونتكست المبعوت لى
//
//          v =  LayoutInflater.from(c).inflate(android.R.layout.simple_list_item_1,null,false);
//
//        }
//
//        // android.R.layout.simple_list_item_1  عشان انا مستخدم وهو موجود جوا  text1
//       // v.findViewById(android.R.id.text1) ابحث عن العنصر دا الموجود فى  v
//
//        TextView textView = v.findViewById(android.R.id.text1);
//
//        String name = data.get(position);
//
//        textView.setText(name);
//
//
//        return v;
//    }
//}
//












