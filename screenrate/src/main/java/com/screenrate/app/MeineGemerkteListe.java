package com.screenrate.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MeineGemerkteListe extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MeineGemerkteListeAdapter adapter;
    private List<String> itemList;


    private NavigationView menuLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meine_gemerkte_liste);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuLayout = findViewById(R.id.NavMenuGemerkteListe);

        itemList = new ArrayList<>();

        itemList.add("Item 1");
        itemList.add("Item 2");
        itemList.add("Item 3");
        itemList.add("Item 4");
        itemList.add("Item 5");

        adapter = new MeineGemerkteListeAdapter(itemList, this);
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
