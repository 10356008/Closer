package com.example.myappfirebase1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openMain(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void openLogin(View v){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
}
