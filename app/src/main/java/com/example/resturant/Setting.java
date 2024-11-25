package com.example.resturant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        setTitle("Settings_page");

        getSupportFragmentManager().beginTransaction().replace(R.id.setting,new SettingsFragment()).commit();
    }

    public void Change_Password_function(View view) {
        Intent intent=new Intent(this,Change_password.class);
        startActivity(intent);
    }

}