package com.carControle.carMobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register_Data extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText rpassword;
    Button Signup;
    DataLocal dataLocal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__data);

    username = findViewById(R.id.username);
    password = findViewById(R.id.password);
    rpassword = findViewById(R.id.rpassword);
    Signup = findViewById(R.id.valid);
    dataLocal = new DataLocal(this);
    Signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
              String username1 = username.getText().toString();
              String password1 = password.getText().toString();
              String rpassword1 = rpassword.getText().toString();
              if(username1.equals("") || password1.equals("") || rpassword1.equals("") ){
                  Toast.makeText(getApplicationContext(),"fill all the fields !!",Toast.LENGTH_LONG).show();
              }else {

                  if (password1.matches(rpassword1)){
                      if( !dataLocal.verify_user(username1,password1)){
                          if(dataLocal.insert_user(username1,password1)){
                              Toast.makeText(getApplicationContext(),"Registration successfully !",Toast.LENGTH_SHORT).show();
                              Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                              startActivity(intent);
                              finish();
                          }else{
                              Toast.makeText(getApplicationContext(),"Registration Failed !",Toast.LENGTH_SHORT).show();
                          }
                      }
                      else {
                          Toast.makeText(getApplicationContext(),"This user already exists \n try to Log in !!",Toast.LENGTH_SHORT).show();
                          Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                          startActivity(intent);
                          finish();
                      }
                  }
                  else {
                      Toast.makeText(getApplicationContext(),"PASSWORD NOT MATCHING",Toast.LENGTH_SHORT).show();
                  }


              }
        }
    });


    }
}