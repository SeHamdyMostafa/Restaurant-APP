package com.example.resturant;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Change_password extends AppCompatActivity {
    DatabaseHelper dbhelper;
    DatabaseManager dbmanager;
    EditText new_password,confirm_password;
    TextView error_check_password;
    ImageView new_pass_icon,confirm_pass_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Change Password");

        error_check_password=(TextView) findViewById(R.id.error_tv) ;
        new_password=(EditText)findViewById(R.id.et_new_password) ;
        confirm_password=(EditText)findViewById(R.id.et_Confirm_new_password) ;
        new_pass_icon=(ImageView)findViewById(R.id.new_pass_icon) ;
        confirm_pass_icon=(ImageView)findViewById(R.id.confirm_new_pass_icon) ;



        dbhelper=new DatabaseHelper(this);
        dbmanager=new DatabaseManager(dbhelper,this);


        try{
            Cursor cursor=dbmanager.get_data(DatabaseManager.idForRegisteredUser);
            while (cursor.moveToNext()){
                new_password.setText(cursor.getString(4));
            }
        }catch (Exception e){
            Toast.makeText(this, "error in Profile Page", Toast.LENGTH_SHORT).show();
        }


    }

    public void save_pass_function(View view) {

        int c = 0;

        if (new_password.getText().toString().isEmpty()) {
            new_password.setError("Please Enter Your UserName");
        } else {
            c++;
        }

        if (confirm_password.getText().toString().isEmpty()) {
            confirm_password.setError("Please Enter Your password");
        } else {
            c++;

        }
        if (new_password.getText().toString().equals(confirm_password.getText().toString())) {
             c++;
        } else {
            error_check_password.setText("Conform Password not equal Your password");
        }
        if (c == 3) {
                dbmanager.change_pass(dbmanager.idForRegisteredUser, new_password.getText().toString());
                startActivity(new Intent(this,Login.class));

            }

    }

    public void ShowHidenewPass(View view) {

        if(new_password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance()))
        {
            //Show Password
            new_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            new_pass_icon.setImageResource(R.drawable.hide_pass);

        }else {
            //Hide Password
            new_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            new_pass_icon.setImageResource(R.drawable.show_pass);

        }

    }


    public void ShowHidenewconfirmPass(View view) {

        if(confirm_password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance()))
        {
            //Show Password
            confirm_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            confirm_pass_icon.setImageResource(R.drawable.hide_pass);

        }else {
            //Hide Password
            confirm_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            confirm_pass_icon.setImageResource(R.drawable.show_pass);

        }
    }

}