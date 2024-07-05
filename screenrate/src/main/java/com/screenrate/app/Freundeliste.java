package com.screenrate.app;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class Freundeliste extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FreundListAdapter adapter;
    private NavigationView menuLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freundeliste);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuLayout = findViewById(R.id.NavMenuFreundesliste);

        List<String> friendList = new ArrayList<>();
        friendList.add("Yasser Moussa");
        friendList.add("Yassine Jabnoun");
        friendList.add("Daniel Lahm");
        friendList.add("Samuel Holz");
        friendList.add("Richard Lakaza");

        adapter = new FreundListAdapter(friendList);
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
        onMenuIconClick(view);
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