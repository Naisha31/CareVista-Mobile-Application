package com.example.carevista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    Button forget;
    EditText email;
    String stremail;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forget=findViewById(R.id.submit);
        email=findViewById(R.id.email);
        auth=FirebaseAuth.getInstance();

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }
    private void validateData() {
        stremail=email.getText().toString();
        if(stremail.isEmpty()){
            email.setError("Required");
        }
        else {
            forgetPass();
        }
    }

    private void forgetPass(){
        auth.sendPasswordResetEmail(stremail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgetPassword.this,"Email sent",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgetPassword.this, Login.class));
                            finish();
                        }
                        else{
                            Toast.makeText(ForgetPassword.this, "Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}