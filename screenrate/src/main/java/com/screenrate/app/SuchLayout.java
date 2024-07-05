package com.screenrate.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import data.save.status;

public class SuchLayout extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private LinearLayout filterScreen;
    private NavigationView menuLayout;
    private MovieAdapter movieAdapter;
    private EditText searchEditText;

    private RecyclerView screenAnzeige;

    private status myStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myStatus = ((status) this.getApplication());
        setContentView(R.layout.activity_such_layout);
        screenAnzeige = findViewById(R.id.recyclerView);
        searchEditText = findViewById(R.id.searchEditText);
        filterScreen = findViewById(R.id.filterScreen);
        menuLayout = findViewById(R.id.NavMenu);

        //posterListMovie = Arrays.asList(R.drawable.Batman, R.drawable.Inception, R.drawable.Django12, R.drawable.Moonlight);
        //posterListSerie = Arrays.asList(R.drawable.Prisonbreak, R.drawable.series2, R.drawable.Dark, R.drawable.series4);
        //movieNames = Arrays.asList("Batman: The Dark Knight", "Inception", "Django Unchained", "Moonlight");
        //serieNames = Arrays.asList("Prison Break", "Lost", "Dark", "The Witcher");
        movieAdapter = new MovieAdapter(this, ((status) this.getApplication()),((status) this.getApplication()).getScreenList());
        int i = myStatus.getScreenCount();
        movieAdapter.onCreateViewHolder(this.screenAnzeige,i);
        MovieAdapter.OnMovieClickListener onMovieClickListener = new onMovieClickImpl(this, myStatus);
        movieAdapter.setOnMovieClickListener(onMovieClickListener);
        screenAnzeige.setAdapter(movieAdapter);
        screenAnzeige.setLayoutManager(new LinearLayoutManager(this));
    }

    public void performSearch(String query) {
        //ToImpl

        movieAdapter = new MovieAdapter(this, ((status) this.getApplication()), ((status) this.getApplication()).getScreenList());
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(movieAdapter);
    }

    public void onFilterIconClick(View view) {
        if (filterScreen.getVisibility() == View.VISIBLE) {
            filterScreen.setVisibility(View.GONE);
        } else {
            filterScreen.setVisibility(View.VISIBLE);
        }
    }

    public void onMenuIconClick(View view) {
        if (menuLayout.getVisibility() == View.VISIBLE) {
            menuLayout.setVisibility(View.GONE);
        } else {
            menuLayout.setVisibility(View.VISIBLE);
        }
    }


    public void onSearchIconClick(View view) {
        String searchQuery = searchEditText.getText().toString().trim();
        performSearch(searchQuery);
    }

    public void onMenuFilmUndSerieClicked(View view) {
        onMenuIconClick(view);
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
        Intent intent = new Intent(this, Empfehlungen.class);
        startActivity(intent);
    }

    public void onMenuBenutzereinstellungenClick(View view) {
        Intent intent = new Intent(this, BenutzerEinstellung.class);
        startActivity(intent);
    }
    public class onMovieClickImpl implements MovieAdapter.OnMovieClickListener{

        SuchLayout suchLayout;
        status mystatus;
        public onMovieClickImpl(SuchLayout suchLayout, status mystatus) {
            this.suchLayout = suchLayout;
            this.mystatus = mystatus;
        }

        @Override
        public void onMovieClick(int position, View view) {
            long screenID = mystatus.getScreenList().get(position).ScreenID;
            Intent intent = new Intent(suchLayout, Moviedetails.class);
            intent.putExtra("posterId", screenID);
            startActivity(intent);
        }
    }
}
