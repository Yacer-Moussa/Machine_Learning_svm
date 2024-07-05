package com.screenrate.app;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import data.save.status;

public class Empfehlungen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmpfehlungenAdapter adapter;
    private NavigationView menuLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empfehlungen);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuLayout = findViewById(R.id.NavMenuEmpfehlungen);

        adapter = new EmpfehlungenAdapter(this, ((status) getApplication()));
        recyclerView.setAdapter(adapter);
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
        Intent intent = new Intent(this, MeineGemerkteListe.class);
        startActivity(intent);
    }

    public void onMenuFreundeslisteClick(View view) {
        Intent intent = new Intent(this, Freundeliste.class);
        startActivity(intent);
    }

    public void onMenuEmpfehlungenClick(View view) {
        onMenuIconClick(view);
    }

    public void onMenuBenutzereinstellungenClick(View view) {
        Intent intent = new Intent(this, BenutzerEinstellung.class);
        startActivity(intent);
    }
}