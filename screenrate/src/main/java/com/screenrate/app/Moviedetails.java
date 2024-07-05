package com.screenrate.app;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.os.Bundle;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

import data.save.isNotScreenException;
import data.save.status;

public class Moviedetails extends AppCompatActivity {

    long screenID;
    status mystatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetails);
        ImageView posterImageView = findViewById(R.id.moviePoster);
        LinearLayout reviewsLayout = findViewById(R.id.reviewsLayout);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("posterId")) {
            screenID = intent.getLongExtra("posterId", -1);
            mystatus = ((status) this.getApplication());
            // Set the poster image using the retrieved poster ID
            String screenName = null;
            screenName = mystatus.getScreenName(screenID);
            //Todo Always 0 ?
            int ResID = this.getResources().getIdentifier(screenName, "drawable",mystatus.getPackageName());
            posterImageView.setImageResource(ResID);
        }

        // Example movie summary
        String movieSummary = mystatus.getScreenList().get((int)screenID).Beschreibung;

        TextView summaryTextView = new TextView(this);
        summaryTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        summaryTextView.setText(movieSummary);

        reviewsLayout.addView(summaryTextView);
    }
}
