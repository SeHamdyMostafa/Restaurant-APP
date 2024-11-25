package com.example.resturant;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Purchases extends AppCompatActivity {
    DatabaseHelper dbHelper;
    DatabaseManager dbManger;
    Cursor cursor;
    ListView CartFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchases);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("cart ");

        CartFoodList=findViewById(R.id.lv_purchases);


        dbHelper=new DatabaseHelper(this);
        dbManger=new DatabaseManager(dbHelper,this);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> prices=new ArrayList<>();
        ArrayList<Integer> Images=new ArrayList<>();

            cursor = dbManger.get_Food_cart();
            while (cursor.moveToNext()) {
                names.add(cursor.getString(1));
                prices.add(cursor.getString(2));
                Images.add(cursor.getInt(3));
            }

        PurchasesAdapter CartFoodAdapter=new PurchasesAdapter(this,names,prices,Images);
        CartFoodList.setAdapter(CartFoodAdapter);

        CartFoodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;

                }
            }
        });

    }

}