package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    final static  String EXTRA_USER = "extra_user";
    final static  String EXTRA_PARCEL = "extra_parcel";
    TextView tv_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        String username = getIntent().getStringExtra(EXTRA_USER);
        Mahasiswa mahasiswa = getIntent().getParcelableExtra(EXTRA_PARCEL);

        tv_username = findViewById(R.id.tv_username);
        tv_username.setText("Hello, " + username + "\n" + "Nama saya " + mahasiswa.getName() + "\n" + "Nim Saya " + mahasiswa.getNim());
    }
}
