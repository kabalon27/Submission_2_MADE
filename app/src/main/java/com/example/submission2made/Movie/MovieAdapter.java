package com.example.submission2made.Movie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.submission2made.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CardViewViewHolder> {
    private ArrayList<Movie> listMovie;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public MovieAdapter(ArrayList<Movie> list){
        this.listMovie = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_card_movie, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Movie movie = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPostermv())
                .apply(new RequestOptions().override(300, 500))
                .into(holder.mvPoster);
        holder.mvTitle.setText(movie.getTitlemv());
        holder.mvRelease.setText(movie.getReleasemv());
        holder.mvScore.setText(movie.getScoremv());
        holder.mvGenres.setText(movie.getGenremv());
        holder.mvOverview.setText(movie.getOverviewmv());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

     class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView mvPoster;
        TextView mvTitle, mvRelease, mvScore, mvOverview, mvGenres;
        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            mvPoster = itemView.findViewById(R.id.img_mv_poster);
            mvTitle = itemView.findViewById(R.id.title_mv);
            mvRelease = itemView.findViewById(R.id.release_mv);
            mvScore = itemView.findViewById(R.id.score_mv);
            mvGenres = itemView.findViewById(R.id.genre_mv);
            mvOverview = itemView.findViewById(R.id.overview_mv);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Movie data);
    }
}
