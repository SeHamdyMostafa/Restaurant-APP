package com.example.resturant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
EditText ET_email,ET_phone,ET_Username;
TextView change_password;
Button BT_save;
LinearLayout layout;
ImageView iv_photo,iv_data;
DatabaseHelper dbhelper;
DatabaseManager dbmanager;
Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Profile");

        ET_Username=(EditText)findViewById(R.id.et_user_name_profile);
        ET_email=(EditText)findViewById(R.id.et_gmail_user_profile);
        ET_phone=(EditText)findViewById(R.id.et_phone_user_profile);
        change_password=(TextView) findViewById(R.id.TV_change_password);
        iv_data=(ImageView)findViewById(R.id.iv_edit_data) ;
        iv_photo=(ImageView)findViewById(R.id.iv_edit_photo) ;
        layout=(LinearLayout)findViewById(R.id.enter_name);
        BT_save=(Button) findViewById(R.id.btn_save_data);


        dbhelper=new DatabaseHelper(this);
        dbmanager=new DatabaseManager(dbhelper,this);

        try{
            cursor=dbmanager.get_data(DatabaseManager.idForRegisteredUser);
            while (cursor.moveToNext()){
                ET_Username.setText(cursor.getString(1));
                ET_email.setText(cursor.getString(3));
                ET_phone.setText(cursor.getString(5));
            }
        }catch (Exception e){
            Toast.makeText(this, "error in Profile Page", Toast.LENGTH_SHORT).show();
        }
    }



    public void edit_data_function(View view) {
        iv_data.setVisibility(view.INVISIBLE);
        iv_photo.setVisibility(view.VISIBLE);
        BT_save.setVisibility(view.VISIBLE);
        change_password.setVisibility(view.VISIBLE);
        ET_Username.setEnabled(true);
        ET_email.setEnabled(true);
        ET_phone.setEnabled(true);

    }

    public void save_data_function(View view) {

        iv_data.setVisibility(view.VISIBLE);
        iv_photo.setVisibility(view.GONE);
        BT_save.setVisibility(view.GONE);
        change_password.setVisibility(view.GONE);
        ET_Username.setEnabled(false);
        ET_email.setEnabled(false);
        ET_phone.setEnabled(false);


        try{
           dbmanager.update(dbmanager.idForRegisteredUser,ET_Username.getText().toString(),ET_email.getText().toString(),ET_phone.getText().toString());
            cursor=dbmanager.get_data(dbmanager.idForRegisteredUser);
            while (cursor.moveToNext()) {
                ET_Username.setText(cursor.getString(1));
                ET_email.setText(cursor.getString(3));
                ET_phone.setText(cursor.getString(5));
            }

        }catch (Exception e){
            Toast.makeText(this, "error in Profile Page", Toast.LENGTH_SHORT).show();
        }

    }


    public void change_pass_function(View view) {
        Intent intent=new Intent(this,Change_password.class);
        startActivity(intent);
    }
}