package com.carControle.carMobile2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button btLogIn, btSignUp;
    DataLocal dataLocal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btLogIn = findViewById(R.id.bt_submit);
        btSignUp = findViewById(R.id.signUp);
        dataLocal = new DataLocal(this);
        btLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if(username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(),"fill all the fields !!",Toast.LENGTH_LONG).show();}
                else{

                    if(dataLocal.verify_user(username,password)){
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Bundle bd = new Bundle();
                                bd.putString("user_name",username);
                                Intent intent = new Intent(LoginPage.this, BetweenLoginConnection.class);
                                intent.putExtras(bd);
                                startActivity(intent);
                                finish();
                            }
                        }, 100);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }


            }

        });
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register_Data.class);
                startActivity(intent);
            }
        });
    }
}


/*
    if (etUsername.getText().toString().equals("admin") &&
                        etPassword.getText().toString().equals("admin")) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LoginPage.this, PrintDevice.class);
                            startActivity(intent);
                            finish();

                        }
                    }, 100);

                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
 */