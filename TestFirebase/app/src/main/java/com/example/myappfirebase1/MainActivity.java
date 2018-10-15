package com.example.myappfirebase1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends Activity {

    private FirebaseAuth mAuth;

    private EditText email, password;
    private Button button;
    private TextView txtsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        button = findViewById(R.id.btn_in);
        txtsignin = findViewById(R.id.txtsignin);

        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtemail, txtpassword;

                txtemail = email.getText().toString().trim();
                txtpassword = password.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(txtemail,txtpassword)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    signup("Sign Up Success!");
                                    finish();
                                    Intent e = new Intent(getApplicationContext(),Login.class);
                                    startActivity(e);
                                }else {
                                    signup("Sign Up Failed!");
                                }
                            }
                        });
            }
        });
    }
    private void signup(String i) {
        Toast.makeText(getApplicationContext(),i,Toast.LENGTH_SHORT).show();

    }
}
/*
    public void signup(View v){

        if (email.getText().toString().equals("") && password.getText().toString().equals("")){

            Toast.makeText(getApplicationContext(),"Blank Fields Not Allowed!",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Sign Up Success!", Toast.LENGTH_SHORT).show();
                                finish();
                                Intent i = new Intent(getApplicationContext(), Login.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(getApplicationContext(), "Sign Up Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
    }

}*/
