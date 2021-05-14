package com.example.roombasicdemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Student> list = new ArrayList<>();
    StudentAdapter studentAdapter;
    ListView listView;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvStudent);

        DatabaseApp db = Room.databaseBuilder(
                getApplicationContext(),
                DatabaseApp.class,
                "StudentDB"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        StudentDao studentDao = db.studentDao();
        list = studentDao.getAllStudent();

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txt = findViewById(R.id.edtxtName);
                String name = txt.getText().toString();
                studentDao.addStudent(new Student(name));
                Toast.makeText(MainActivity.this, "thành công", Toast.LENGTH_SHORT).show();
                txt.setText("");
                list = studentDao.getAllStudent();
                studentAdapter = new StudentAdapter(list, R.layout.list_item, MainActivity.this);
                listView.setAdapter(studentAdapter);
            }
        });

        Button btnRemove = findViewById(R.id.btnRemove);

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        studentAdapter = new StudentAdapter(list, R.layout.list_item, this);
        listView.setAdapter(studentAdapter);
    }
}