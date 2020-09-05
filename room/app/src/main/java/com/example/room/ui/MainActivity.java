package com.example.room.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.room.R;
import com.example.room.adapter.MainAdapter;
import com.example.room.data.MainData;
import com.example.room.data.RoomDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_note;
    Button btn_add,btn_reset;
    RecyclerView recyclerView;
    List<MainData> dataList=new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asigen variable
        et_note=findViewById(R.id.et_note);
        btn_add=findViewById(R.id.btn_add);
        btn_reset=findViewById(R.id.btn_reset);
        recyclerView=findViewById(R.id.rv_notes);

        //init databse
        database=RoomDB.getInstance(this);
        //store database value in data list
        dataList=database.mainDoa().getAll();
        //init layout manager
        linearLayoutManager=new LinearLayoutManager(this);
        //set laiyout manager
        recyclerView.setLayoutManager(linearLayoutManager);
        // init adapter
        adapter=new MainAdapter(MainActivity.this,dataList);
        //set adpter
        recyclerView.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set from Edit text
                String sText=et_note.getText().toString().trim();
                //check kondition
                if (!sText.equals("")){
                    //if text is not empty
                    //init main data
                    MainData data=new MainData();
                    //set test on main data
                    data.setText(sText);
                    //insert text in data
                    database.mainDoa().insert(data);
                    //clear edit text
                    et_note.setText("");
                    //notify when data inserted

                    dataList.clear();
                    dataList.addAll(database.mainDoa().getAll());
                    adapter.notifyDataSetChanged();
                }

            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete all from database
                database.mainDoa().reset(dataList);
                //notify when all data delete
                dataList.clear();
                dataList.addAll(database.mainDoa().getAll());
                adapter.notifyDataSetChanged();
            }
        });





    }
}
