package com.example.roombasicdemo1;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Student.class}, version = 2, exportSchema = false)
public abstract class DatabaseApp extends RoomDatabase {
    public abstract StudentDao studentDao();
}
