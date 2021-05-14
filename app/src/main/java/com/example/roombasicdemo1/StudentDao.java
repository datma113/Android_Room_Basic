package com.example.roombasicdemo1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM STUDENT")
    List<Student> getAllStudent();

    @Insert
    void addStudent(Student... students);
    @Delete
    void deleteStudent(Student student);
}
