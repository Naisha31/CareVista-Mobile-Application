package com.example.carevista;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    TextView welcome;
    FirebaseUser user;

    Button pharmacyButton, diagnosticButton, bookAppointmentButton, patientProfileButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cvmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            finish();
            return true;
        } else if (item.getItemId()==R.id.home) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            return true;

        } else if(item.getItemId()==R.id.about){
            startActivity(new Intent(MainActivity.this,About.class));
            return true;
        }
        else if (item.getItemId()==R.id.contactus) {
            startActivity(new Intent(MainActivity.this,ContactUs.class));
            return true;
        }
        else if (item.getItemId()==R.id.pharmacy) {
            startActivity(new Intent(MainActivity.this,Pharmacy.class));
            return true;
        }
        else if (item.getItemId()==R.id.Diagnostics){
            startActivity(new Intent(MainActivity.this,Diagnostics.class));
            return true;
        }
        else if (item.getItemId()==R.id.appointment) {
            startActivity(new Intent(MainActivity.this,appointment.class));
            return true;
        }
        else if (item.getItemId()==R.id.profile) {
            startActivity(new Intent(MainActivity.this,Profile.class));
            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pharmacyButton=findViewById(R.id.pharmacyButton);
        diagnosticButton=findViewById(R.id.diagnosticsButton);
        bookAppointmentButton=findViewById(R.id.bookAppointmentButton);
        patientProfileButton=findViewById(R.id.patientProfileButton);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        auth=FirebaseAuth.getInstance();
        welcome=findViewById(R.id.welcome);
        user= auth.getCurrentUser();
        if (user==null){
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            finish();
        }
        else{
            welcome.setText("Welcome "+user.getEmail());
        }

        pharmacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),Pharmacy.class);
                startActivity(intent2);
            }
        });

        patientProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,profile_management.class);
               startActivity(intent3);
            }
        });

        diagnosticButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,Diagnostics.class);
                startActivity(intent3);
            }
        });

        bookAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, appointment.class));
            }
        });
    }
    

}