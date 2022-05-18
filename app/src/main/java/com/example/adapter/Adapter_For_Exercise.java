package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_For_Exercise extends BaseAdapter {
    private Context c ;
    private   int resource ;
    private ArrayList<Data_For_Exercise> data;

    public Adapter_For_Exercise(Context c, int resource, ArrayList<Data_For_Exercise> data) {
        this.c = c;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public void addItem(Data_For_Exercise post){  //عشان اضيف داتا علول بدل م استدعى الكلاس تانى
        this.data.add(post);
    }
    @Override
    public Data_For_Exercise getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =convertView;
        if (v==null){
            v = LayoutInflater.from(c).inflate(resource,null,false);
        }

        TextView tv_date = v.findViewById(R.id.tv_date);
        TextView tv_name = v.findViewById(R.id.tv_name);
        TextView tv_following = v.findViewById(R.id.tv_following_Data);
        TextView tv_posts = v.findViewById(R.id.tv_posts_Data);
        TextView tv_followers = v.findViewById(R.id.tv_followers_Data);
        TextView tv_body = v.findViewById(R.id.tv_body);

        Data_For_Exercise post = getItem(position);

        tv_date.setText(post.getDate());
        tv_followers.setText(post.getFollowers()+"");
        tv_following.setText(post.getFollowing()+"");
        tv_posts.setText(post.getPosts()+"");
        tv_name.setText(post.getName());
        tv_body.setText(post.getBody());

        return v;
    }
}








