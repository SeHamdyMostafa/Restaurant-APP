package com.example.resturant;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Food_Model extends AppCompatActivity {
    TextView Name;
    TextView Description;
    TextView Price;
    ImageView Image;
    DatabaseManager dbmanager;
    DatabaseHelper dbhelper;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_model);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Product Details");


        Name=(TextView)findViewById(R.id.name);
        Image=(ImageView)findViewById(R.id.Image_Food);
        Description=(TextView)findViewById(R.id.description);
        Price=(TextView)findViewById(R.id.price);

        dbhelper=new DatabaseHelper(this);
        dbmanager=new DatabaseManager(dbhelper,this);

        try{
            cursor=dbmanager.get_Food_data(DatabaseManager.idFor_food_model);
            while (cursor.moveToNext()){
                Name.setText(cursor.getString(1));
                Image.setImageResource(cursor.getInt(2));
                Description.setText(cursor.getString(3));
                Price.setText(cursor.getString(4));
            }
        }catch (Exception e){
            Toast.makeText(this, "error in model Page", Toast.LENGTH_SHORT).show();
        }
    }

    public void ADD_Cart(View view) {
       dbmanager.insertFoodCard(Name.getText().toString(),Price.getText().toString(), R.drawable.cart);

    }
}