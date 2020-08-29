package com.example.filmapp.adapters;

import android.widget.ImageView;

import com.example.filmapp.models.Movie;

public interface MovieItemClickListener {
    void onMovieClick(Movie movie, ImageView MovieImageView);
}
