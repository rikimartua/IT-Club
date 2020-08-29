package com.example.filmapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filmapp.R;
import com.example.filmapp.models.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    Context nContext;
    List<Movie> nData;
    MovieItemClickListener movieItemClickListener;
    public MovieAdapter(Context nContext, List<Movie> nData,MovieItemClickListener listener) {
        this.nContext = nContext;
        this.nData = nData;
        movieItemClickListener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(nContext).inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.TvTitle.setText(nData.get(position).getTitile());
        holder.ImgMovie.setImageResource(nData.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return nData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView TvTitle;
        ImageView ImgMovie;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TvTitle=itemView.findViewById(R.id.item_movie_title);
            ImgMovie=itemView.findViewById(R.id.item_movie_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieItemClickListener.onMovieClick(nData.get(getAdapterPosition()),ImgMovie);
                }
            });

        }
    }
}
