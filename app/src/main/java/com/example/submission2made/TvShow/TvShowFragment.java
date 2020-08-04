package com.example.submission2made.TvShow;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission2made.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {
    View view;
    private RecyclerView rvTvShow;
    private ArrayList<Tvshow> listTv = new ArrayList<>();
    private TypedArray dataPosterTv;
    private String[] dataTitleTv, dataScoreTv, dataReleaseTv, dataGenresTv, dataOverviewTv, dataStatusTv, dataLanguageTv, dataRuntimeTv;


    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        rvTvShow = view.findViewById(R.id.rv_tvshow);
        rvTvShow.setHasFixedSize(true);

        listTv.addAll(getDataTvshow());
        showCardViewTv();

        return view;
    }

    public ArrayList<Tvshow> getDataTvshow() {
        dataPosterTv = getResources().obtainTypedArray(R.array.data_poster_tv);
        dataTitleTv = getResources().getStringArray(R.array.data_title_tv);
        dataReleaseTv = getResources().getStringArray(R.array.data_release_tv);
        dataScoreTv = getResources().getStringArray(R.array.data_score_tv);
        dataGenresTv = getResources().getStringArray(R.array.data_genres_tv);
        dataOverviewTv = getResources().getStringArray(R.array.data_overview_tv);
        dataStatusTv = getResources().getStringArray(R.array.data_status_tv);
        dataLanguageTv = getResources().getStringArray(R.array.data_ori_language_tv);
        dataRuntimeTv = getResources().getStringArray(R.array.data_runtime_tv);

        listTv = new ArrayList<>();
        for (int i = 0; i < dataTitleTv.length; i++) {
            Tvshow tvshow = new Tvshow();
            tvshow.setPostertv(dataPosterTv.getResourceId(i, -1));
            tvshow.setTitletv(dataTitleTv[i]);
            tvshow.setReleasetv(dataReleaseTv[i]);
            tvshow.setScoretv(dataScoreTv[i]);
            tvshow.setGenretv(dataGenresTv[i]);
            tvshow.setStatustv(dataStatusTv[i]);
            tvshow.setRuntimetv(dataRuntimeTv[i]);
            tvshow.setLanguagetv(dataLanguageTv[i]);
            tvshow.setOverviewtv(dataOverviewTv[i]);
            listTv.add(tvshow);
        }
        return listTv;
    }

    private void showCardViewTv() {
        rvTvShow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        TvshowAdapter tvshowAdapter = new TvshowAdapter(listTv);
        rvTvShow.setAdapter(tvshowAdapter);

        tvshowAdapter.setOnItemClickCallback2(new TvshowAdapter.OnItemClickCallback2() {
            @Override
            public void onItemClicked(Tvshow data) {
                showTvshowSelected(data);
            }
        });
    }

    private void showTvshowSelected(Tvshow tvshow) {
        Tvshow tvshows = new Tvshow();
        tvshows.setPostertv(tvshow.getPostertv());
        tvshows.setTitletv(tvshow.getTitletv());
        tvshows.setReleasetv(tvshow.getReleasetv());
        tvshows.setScoretv(tvshow.getScoretv());
        tvshows.setGenretv(tvshow.getGenretv());
        tvshows.setStatustv(tvshow.getStatustv());
        tvshows.setRuntimetv(tvshow.getRuntimetv());
        tvshows.setLanguagetv(tvshow.getLanguagetv());
        tvshows.setOverviewtv(tvshow.getOverviewtv());

        Intent detailTvShowIntent = new Intent(view.getContext(), DetailTvShowActivity.class);
        detailTvShowIntent.putExtra(DetailTvShowActivity.EXTRA_TV, tvshow);
        startActivity(detailTvShowIntent);
    }
}
