package com.example.roombasicdemo1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private List<Student> list = new ArrayList<>();
    private int layoutItem;
    private Context context;
    private StudentDao studentDao;

    public StudentAdapter(List<Student> list, int layoutItem, Context context) {
        this.list = list;
        this.layoutItem = layoutItem;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(layoutItem, parent, false);

        TextView tvName = view.findViewById(R.id.tvName);

        tvName.setText(list.get(position).getName());

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentDao.deleteStudent(list.get(position));
            }
        });

        return view;
    }
}
