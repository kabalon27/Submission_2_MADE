package com.example.submission2made.TvShow;

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

public class TvshowAdapter extends RecyclerView.Adapter<TvshowAdapter.CardViewViewHolder> {
    private ArrayList<Tvshow> listTv;
    private OnItemClickCallback2 onItemClickCallback2;

    public void setOnItemClickCallback2(OnItemClickCallback2 onItemClickCallback2){
        this.onItemClickCallback2 = onItemClickCallback2;
    }

    public TvshowAdapter(ArrayList<Tvshow> listTv) {
        this.listTv = listTv;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_card_tvshow, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Tvshow tvshow = listTv.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvshow.getPostertv())
                .apply(new RequestOptions().override(300, 500))
                .into(holder.tvPoster);
        holder.tvTitle.setText(tvshow.getTitletv());
        holder.tvRelease.setText(tvshow.getReleasetv());
        holder.tvScore.setText(tvshow.getScoretv());
        holder.tvGenres.setText(tvshow.getGenretv());
        holder.tvOverview.setText(tvshow.getOverviewtv());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback2.onItemClicked(listTv.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView tvPoster;
        TextView tvTitle, tvRelease, tvScore, tvOverview, tvGenres;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPoster = itemView.findViewById(R.id.img_tv_poster);
            tvTitle = itemView.findViewById(R.id.title_tv);
            tvRelease = itemView.findViewById(R.id.release_tv);
            tvScore = itemView.findViewById(R.id.score_tv);
            tvGenres = itemView.findViewById(R.id.genre_tv);
            tvOverview = itemView.findViewById(R.id.overview_tv);
        }
    }

    public interface OnItemClickCallback2{
        void onItemClicked(Tvshow data);
    }
}
