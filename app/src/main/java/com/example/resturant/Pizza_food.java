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

public class Pizza_food extends AppCompatActivity {
    DatabaseHelper dbHelper;
    DatabaseManager dbManger;
    ListView PizzaFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_food);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pizza Hut Menu ");

        PizzaFoodList=findViewById(R.id.lv_chineseFoodListView);

        dbHelper=new DatabaseHelper(this);
        dbManger=new DatabaseManager(dbHelper,this);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> images=new ArrayList<>();
        names.add("BBQ Chicken Pizza");
        names.add("Dynamic Ranch New");
        names.add("Margherita");
        names.add("Super Supreme");
        names.add("Classic pepperoni");
        names.add("Cheese Lovers");
        names.add("Chicken Supreme");
        names.add("Spicy Chicken Ranch");
        names.add("veggie");
        names.add("Praw");

        images.add(R.drawable.bbq_chicken_pizza);
        images.add(R.drawable.dynamic_ranch_new);
        images.add(R.drawable.margherita);
        images.add(R.drawable.super_supreme);
        images.add(R.drawable.classic_pepperoni);
        images.add(R.drawable.cheese_lovers);
        images.add(R.drawable.chicken_supreme);
        images.add(R.drawable.spicy_chicken_ranch);
        images.add(R.drawable.veggie);
        images.add(R.drawable.praw);


        PizzaFoodAdapter PizzaFoodAdapter=new PizzaFoodAdapter(this,names,images);
        PizzaFoodList.setAdapter(PizzaFoodAdapter);

        PizzaFoodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        bbq_chicken_pizza(view);
                        break;
                    case 1:
                        dynamic_ranch_new(view);
                        break;
                    case 2:
                        margherita(view);
                        break;
                    case 3:
                        super_supreme(view);
                        break;
                    case 4:
                        classic_pepperoni(view);
                        break;
                    case 5:
                        cheese_lovers(view);
                        break;
                    case 6:
                        chicken_supreme(view);
                        break;
                    case 7:
                        spicy_chicken_ranch(view);
                        break;
                    case 8:
                        veggie(view);
                        break;
                    case 9:
                        praw(view);
                        break;
                }
            }
        });


    }

    public void bbq_chicken_pizza(View view) {
        try{
            dbManger.insertFoodModel("BBQ Chicken Pizza",R.drawable.bbq_chicken_pizza,"Chicken, Mozzarella Cheese, Mushroom,\n" +
                    "Onion, Pizza Sauce, Tomato ","50 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void dynamic_ranch_new(View view) {

        try{
            dbManger.insertFoodModel("Dynamic Ranch New",R.drawable.dynamic_ranch_new,"Chicken, Garlic, Mozzarella Cheese, Mushroom,\n" +
                    "Pizza Sauce, Tomato ","50 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void margherita(View view) {

        try{
            dbManger.insertFoodModel("Margherita",R.drawable.margherita," Mozzarella Cheese, Pizza Sauce","70 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void super_supreme(View view) {

        try{
            dbManger.insertFoodModel("Super Supreme",R.drawable.super_supreme,"Mozzarella Cheese, Mushroom, Olive, Onion,\n" +
                    "Pepperoni, Pizza Sauce, Pure Beef ","40 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void classic_pepperoni(View view) {

        try{
            dbManger.insertFoodModel("Classic pepperoni",R.drawable.classic_pepperoni,"Mozzarella Cheese, Mushroom, Olive, Pepperoni,\n" +
                    "Pizza Sauce ","90 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void cheese_lovers(View view) {

        try{
            dbManger.insertFoodModel("Cheese Lovers",R.drawable.cheese_lovers,"Pizza Sauce","120 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }
    public void chicken_supreme(View view) {
        try{
            dbManger.insertFoodModel("Chicken Supreme",R.drawable.chicken_supreme,"Chicken, Mozzarella Cheese, Mushroom, Olive,\n" +
                    "Onion, Pizza Sauce, Tomato ","100 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }


    public void spicy_chicken_ranch(View view) {

        try{
            dbManger.insertFoodModel("Spicy Chicken Ranch",R.drawable.spicy_chicken_ranch,"Mozzarella Cheese, Mushroom, Olive, Onion,\n" +
                    "Pizza Sauce, Tomato","70 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void veggie(View view) {

        try{
            dbManger.insertFoodModel("veggie",R.drawable.veggie,"Chicken, Garlic, Mozzarella Cheese, Mushroom,\n" +
                "Pizza Sauce, Tomato","140 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void praw(View view) {

        try{
            dbManger.insertFoodModel("praw",R.drawable.praw,"Garlic, Mozzarella Cheese, Olive, Pizza Sauce,\n" +
                    "Prawn","150 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }






}