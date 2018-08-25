package com.android.rexben.movieapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.rexben.movieapp.model.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private Context context;
    private List<Movies> moviesList;

    MovieAdapter(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.banners_list, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        holder.movieTitle.setText(moviesList.get(position).getMovieTitle());
        String voteAverage = Double.toString(moviesList.get(position).getRatings());
        holder.reviews.setText(voteAverage);
        String poster = "https://image.tmdb.org/t/p/w342" + moviesList.get(position).getBanner();

        Picasso.with(context)
                .load(poster)
                .into(holder.banner);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView movieTitle;
        private ImageView banner;
        private TextView reviews;

        MovieHolder(View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.original_title);
            banner = itemView.findViewById(R.id.imageThumbnails);
            reviews = itemView.findViewById(R.id.reviews);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Movies clickedPosition = moviesList.get(adapterPosition);
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", moviesList.get(adapterPosition).getMovieTitle());
            intent.putExtra("popularity", moviesList.get(adapterPosition).getPopularity());
            intent.putExtra("ratings", moviesList.get(adapterPosition).getRatings());
            intent.putExtra("year", moviesList.get(adapterPosition).getYear());
            intent.putExtra("banner", moviesList.get(adapterPosition).getBanner());
            intent.putExtra("description", moviesList.get(adapterPosition).getDescription());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }


}

