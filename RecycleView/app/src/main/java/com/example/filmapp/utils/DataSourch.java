package com.example.filmapp.utils;

import com.example.filmapp.R;
import com.example.filmapp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSourch {


    public static List<Movie> getPopularMovie() {
        List<Movie> ListMovie = new ArrayList<>();
        ListMovie.add(new Movie("Imax Mulan", R.drawable.popular1, R.drawable.popular1));
        ListMovie.add(new Movie("De Piraten", R.drawable.popular2, R.drawable.popular2));
        ListMovie.add(new Movie("Black Widow", R.drawable.popular3, R.drawable.popular3));
        ListMovie.add(new Movie("Sebelum Iblis Menjemput 2", R.drawable.popular4, R.drawable.popular4));
        ListMovie.add(new Movie("3 6 5", R.drawable.popular5, R.drawable.popular5));
        ListMovie.add(new Movie("How To Buy a Friend", R.drawable.popular6, R.drawable.popular6));
        return ListMovie;
    }
    public static List<Movie> getWeekMovie() {
        List<Movie> ListMovie = new ArrayList<>();
        ListMovie.add(new Movie("3 6 5", R.drawable.popular5, R.drawable.popular5));
        ListMovie.add(new Movie("How To Buy a Friend", R.drawable.popular6, R.drawable.popular6));
        ListMovie.add(new Movie("Imax Mulan", R.drawable.popular1, R.drawable.popular1));
        ListMovie.add(new Movie("De Piraten", R.drawable.popular2, R.drawable.popular2));


        return ListMovie;
    }
}
