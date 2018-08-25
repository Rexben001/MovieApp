package com.android.rexben.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView popularity = findViewById(R.id.popularity);
        TextView ratings = findViewById(R.id.ratings);
        TextView year = findViewById(R.id.year);
        TextView description = findViewById(R.id.description_text);
        ImageView posterImage = findViewById(R.id.banner);

        Intent intent = getIntent();
        if (intent.hasExtra("title")){
            String movieTitle = intent.getStringExtra("title");
            String bannerImage = intent.getStringExtra("banner");
            Double moviePopularity = intent.getDoubleExtra("popularity", 0);
            String years = intent.getStringExtra("year");
            Double movieRatings = intent.getDoubleExtra("ratings", 0);
            String movieDescription = intent.getStringExtra("description");

            String image = "https://image.tmdb.org/t/p/w185" + bannerImage;

            Picasso.with(this).load(image).into(posterImage);
            popularity.setText(new StringBuilder().append("").append(moviePopularity).toString());
            year.setText(years);
            ratings.setText(new StringBuilder().append("").append(movieRatings).toString());
            description.setText(movieDescription);
            setTitle(movieTitle);


        }

    }
}
