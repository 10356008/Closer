package com.example.myappfirebase1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Success extends Activity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView txtuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        auth = FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        txtuser = findViewById(R.id.txtuser);

        txtuser.setText(user.getEmail());
    }

    public void signOut(View v){
        auth.signOut();
        finish();
        Intent i = new Intent(this,Home.class);
        startActivity(i);
    }

}
