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

public class Mac_food extends AppCompatActivity {


    DatabaseHelper dbHelper;
    DatabaseManager dbManger;
    ListView macFoodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mac_food);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("McDonald's Menu ");

        macFoodList=findViewById(R.id.lv_chineseFoodListView);
        dbHelper=new DatabaseHelper(this);
        dbManger=new DatabaseManager(dbHelper,this);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> images=new ArrayList<>();

        names.add("Big Tasty Chicken");
        names.add("Chicken Fillet");
        names.add("Grand Share Box");
        names.add("HM D Beefburger");
        names.add("HM D Chess burger");
        names.add("M2M");
        names.add("Big Mushroom");
        names.add("Share Box");
        names.add("Grand Chicken Regular");
        names.add("Little Tasty");

        images.add(R.drawable.big_tasty_chicken);
        images.add(R.drawable.chicken_fillet);
        images.add(R.drawable.grand_share);
        images.add(R.drawable.hm_d_beefburger);
        images.add(R.drawable.hm_d_chesseburger);
        images.add(R.drawable.m2m);
        images.add(R.drawable.mushroom);
        images.add(R.drawable.share_box);
        images.add(R.drawable.grand_chicken_regular);
        images.add(R.drawable.little_tasty);


        MacFoodAdapter macFoodAdapter=new MacFoodAdapter(this,names,images);
        macFoodList.setAdapter(macFoodAdapter);

        macFoodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        big_tasty_chicken(view);
                    break;
                    case 1:
                        chicken_fillet(view);
                        break;
                    case 2:
                        grand_share(view);
                        break;
                    case 3:
                        hm_d_beefburger(view);
                        break;
                    case 4:
                        hm_d_chess_burger(view);
                        break;
                    case 5:
                        m2m(view);
                        break;
                    case 6:
                        mushroom(view);
                        break;
                    case 7:
                        share_box(view);
                        break;
                    case 8:
                        grand_chicken_regular(view);
                        break;
                    case 9:
                        little_tasty(view);
                        break;
                }
            }
        });

    }



    public void big_tasty_chicken(View view) {

        try{
            dbManger.insertFoodModel("Big Tasty Chicken",R.drawable.big_tasty_chicken,"حجم وطعم! قطعة لحم بقري مشوي مع 3 شرائح رائعة من جبنة إيمانتال على شريحتين طماطم، خس مقطع، بصل لذيذ، صوص بيج تايستي المميز","70 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void chicken_fillet(View view) {

        try{
            dbManger.insertFoodModel("Chicken Fillet",R.drawable.chicken_fillet,"هاتقاومه؟ صدور فراخ متبلة بخلطة التامبورا السبايسي مع مايونيز وخس في عيش بالسمسم","70 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void grand_share(View view) {

        try{
            dbManger.insertFoodModel("Grand Share Box",R.drawable.grand_share,"اختار ساندوتشين ما بين بيج تايستي وجراند تشيكن  + 2 ساندوتش من بيف برجر وتشيز برجر وتشيكن ماكدو + 2 ماكدونالدز فرايز حجم عادي + كوكاكولا 1 لتر","90 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void hm_d_beefburger(View view) {

        try{
            dbManger.insertFoodModel("HM D Beefburger",R.drawable.hm_d_beefburger,"حتى الولاد مش هاينسوا طعمه الرائع. مش بس مكونات تشيز برجر الأصلي، كمان فيه قطعتين لحم بقري مشوي وشريحتين جبنة علشان تستمتع بالطعم مرتين! قدّم لهم الفرايز الشهيرة، واختار واحد من لبن، ميلك شيك شوكولاتة، عصير برتقال، عصير تفاح، أو عصير تروبيكال.. وابسطه!","150 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void hm_d_chess_burger(View view) {

        try{
            dbManger.insertFoodModel("HM D Chess burger",R.drawable.hm_d_chesseburger,"مافيش طفل مابيحبش البرجر المليان جبنة لذيذة.. مش بس مكونات تشيز برجر الأصلي، كمان فيه قطعتين لحم بقري مشوي وشريحتين جبنة علشان تستمتع بالطعم مرتين! قدّم لهم الفرايز الشهيرة، واختار واحد من لبن، ميلك شيك شوكولاتة، عصير برتقال، عصير تفاح، أو عصير تروبيكال.. وفرحّهُ!","90 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void m2m(View view) {

        try{
            dbManger.insertFoodModel("m2m",R.drawable.m2m,"اختار 2 من تشيز برجر وتشيكن ماكدو و بيف برجر + ماكدونالدز فرايز + مشروب","100 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void mushroom(View view) {

        try{
            dbManger.insertFoodModel("mushroom",R.drawable.mushroom,"البيج تايستي الشهير، مع مشروم وبصل مكرمل. لا يقاوم!","190 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void share_box(View view) {

        try{
            dbManger.insertFoodModel("share_box",R.drawable.share_box,"اختار ساندوتشين ما بين بيج ماك وماك تشيكن + ساندوتشين من بيف برجر، تشيز برجر وتشيكن ماكدو + 2 ماكدونالدز فرايز حجم عادي + كوكاكولا 1 لتر","100 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void grand_chicken_regular(View view) {

        try{
            dbManger.insertFoodModel("Grand Chicken Regular",R.drawable.grand_chicken_regular,"قطعة جراند تشيكن سبايسي، قطعتين من طماطم طازة، قطعتين جبنة إيمانتال وخس.. متغطي بصوص ديلوكس الرائع في عيش 5 بوصة","200 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }

    public void little_tasty(View view) {

        try{
            dbManger.insertFoodModel("Little Tasty",R.drawable.little_tasty,"أخو بيج تايستي الصغير .. بكل المكونات الأصلية وقيمة عالية في الجودة والسعر","120 L.E");
            Intent intent=new Intent(this,Food_Model.class);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "error when insert Record", Toast.LENGTH_SHORT).show();
        }

    }




}