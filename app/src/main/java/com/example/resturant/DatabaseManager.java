package com.example.resturant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DatabaseManager{
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME_register="register";
    public static final String TABLE_NAME_Food_Model="Food_Model";
    public static final String TABLE_NAME_Food_Cart="Food_Cart";

    SQLiteDatabase SQLdb;
    DatabaseHelper dbHelper;
    static Context context;
    Cursor cursor;
    static  int idForRegisteredUser;
    static  int idFor_food_model;
    static  int idFor_food_cart;


    DatabaseManager(DatabaseHelper DB,Context c){
        this.dbHelper=DB;
        context=c;
    }

    void insertNewUser( String username, String fullname, String Email, String password, String phone){
        SQLdb= dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(dbHelper.COLUMN_UserName,username);
        contentValues.put(dbHelper.COLUMN_FullName,fullname);
        contentValues.put(dbHelper.COLUMN_Email,Email);
        contentValues.put(dbHelper.COLUMN_Password,password);
        contentValues.put(dbHelper.COLUMN_Phone,phone);

        idForRegisteredUser =(int) SQLdb.insert(TABLE_NAME_register,null,contentValues);
        dbHelper.close();
    }

    void insertFoodModel( String name , int image, String description, String price){
        SQLdb= dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(dbHelper.COLUMN_FoodName,name);
        contentValues.put(dbHelper.COLUMN_FoodImage,image);
        contentValues.put(dbHelper.COLUMN_FoodDescription,description);
        contentValues.put(dbHelper.COLUMN_FoodPrice,price);

         idFor_food_model =(int) SQLdb.insert(TABLE_NAME_Food_Model,null,contentValues);
        dbHelper.close();
    }

    void insertFoodCard( String name ,String price, int Image ){
        SQLdb= dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(dbHelper.COLUMN_FoodName_Cart,name);
        contentValues.put(dbHelper.COLUMN_FoodPrice_Cart,price);
        contentValues.put(dbHelper.COLUMN_FoodImage_Cart,Image);


        idFor_food_cart =(int) SQLdb.insert(TABLE_NAME_Food_Cart,null,contentValues);
        dbHelper.close();
    }


    public Boolean checkusernamepassword(String username, String password){
        SQLdb = dbHelper.getWritableDatabase();
        try{
        cursor = SQLdb.rawQuery("SELECT * FROM "+TABLE_NAME_register+" WHERE "+DatabaseHelper.COLUMN_UserName+" = '"+username+"' and "+DatabaseHelper.COLUMN_Password+" = '"+password+"'", null);
            while (cursor.moveToNext()){
                idForRegisteredUser=cursor.getInt(0);
            }
        }catch (Exception e){
            Toast.makeText(context, "error in login", Toast.LENGTH_SHORT).show();
        }
        if(cursor.getCount()>0){
         return true;
    }
    else {
        return false;
    }
}

public Cursor get_data(int id){
    SQLdb=dbHelper.getWritableDatabase();
        try{
            cursor =SQLdb.rawQuery("select * from "+TABLE_NAME_register+" where "+DatabaseHelper.COLUMN_ID_register+" = "+id,null);
        }catch (Exception e){
            Toast.makeText(context, "problem when getting user data !! ", Toast.LENGTH_LONG).show();
        }
        return  cursor;
    }

    public Cursor get_Food_data(int id){
        SQLdb=dbHelper.getWritableDatabase();
        try{
            cursor =SQLdb.rawQuery("select * from "+TABLE_NAME_Food_Model+" where "+DatabaseHelper.COLUMN_ID_Food_Model+" = "+id,null);
        }catch (Exception e){
            Toast.makeText(context, "error in getting data for model", Toast.LENGTH_SHORT).show();

        }
        return  cursor;
    }

    public Cursor get_Food_cart(){
        SQLdb=dbHelper.getWritableDatabase();
        try{
            cursor =SQLdb.rawQuery("select * from "+TABLE_NAME_Food_Cart,null);
        }catch (Exception e){
            Toast.makeText(context, "error in getting data for cart", Toast.LENGTH_SHORT).show();
        }
        return  cursor;
    }

    void update(int id ,String username, String Email, String phone){
        try {
            SQLdb= dbHelper.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(dbHelper.COLUMN_UserName,username);
            contentValues.put(dbHelper.COLUMN_Email,Email);
            contentValues.put(dbHelper.COLUMN_Phone,phone);
            SQLdb.update(TABLE_NAME_register, contentValues, "ID_User = "+id,null);
            dbHelper.close();

        }catch (Exception e){
            Toast.makeText(context, "error in Updata db", Toast.LENGTH_SHORT).show();
        }
    }

    void change_pass(int id ,String password){
        try {
            SQLdb= dbHelper.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(dbHelper.COLUMN_Password,password);
            SQLdb.update(TABLE_NAME_register, contentValues, "ID_User = "+id,null);
            dbHelper.close();

        }catch (Exception e){
            Toast.makeText(context, "error in change_pass db", Toast.LENGTH_SHORT).show();
        }
    }

    void RebuildCartTable(){
            SQLiteDatabase sql=dbHelper.getWritableDatabase();
            sql.execSQL("drop table if exists "+TABLE_NAME_Food_Cart);
            String createQuery_for_Food_Cart="create table " +TABLE_NAME_Food_Cart+ "(ID_Food_Cart INTEGER PRIMARY KEY AUTOINCREMENT, FoodName_Cart TEXT,  FoodPrice_Cart TEXT , FoodImage_Cart INTEGER);";
            sql.execSQL(createQuery_for_Food_Cart);


    }

    //    public void delete_food(int id){
//        try {
//            SQLdb=dbHelper.getWritableDatabase();
//            SQLdb.delete(TABLE_NAME_Food_Model,"ID_Model = "+id,null);
//            dbHelper.close();
//        }catch (Exception e){
//            Toast.makeText(context, "problem when delete food data !! ", Toast.LENGTH_LONG).show();
//        }
//
//    }


}


