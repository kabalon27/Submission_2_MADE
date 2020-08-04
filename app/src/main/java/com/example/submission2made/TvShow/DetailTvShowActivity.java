package com.example.submission2made.TvShow;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission2made.R;

public class DetailTvShowActivity extends AppCompatActivity {

    TextView tvTitle, tvRelease, tvScore, tvGenres, tvStatus, tvRuntime, tvLanguage, tvOverview;
    ImageView tvPoster;
    public static final String EXTRA_TV ="extra_tv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        ActionBar actionBar2 = getSupportActionBar();
        if (actionBar2 != null) {
            actionBar2.setDisplayHomeAsUpEnabled(true);
            actionBar2.setTitle(R.string.title_tv);
        }

        tvPoster = findViewById(R.id.poster_tv);
        tvTitle = findViewById(R.id.title_tv);
        tvRelease = findViewById(R.id.text_release_tv);
        tvScore = findViewById(R.id.text_score_tv);
        tvGenres = findViewById(R.id.text_genre_tv_);
        tvStatus = findViewById(R.id.text_status_tv);
        tvRuntime = findViewById(R.id.text_runtime_tv);
        tvLanguage = findViewById(R.id.text_ori_text_tv);
        tvOverview = findViewById(R.id.text_overview_tv);

        Tvshow tvshow = getIntent().getParcelableExtra(EXTRA_TV);

        int Postertv = tvshow.getPostertv();
        String Titletv = tvshow.getTitletv();
        String Releasetv = tvshow.getReleasetv();
        String Scoretv = tvshow.getScoretv();
        String Genrestv = tvshow.getGenretv();
        String Statustv = tvshow.getStatustv();
        String Runtimetv = tvshow.getRuntimetv();
        String Languagetv = tvshow.getLanguagetv();
        String Overviewtv = tvshow.getOverviewtv();

        tvPoster.setImageResource(Postertv);
        tvTitle.setText(Titletv);
        tvRelease.setText(Releasetv);
        tvScore.setText(Scoretv);
        tvGenres.setText(Genrestv);
        tvStatus.setText(Statustv);
        tvRuntime.setText(Runtimetv);
        tvLanguage.setText(Languagetv);
        tvOverview.setText(Overviewtv);
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
