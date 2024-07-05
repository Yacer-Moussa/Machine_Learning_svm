package com.screenrate.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import data.model.Screen;
import data.save.isNotScreenException;
import data.save.status;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context myContext;
    private status myStatus;

    private List<Screen> myScreens;


    public MovieAdapter(Context context, status status, List<Screen> screens) {
        myContext = context;
        myStatus = status;
        myScreens = screens;
    }
    public void filter(String query) {


        notifyDataSetChanged();
    }

    public interface OnMovieClickListener {
        void onMovieClick(int position, View view);
    }
    private OnMovieClickListener onMovieClickListener;

    public void setOnMovieClickListener(OnMovieClickListener listener) {
        onMovieClickListener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        int count = myStatus.getScreenCount();
        String movieName1;
        String posterId1;
        try {
            movieName1 = myScreens.listIterator(position).next().Name;
            posterId1 = movieName1.toLowerCase();
        } catch (NullPointerException e) {
            movieName1 = "img_3";
            posterId1 = movieName1;
        }
        int id1 = myContext.getResources().getIdentifier(posterId1, "drawable", myStatus.getPackageName());
        holder.moviePosterImageView1.setImageResource(id1);
        holder.moviePosterImageView1.setTag(posterId1);
        holder.movieName.setText(movieName1);

    }

    @Override
    public int getItemCount() {
       // return Math.min(posterListMovie.size(), posterListSerie.size());
        return myStatus.getScreenCount();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePosterImageView1;
        TextView movieName;
        OnMovieClickListener onMovieClickListener;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePosterImageView1 = itemView.findViewById(R.id.moviePosterImageView1);
            movieName = itemView.findViewById(R.id.movieName);
            onMovieClickListener = MovieAdapter.this.onMovieClickListener;
            moviePosterImageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onMovieClickListener != null) {
                        int position = getBindingAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onMovieClickListener.onMovieClick(position, v);
                        }
                    }
                    else{
                        onMovieClickListener = MovieAdapter.this.onMovieClickListener;
                    }
                }
            });


        }

    }

    private void getData(){

    }
}
