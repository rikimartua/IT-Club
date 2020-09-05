package com.example.room.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MainData.class},version = 1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    //create database instance
    private static RoomDB database;
    //Difine databese name
    private static String DATABASE_NAME="database";

    public synchronized static RoomDB getInstance(Context context){
        //check condition
        if (database==null){
            //when database null
            //initialize database
            database= Room.databaseBuilder(context.getApplicationContext()
                    ,RoomDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        //return databse
        return  database;
    }

    //create Dao
    public abstract MainDoa mainDoa();
}
