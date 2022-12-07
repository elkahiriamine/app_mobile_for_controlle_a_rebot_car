package com.carControle.carMobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ScreenSplash extends AppCompatActivity  {
     Animation top_animation ,botton_animation ;
    ImageView imageView;
    TextView textView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_splash);
      //  getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageView = findViewById(R.id.car_photo);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView2);
        top_animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botton_animation =AnimationUtils.loadAnimation(this,R.anim.botton_anim);

        textView.setAnimation(top_animation);
        imageView.setAnimation(botton_animation);
        textView1.setAnimation(botton_animation);

        new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(ScreenSplash.this ,LoginPage.class );
               startActivity(intent);
               finish();
           }
       },7000);
    }
}