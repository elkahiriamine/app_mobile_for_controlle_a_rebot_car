package com.carControle.carMobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BetweenLoginConnection extends AppCompatActivity {
    private Button connect ;
    private Button go_Back;
    private String user_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_between_login_connection);
        connect = findViewById(R.id.goBluetooth);
        go_Back = findViewById(R.id.goback);

        Bundle bundle= getIntent().getExtras();
        user_name = bundle.getString("user_name").toString();
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bd = new Bundle();
                bd.putString("user_name",user_name);
                Intent intent = new Intent(getApplicationContext(), PrintDevice.class);
                intent.putExtras(bd);
                startActivity(intent);
                finish();
            }
        });
        go_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}