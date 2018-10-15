package com.example.myappfirebase1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends Activity {

    private EditText email, pass;
    private Button signin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.login_email);
        pass = findViewById(R.id.login_pass);
        signin = findViewById(R.id.btn_Signin);

        mAuth = FirebaseAuth.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em, ps;

                em = email.getText().toString().trim();
                ps = pass.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(em, ps)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    login("Login Success!");
                                    finish();
                                    Intent e = new Intent(getApplicationContext(),Success.class);
                                    startActivity(e);
                                }else {
                                    login("Login Failed!");
                                }
                            }
                        });
            }
        });
    }
    private void login(String a) {
        Toast.makeText(getApplicationContext(),a,Toast.LENGTH_SHORT).show();
    }
    /*
    public void abc(View v){
        mAuth.abc();
        finish();
        Intent a = new Intent(this,Success.class);
        startActivity(a);
    }*/
}




