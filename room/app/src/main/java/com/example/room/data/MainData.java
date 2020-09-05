package com.example.room.data;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//define table name
@Entity(tableName = "note")
public class MainData implements Serializable {

    //create id column
    @PrimaryKey(autoGenerate = true)
    private int ID;
    //create text column
    @ColumnInfo(name = "text")
    private String text;

    //setter getter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
