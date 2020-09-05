package com.example.room.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDoa {
    //insert query
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    //delete query
    @Delete
    void delete(MainData mainData);

    //delete all
    @Delete
    void reset(List<MainData> mainData);

    //update query
    @Query("UPDATE note SET text = :sText WHERE ID= :sID")
    void update(int sID,String sText);

    //getAll data Qury
    @Query("SELECT * FROM note")
    List<MainData> getAll();
}
