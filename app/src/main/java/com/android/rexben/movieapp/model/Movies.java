package com.android.rexben.movieapp.model;

import com.google.gson.annotations.SerializedName;

public class Movies {
    @SerializedName("poster_path")
    private String banner;
    @SerializedName("original_title")
    private String movieTitle;
    @SerializedName("release_date")
    private String year;
    @SerializedName("vote_average")
    private Double ratings;
    @SerializedName("overview")
    private String description;
    @SerializedName("popularity")
    private Double popularity;

    public Movies(String ibanner, String movieTitle, String year, Double ratings, String description, Double popularity) {
        this.banner = ibanner;
        this.movieTitle = movieTitle;
        this.year = year;
        this.ratings = ratings;
        this.description = description;
        this.popularity = popularity;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getBanner() {
        return banner;
    }

    public String getDescription() {
        return description;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public Double getRatings() {
        return ratings;
    }

    public String getYear() {
        return year;
    }

    public Double getPopularity() {
        return popularity;
    }
}
