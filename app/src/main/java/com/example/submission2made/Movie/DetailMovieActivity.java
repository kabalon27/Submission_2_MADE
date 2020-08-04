package com.example.submission2made.Movie;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission2made.R;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView mvTitle, mvRelease, mvScore, mvGenres, mvStatus, mvRuntime, mvLanguage, mvOverview;
        ImageView mvPoster;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.title_movie);
        }

        mvPoster = findViewById(R.id.poster_mv);
        mvTitle = findViewById(R.id.title_mv);
        mvRelease = findViewById(R.id.text_release_mv);
        mvScore = findViewById(R.id.text_score_mv);
        mvGenres = findViewById(R.id.text_genre_mv_);
        mvStatus = findViewById(R.id.text_status_mv);
        mvRuntime = findViewById(R.id.text_runtime_mv);
        mvLanguage = findViewById(R.id.text_ori_text_mv);
        mvOverview = findViewById(R.id.text_overview_mv);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        int Postermv = movie.getPostermv();
        String Titlemv = movie.getTitlemv();
        String Releasemv = movie.getReleasemv();
        String Scoremv = movie.getScoremv();
        String Genresmv = movie.getGenremv();
        String Statusmv = movie.getStatusmv();
        String Runtime = movie.getRuntimemv();
        String Languagemv = movie.getLanguagemv();
        String Overviewmv = movie.getOverviewmv();

        mvPoster.setImageResource(Postermv);
        mvTitle.setText(Titlemv);
        mvRelease.setText(Releasemv);
        mvScore.setText(Scoremv);
        mvGenres.setText(Genresmv);
        mvStatus.setText(Statusmv);
        mvRuntime.setText(Runtime);
        mvLanguage.setText(Languagemv);
        mvOverview.setText(Overviewmv);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }
}
