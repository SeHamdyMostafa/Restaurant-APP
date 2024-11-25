package com.example.resturant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences isLightSharedPref;
    DatabaseManager dbManager;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new DatabaseHelper(this);
        dbManager=new DatabaseManager(dbHelper,this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");

        isLightSharedPref = getSharedPreferences("isLight",MODE_PRIVATE);
        if(isLightSharedPref.getBoolean("isLight",true)==true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                finish();
                break;
            case R.id.Profile:
                Intent intent = new Intent(this,Profile.class);
                startActivity(intent);
                break;
            case R.id.Cart:
                Intent intent1 = new Intent(this,Purchases.class);
                startActivity(intent1);
                break;
            case R.id.settings:
                Intent intent2 = new Intent(this,Setting.class);
                startActivity(intent2);
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.RebuildCartTable();
    }

    public void Indian_food_function(View view) {
        Intent intent=new Intent(this,Pizza_food.class);
        startActivity(intent);
    }

    public void egyptian_food_function(View view) {
            Intent intent=new Intent(this,KFC.class);
            startActivity(intent);
    }

    public void chinese_food_function(View view) {
        Intent intent=new Intent(this,Mac_food.class);
        startActivity(intent);
    }

}