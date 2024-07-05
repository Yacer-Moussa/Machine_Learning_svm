package com.screenrate.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

import data.AppDatabase;
import data.model.Benutzer;
import data.save.status;

public class RegistrationActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button registrationButton = findViewById(R.id.Registrieren);

        registrationButton.setOnClickListener(v -> {
                EditText mEmail = findViewById(R.id.EmailRegistrierung);
                EditText mName = findViewById(R.id.AnzeigenameRegistrierung);
                EditText mPassw1 =findViewById(R.id.RegPasswort);
                EditText mPassw2 =findViewById(R.id.RegPasswordWDH);
                if(!(mEmail == null || mName == null || mPassw1 == null || mPassw2 == null)) {
                    String Email = mEmail.getText().toString();
                    String Name = mName.getText().toString();
                    String Password = "";
                    Date Geburtstag = new Date(2000,1,1);
                    if (mPassw1.getText().toString().equals(mPassw2.getText().toString())) {
                        Password = mPassw1.getText().toString();
                        Benutzer benutzer = new Benutzer(Name, Email, Password, Geburtstag);
                        ((status) this.getApplication()).addBenutzer(benutzer);
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        //TODO Error text set visible
                    }
                }
                else {
                    //Todo Fill in mising fields
                }
        });
    }



}
