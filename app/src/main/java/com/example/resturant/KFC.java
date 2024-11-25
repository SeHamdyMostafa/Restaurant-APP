package com.example.resturant;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class KFC extends AppCompatActivity {
    DatabaseHelper dbHelper;
    DatabaseManager dbManger;
    ListView KFCFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kfc);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("KFC Food Menu");

        KFCFoodList=findViewById(R.id.lv_kfcFoodListView);

        dbHelper=new DatabaseHelper(this);
        dbManger=new DatabaseManager(dbHelper,this);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> images=new ArrayList<>();
        names.add("Cheering Box");
        names.add("Rizo");
        names.add("Mighty Love");
        names.add("Twister Charger Plus");
        names.add("Twister Charger Box");
        names.add("Supreme Love");
        names.add("mighty Plus");
        names.add("Shrimp Box");
        names.add("Super Dinner Strips");
        names.add("Supreme Combo");

        images.add(R.drawable.cheering_box);
        images.add(R.drawable.mega_rizo);
        images.add(R.drawable.mighty_love);
        images.add(R.drawable.twister_charger_plus);
        images.add(R.drawable.twister_charger_box);
        images.add(R.drawable.supreme_love);
        images.add(R.drawable.mighty_plus);
        images.add(R.drawable.shrimp_box);
        images.add(R.drawable.super_dinner_strips);
        images.add(R.drawable.supreme_combo);


        KFCFoodAdapter chineseFoodAdapter=new KFCFoodAdapter(this,names,images);
        KFCFoodList.setAdapter(chineseFoodAdapter);

        KFCFoodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        cheering_box_function(view);
                        break;
                    case 1:
                        mega_rizo_function(view);
                        break;
                    case 2:
                        mighty_love_function(view);
                        break;
                    case 3:
                        twister_charger_plus_function(view);
                        break;
                    case 4:
                        twister_charger_box_function(view);
                        break;
                    case 5:
                        supreme_love_function(view);
                        break;
                    case 6:
                        mighty_plus_function(view);
                        break;
                    case 7:
                        shrimp_box_function(view);
                        break;
                    case 8:
                        super_dinner_strips_function(view);
                        break;
                    case 9:
                        supreme_combo_function(view);
                        break;
                }
            }
        });

    }

    public void cheering_box_function(View view) {

        try{
            dbManger.insertFoodModel("Cheering Box",R.drawable.cheering_box,"Our special delicious fried chicken with three fried chicken crunchy sandwitches , french fries combo and 1L pepsi","150 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void mega_rizo_function(View view) {


        try{
            dbManger.insertFoodModel("Rizo",R.drawable.mega_rizo,"Rice with KFC special barbeque sauce and chicken crunchy pieces","45 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void mighty_love_function(View view) {
        try{
            dbManger.insertFoodModel("Mighty love",R.drawable.mighty_love,"Two mighty zinger sandwitch with two small coleslaw and 1L pepsi","180 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void twister_charger_plus_function(View view) {
        try{
            dbManger.insertFoodModel("Twister charger plus",R.drawable.twister_charger_plus,"Rizo with twister charger sandwitch with small coleslaw and 1L pepsi","100 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void twister_charger_box_function(View view) {
        try{
            dbManger.insertFoodModel("Twister charger box",R.drawable.twister_charger_box,"Twister charger sandwitch large with large coleslaw , fried chicken and 1L pepsi","200 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }
    }

    public void supreme_love_function(View view) {
        try{
            dbManger.insertFoodModel("Supreme love",R.drawable.supreme_love,"Two zinger sandwitch with two small coleslaw and 1L pepsi","140 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }
    }

    public void mighty_plus_function(View view) {
        try{
            dbManger.insertFoodModel("Mighty plus ",R.drawable.mighty_plus,"Mighty zinger with small coleslaw , rizo and 1L pepsi","180 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }
    }

    public void shrimp_box_function(View view) {
        try{
            dbManger.insertFoodModel("Shrimp box",R.drawable.shrimp_box,"Fried shrimps with two kinds of sauce(Your choice) , rizo , bread , large french fries and 1L pepsi","250 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }
    }

    public void super_dinner_strips_function(View view) {
        try{
            dbManger.insertFoodModel("Super dinner strips",R.drawable.super_dinner_strips,"Chicken strips with sauce (Your choice) , coleslaw , french fries , bread and 1L pepsi","120 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }
    }

    public void supreme_combo_function(View view) {
        try{
            dbManger.insertFoodModel("Super combo",R.drawable.supreme_combo,"Chicken zinger sanwith with small french fries and 1L pepsi ","100 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }
    }



}