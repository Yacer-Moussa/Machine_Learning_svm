package com.screenrate.app;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import data.AppDatabase;
import data.model.Anbieter;
import data.model.Benutzer;
import data.model.Kategorie;
import data.model.Screen;
import data.save.UserNotFoundExeption;
import data.save.status;
import usecase.PasswordValidator;
import usecase.impl.DumbPasswodValidator;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    EditText username;
    EditText password;

    PasswordValidator passwordValidator;

    private void pupulateDB() {
        Anbieter anbieter1 = new Anbieter("Apple TV");
        Anbieter anbieter2 = new Anbieter("DAZN");
        Anbieter anbieter3 = new Anbieter("Discovery+");
        Anbieter anbieter4 = new Anbieter("Disney+");
        Anbieter anbieter5 = new Anbieter("Join");
        Anbieter anbieter6 = new Anbieter("MagentaTV");
        Anbieter anbieter7 = new Anbieter("Maona.tv");
        Anbieter anbieter8 = new Anbieter("Netflix");
        Anbieter anbieter9 = new Anbieter("Paramount+");
        Anbieter anbieter10 = new Anbieter("Peacock");
        Anbieter anbieter11 = new Anbieter("Prime Video");
        Anbieter anbieter12 = new Anbieter("RTL+");
        Anbieter anbieter13 = new Anbieter("Sky Q");
        Anbieter anbieter14 = new Anbieter("WOW");
        Anbieter anbieter15 = new Anbieter("WaipuTV");
        Anbieter anbieter16 = new Anbieter("ARD Mediathek");
        Anbieter anbieter17 = new Anbieter("ZDF Mediathek");
        ((status)this.getApplication()).addAnbieter(anbieter1);
        ((status)this.getApplication()).addAnbieter(anbieter2);
        ((status)this.getApplication()).addAnbieter(anbieter3);
        ((status)this.getApplication()).addAnbieter(anbieter4);
        ((status)this.getApplication()).addAnbieter(anbieter5);
        ((status)this.getApplication()).addAnbieter(anbieter6);
        ((status)this.getApplication()).addAnbieter(anbieter7);
        ((status)this.getApplication()).addAnbieter(anbieter8);
        ((status)this.getApplication()).addAnbieter(anbieter9);
        ((status)this.getApplication()).addAnbieter(anbieter10);
        ((status)this.getApplication()).addAnbieter(anbieter11);
        ((status)this.getApplication()).addAnbieter(anbieter12);
        ((status)this.getApplication()).addAnbieter(anbieter13);
        ((status)this.getApplication()).addAnbieter(anbieter14);
        ((status)this.getApplication()).addAnbieter(anbieter15);
        ((status)this.getApplication()).addAnbieter(anbieter16);
        ((status)this.getApplication()).addAnbieter(anbieter17);
        Kategorie kategorie1 = new Kategorie("Abenteuerfilm");
        Kategorie kategorie2 = new Kategorie("Actionfilm");
        Kategorie kategorie3 = new Kategorie("Dokumentarfilm");
        Kategorie kategorie4 = new Kategorie("Drama");
        Kategorie kategorie5 = new Kategorie("Fantasyfilm");
        Kategorie kategorie6 = new Kategorie("Filmbiografie");
        Kategorie kategorie7 = new Kategorie("Filmkomödie");
        Kategorie kategorie8 = new Kategorie("Horrorfilm");
        Kategorie kategorie9 = new Kategorie("Kriegsfilm");
        Kategorie kategorie10 = new Kategorie("Kriminalfilm");
        Kategorie kategorie11 = new Kategorie("Liebesfilm");
        Kategorie kategorie12 = new Kategorie("Martial-Arts-Film");
        Kategorie kategorie13 = new Kategorie("Musikfilm");
        Kategorie kategorie14 = new Kategorie("Roadmovie");
        Kategorie kategorie15 = new Kategorie("Science-Fiction-Film");
        Kategorie kategorie16 = new Kategorie("Sportfilm");
        Kategorie kategorie17 = new Kategorie("Thriller");
        Kategorie kategorie18 = new Kategorie("Western");
        ((status)this.getApplication()).addKategorie(kategorie1);
        ((status)this.getApplication()).addKategorie(kategorie2);
        ((status)this.getApplication()).addKategorie(kategorie3);
        ((status)this.getApplication()).addKategorie(kategorie4);
        ((status)this.getApplication()).addKategorie(kategorie5);
        ((status)this.getApplication()).addKategorie(kategorie6);
        ((status)this.getApplication()).addKategorie(kategorie7);
        ((status)this.getApplication()).addKategorie(kategorie8);
        ((status)this.getApplication()).addKategorie(kategorie9);
        ((status)this.getApplication()).addKategorie(kategorie10);
        ((status)this.getApplication()).addKategorie(kategorie11);
        ((status)this.getApplication()).addKategorie(kategorie12);
        ((status)this.getApplication()).addKategorie(kategorie13);
        ((status)this.getApplication()).addKategorie(kategorie14);
        ((status)this.getApplication()).addKategorie(kategorie15);
        ((status)this.getApplication()).addKategorie(kategorie16);
        ((status)this.getApplication()).addKategorie(kategorie17);
        ((status)this.getApplication()).addKategorie(kategorie18);
        Screen screen1 = new Screen(0,"Batman","Ich bin Manbat. Ich töte nicht!");
        Screen screen2 = new Screen(1,"Dark","Die Dunkelheit übernimmt den Himmel...");
        Screen screen3 = new Screen(2,"Django","Der Beste im weste!");
        Screen screen4 = new Screen(3,"Django12","Nur noch 12 Kugeln...");
        Screen screen5 = new Screen(4,"Inception","Sind wir hier im Traum?");
        Screen screen6 = new Screen(5,"Lost","so wie diese App");
        Screen screen7 = new Screen(6,"Moonlight","Was passiert wohl im Mondlicht?");
        Screen screen8 = new Screen(7,"Prisonbreak","Preisgekürter Gefängnissausbruch...");
        Screen screen9 = new Screen(8,"Witcher","Der Hexer geht und bekämpft Montser. Werden die Leute ihn lieben... nein!?");
        ((status)this.getApplication()).addScreen(screen1);
        ((status)this.getApplication()).addScreen(screen2);
        ((status)this.getApplication()).addScreen(screen3);
        ((status)this.getApplication()).addScreen(screen4);
        ((status)this.getApplication()).addScreen(screen5);
        ((status)this.getApplication()).addScreen(screen6);
        ((status)this.getApplication()).addScreen(screen7);
        ((status)this.getApplication()).addScreen(screen8);
        ((status)this.getApplication()).addScreen(screen9);
        Date date = new Date(1999,1,1);
        Benutzer Herbert = new Benutzer("Herbert","Herbert@mail","123",date);
        Benutzer Alberto = new Benutzer("Alberto","Alberto@mail","123",date);
        Benutzer Kevin = new Benutzer("Kevin","Kevin@mail","123",date);
        Benutzer Alonzo = new Benutzer("Alonzo","Alonzo@mail","123",date);
        ((status)this.getApplication()).addBenutzer(Herbert);
        ((status)this.getApplication()).addBenutzer(Alberto);
        ((status)this.getApplication()).addBenutzer(Kevin);
        ((status)this.getApplication()).addBenutzer(Alonzo);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((status)this.getApplication()).loadNew(this);
        setContentView(R.layout.activity_main);
        if(!((status)this.getApplication()).dbPopulated()){
            pupulateDB();
            ((status)this.getApplication()).save();
        }
        passwordValidator = new DumbPasswodValidator();
        Button loginButton = findViewById(R.id.buttonl);
        username = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        loginButton.setOnClickListener(v -> {
            String inputName;
            inputName = username.getText().toString();
            if(!inputName.isEmpty()) {
                Long UserID = null;
                try {
                    UserID = ((status) this.getApplication()).getUserIDbyName(inputName);
                    String PasswordTxt = password.getText().toString();
                    if (((status)this.getApplication()).validatePassword(UserID,PasswordTxt)) {
                        ((status)this.getApplication()).setMyUserID(UserID);
                        String myname = ((status)this.getApplication()).getMyUserName();
                        ((status)this.getApplication()).setMyUserName(myname);
                        Intent intent = new Intent(MainActivity.this, SuchLayout.class);
                        startActivity(intent);
                    } else {
                        //Todo Warning for bad Password
                    }
                } catch (UserNotFoundExeption e) {
                    //Todo Warning for UserNotFound
                }
            }
        });

        Button registrationButton2 = findViewById(R.id.buttonr);
        registrationButton2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_Open, R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.FilmeUndSerien) {
                Log.i("MENU-DRAWER-TAG", "HOME ITEM IS CLICKED");
                Intent intent = new Intent(MainActivity.this, SuchLayout.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.freundeliste) {
                Log.i("MENU-DRAWER-TAG", "Freunde Liste ITEM IS CLICKED");
                Intent intent = new Intent(MainActivity.this, Freundeliste.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.GemerkteListe) {
                Log.i("MENU-DRAWER-TAG", "Gemerkte Liste ITEM IS CLICKED");
                Intent intent = new Intent(MainActivity.this, MeineGemerkteListe.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.empfehlungen) {
                Log.i("MENU-DRAWER-TAG", "Empfehlungen ITEM IS CLICKED");
                Intent intent = new Intent(MainActivity.this, Empfehlungen.class);
                startActivity(intent);
                return true;
            } else {
                Log.i("MENU-DRAWER-TAG", "Benutzer Einstellungen ITEM IS CLICKED");
                Intent intent = new Intent(MainActivity.this, BenutzerEinstellung.class);
                startActivity(intent);
                return true;
            }
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        ((status)this.getApplication()).save();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected  void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
    }

}
