package com.example.resturant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    Context c;
    public static final String DATABASE_NAME="register.db";

    public static final String TABLE_NAME_register="register";
    public static final String COLUMN_ID_register="ID_User";
    public static final String COLUMN_UserName="UserName";
    public static final String COLUMN_FullName="FullName";
    public static final String COLUMN_Email="Email";
    public static final String COLUMN_Password="Password";
    public static final String COLUMN_Phone="Phone";

    public static final String TABLE_NAME_Food_Model="Food_Model";
    public static final String COLUMN_ID_Food_Model="ID_Model";
    public static final String COLUMN_FoodName="FoodName";
    public static final String COLUMN_FoodImage="FoodImage";
    public static final String COLUMN_FoodDescription="FoodDescription";
    public static final String COLUMN_FoodPrice="FoodPrice";

    public static final String TABLE_NAME_Food_Cart="Food_Cart";
    public static final String COLUMN_ID_Food_Cart="ID_Food_Cart";
    public static final String COLUMN_FoodName_Cart="FoodName_Cart";
    public static final String COLUMN_FoodPrice_Cart="FoodPrice_Cart";
    public static final String COLUMN_FoodImage_Cart="FoodImage_Cart";




    DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 23);
        this.c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createQuery_for_register="create table " +TABLE_NAME_register+ "(ID_User INTEGER PRIMARY KEY AUTOINCREMENT, UserName TEXT, FullName TEXT, Email TEXT, Password TEXT , Phone TEXT );";
        db.execSQL(createQuery_for_register);

        String createQuery_for_Food_Model="create table " +TABLE_NAME_Food_Model+ "(ID_Model INTEGER PRIMARY KEY AUTOINCREMENT, FoodName TEXT, FoodImage INTEGER, FoodDescription TEXT, FoodPrice TEXT );";
        db.execSQL(createQuery_for_Food_Model);

        String createQuery_for_Food_Cart="create table " +TABLE_NAME_Food_Cart+ "(ID_Food_Cart INTEGER PRIMARY KEY AUTOINCREMENT, FoodName_Cart TEXT,  FoodPrice_Cart TEXT , FoodImage_Cart INTEGER );";
        db.execSQL(createQuery_for_Food_Cart);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME_register);
        db.execSQL("drop table if exists "+TABLE_NAME_Food_Model);
        db.execSQL("drop table if exists "+TABLE_NAME_Food_Cart);

        onCreate(db);
    }


}
