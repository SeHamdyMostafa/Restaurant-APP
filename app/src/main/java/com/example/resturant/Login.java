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

public class Login extends AppCompatActivity {
ImageView pass_login_icon;
EditText pass_login,user_name,new_password,confirm_password;
TextView error_Password;
DatabaseHelper dbhelper;
DatabaseManager dbmanager;
Boolean checkuserpass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login");

        pass_login_icon=(ImageView) findViewById(R.id.pass_login_icon);
        user_name=(EditText) findViewById(R.id.et_user_name_login);
        pass_login=(EditText) findViewById(R.id.et_password_login);
        error_Password=(TextView) findViewById(R.id.error_Password);
        new_password=(EditText)findViewById(R.id.et_new_password) ;
        confirm_password=(EditText)findViewById(R.id.et_Confirm_new_password) ;

        dbhelper=new DatabaseHelper(this);
        dbmanager=new DatabaseManager(dbhelper,this);


    }

    public void btn_login_function(View view) {
        String username=user_name.getText().toString();
        String password= pass_login.getText().toString();

        int c = 0;
        if(user_name.getText().toString().isEmpty()){
            user_name.setError("Please Enter Your UserName");
        }
        else{
                c++;
            }

        if(pass_login.getText().toString().isEmpty()){
            pass_login.setError("Please Enter Your password");
        }
        else{
                c++;

        }
        if(c == 2) {
            try{
                checkuserpass = dbmanager.checkusernamepassword(username,password);
                if(checkuserpass == true){
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    error_Password.setText("Error in password or username");
                }
            }catch (Exception e){
                Toast.makeText(this, "error check", Toast.LENGTH_LONG).show();
            }

        }


    }

    public void register_from_login_function(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void ShowHidePass(View view) {
        if(pass_login.getTransformationMethod().equals(PasswordTransformationMethod.getInstance()))
        {
            //Show Password
            pass_login.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            pass_login_icon.setImageResource(R.drawable.hide_pass);

        }else {
            //Hide Password
            pass_login.setTransformationMethod(PasswordTransformationMethod.getInstance());
            pass_login_icon.setImageResource(R.drawable.show_pass);

        }
}



}