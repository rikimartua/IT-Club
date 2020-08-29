package com.example.filmapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.filmapp.models.Movie;
import com.example.filmapp.adapters.MovieAdapter;
import com.example.filmapp.adapters.MovieItemClickListener;
import com.example.filmapp.R;
import com.example.filmapp.models.Slide;
import com.example.filmapp.adapters.SlidePagerAdapter;
import com.example.filmapp.utils.DataSourch;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> ListSlide;
    private ViewPager sildePager;
    private TabLayout indicator;
    private RecyclerView recyclerView,recyclerViewWeek;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniViews();
        iniSlide();
        iniPopularView();
        iniWeekMovie();
    }

    private void iniPopularView() {
        //Recyclerview
        //Data
        MovieAdapter movieAdapter=new MovieAdapter(this, DataSourch.getPopularMovie(),this);
        recyclerView.setAdapter(movieAdapter);
        // Manage positionn
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
    private void iniWeekMovie() {
        //Recyclerview
        //Data
        MovieAdapter movieAdapter=new MovieAdapter(this, DataSourch.getWeekMovie(),this);
        recyclerViewWeek.setAdapter(movieAdapter);
        // Manage positionn
        recyclerViewWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniSlide() {
        //Mempersiapkan List slide
        //Prepare a slide List
        ListSlide =new ArrayList<>();
        ListSlide.add(new Slide(R.drawable.slide1,"Slide Title \nmore text Here"));
        ListSlide.add(new Slide(R.drawable.slide2,"Slide Title \nmore text Here"));
        ListSlide.add(new Slide(R.drawable.slide1,"Slide Title \nmore text Here"));
        ListSlide.add(new Slide(R.drawable.slide2,"Slide Title \nmore text Here"));
        SlidePagerAdapter adapter=new SlidePagerAdapter(this,ListSlide);
        sildePager.setAdapter(adapter);

        //setup Time
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);
        indicator.setupWithViewPager(sildePager,true);
    }

    private void iniViews() {

        sildePager=findViewById(R.id.slide_pager);
        indicator=findViewById(R.id.indicator);
        recyclerView=findViewById(R.id.rv_movie);
        recyclerViewWeek=findViewById(R.id.rv_movie_week);
    }

    @Override
    public void onMovieClick(Movie movie, ImageView MovieImageView) {
        //here to move and transfer information
        Intent intent=new Intent(this,MovieDetailActivity.class);
        intent.putExtra("title",movie.getTitile());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCOVER",movie.getCoverImg());



        //to make animation
        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,MovieImageView,"sharedName");
        startActivity(intent,options.toBundle());
        //toast text
        Toast.makeText(this,"Title : "+ movie.getTitile(),Toast.LENGTH_LONG).show();
    }

    class SliderTimer extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sildePager.getCurrentItem()<ListSlide.size()-1){
                        sildePager.setCurrentItem(sildePager.getCurrentItem()+1);
                    }
                    else
                        sildePager.setCurrentItem(0);
                }
            });
        }
    }
}
