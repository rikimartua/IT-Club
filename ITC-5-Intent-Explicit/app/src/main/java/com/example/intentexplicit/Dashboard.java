package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Dashboard extends AppCompatActivity {

    EditText editTextUserName , editTextPassword;
    Button klik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //styles
        setContentView(R.layout.activity_dashboard);


        editTextUserName = findViewById(R.id.t_username);
        editTextPassword = findViewById(R.id.t_password);
        klik = findViewById(R.id.btn_login);

        klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String username = editTextUserName.getText().toString();
               String password = editTextPassword.getText().toString();

               Mahasiswa mahasiswa = new Mahasiswa();
               mahasiswa.setName("Riki");
               mahasiswa.setNim ("12318xxxx");
               if(username.equals("ADMIN")&& password.equals("ADMIN")){
                   Intent intent = new Intent(Dashboard.this,MainMenu.class);
                    intent.putExtra(MainMenu.EXTRA_USER, username);
                    intent.putExtra(MainMenu.EXTRA_PARCEL,mahasiswa);
                   startActivity(intent);
               }
            }
        });
    }
}
