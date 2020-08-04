package com.example.submission2made.Movie;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.submission2made.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    View view;
    private RecyclerView rvMovie;
    private ArrayList<Movie> listmovie = new ArrayList<>();
    private TypedArray dataPoster;
    private String[] dataTitle, dataScore, dataRelease, dataGenres, dataOverview, dataStatus, dataLanguage, dataRuntime;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_movie, container, false);
        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);

        listmovie.addAll(getDataMovie());
        showCardViewMovie();

        return view;
    }

    public ArrayList<Movie> getDataMovie() {
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_mv);
        dataTitle = getResources().getStringArray(R.array.data_title_mv);
        dataRelease = getResources().getStringArray(R.array.data_release_mv);
        dataScore = getResources().getStringArray(R.array.data_score_mv);
        dataGenres = getResources().getStringArray(R.array.data_genres_mv);
        dataOverview = getResources().getStringArray(R.array.data_overview_mv);
        dataStatus = getResources().getStringArray(R.array.data_status_mv);
        dataLanguage = getResources().getStringArray(R.array.data_ori_language_mv);
        dataRuntime = getResources().getStringArray(R.array.data_runtime_mv);

        listmovie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPostermv(dataPoster.getResourceId(i, -1));
            movie.setTitlemv(dataTitle[i]);
            movie.setReleasemv(dataRelease[i]);
            movie.setScoremv(dataScore[i]);
            movie.setGenremv(dataGenres[i]);
            movie.setStatusmv(dataStatus[i]);
            movie.setRuntimemv(dataRuntime[i]);
            movie.setLanguagemv(dataLanguage[i]);
            movie.setOverviewmv(dataOverview[i]);
            listmovie.add(movie);
        }
        return listmovie;
    }

    private void showCardViewMovie() {
        rvMovie.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(listmovie);
        rvMovie.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showMovieSelected(data);
            }
        });
    }

    private void showMovieSelected(Movie movie){
        Movie movies = new Movie();
        movies.setPostermv(movie.getPostermv());
        movies.setTitlemv(movie.getTitlemv());
        movies.setReleasemv(movie.getReleasemv());
        movies.setScoremv(movie.getScoremv());
        movies.setGenremv(movie.getGenremv());
        movies.setStatusmv(movie.getStatusmv());
        movies.setRuntimemv(movie.getRuntimemv());
        movies.setLanguagemv(movie.getLanguagemv());
        movies.setOverviewmv(movie.getOverviewmv());

        Intent detailMovieIntent = new Intent(view.getContext(), DetailMovieActivity.class);
        detailMovieIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
        startActivity(detailMovieIntent);
    }

}
