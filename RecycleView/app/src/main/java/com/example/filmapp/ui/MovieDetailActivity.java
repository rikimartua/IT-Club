package com.example.filmapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.filmapp.R;
import com.example.filmapp.adapters.CastAdapter;
import com.example.filmapp.models.Cast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg,MovieCoverImage;
    private TextView tv_title,tv_description;
    private FloatingActionButton play_fab;
    private CastAdapter castAdapter;
    RecyclerView rv_cast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        iniVievs();
        setRvCast();
    }

    void iniVievs(){
        //key Word
        rv_cast=findViewById(R.id.rv_cast);
        play_fab=findViewById(R.id.play_fab);
        String movieTitle=getIntent().getExtras().getString("title");
        int movieImg=getIntent().getExtras().getInt("imgURL");
        int movieCover=getIntent().getExtras().getInt("imgCOVER");

        //thumbnail
        MovieThumbnailImg=findViewById(R.id.detail_movie_image);
        Glide.with(this).load(movieImg).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(movieImg);

        //cover
        MovieCoverImage=findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(movieCover).into(MovieCoverImage);
        MovieCoverImage.setImageResource(movieCover);

        //title
        tv_title=findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description=findViewById(R.id.detail_movie_description);

        //set animation
        MovieCoverImage.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scal_animation));
    }

    void setRvCast(){
        List<Cast> ndata=new ArrayList<>();
        ndata.add(new Cast("Name xx1",R.drawable.cast1));
        ndata.add(new Cast("Name xx2",R.drawable.cast2));
        ndata.add(new Cast("Name xx3",R.drawable.cast3));
        ndata.add(new Cast("Name xx4",R.drawable.cast4));
        ndata.add(new Cast("Name xx5",R.drawable.cast5));

        castAdapter=new CastAdapter(this,ndata);
        rv_cast.setAdapter(castAdapter);
        rv_cast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }
}
