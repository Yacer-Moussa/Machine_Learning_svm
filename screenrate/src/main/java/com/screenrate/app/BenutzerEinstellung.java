package com.screenrate.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class BenutzerEinstellung extends AppCompatActivity {
    ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView menuLayout;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benutzer_einstellung);
        menuLayout = findViewById(R.id.NavMenuBenutzereinstellungen);
    }
    public void onMenuIconClick(View view) {
        if (menuLayout.getVisibility() == View.VISIBLE) {
            menuLayout.setVisibility(View.GONE);
        } else {
            menuLayout.setVisibility(View.VISIBLE);
        }
    }
    public void onMenuFilmUndSerieClicked(View view) {
        Intent intent = new Intent(this, SuchLayout.class);
        startActivity(intent);
    }

    public void onMenuGemerkteListeClick(View view) {
        onMenuIconClick(view);
    }

    public void onMenuFreundeslisteClick(View view) {
        Intent intent = new Intent(this, Freundeliste.class);
        startActivity(intent);
    }

    public void onMenuEmpfehlungenClick(View view) {
        Intent intent = new Intent(this, Empfehlungen.class);
        startActivity(intent);
    }

    public void onMenuBenutzereinstellungenClick(View view) {
        Intent intent = new Intent(this, BenutzerEinstellung.class);
        startActivity(intent);
    }
}