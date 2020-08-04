package com.example.submission2made.TvShow;

import android.os.Parcel;
import android.os.Parcelable;

public class Tvshow implements Parcelable {
    private int postertv;
    private String titletv, releasetv, scoretv, overviewtv, statustv, runtimetv, genretv, languagetv;

    public String getLanguagetv() {
        return languagetv;
    }

    public void setLanguagetv(String languagetv) {
        this.languagetv = languagetv;
    }

    public Tvshow() {

    }

    protected Tvshow(Parcel in) {
        postertv = in.readInt();
        titletv = in.readString();
        releasetv = in.readString();
        scoretv = in.readString();
        overviewtv = in.readString();
        statustv = in.readString();
        runtimetv = in.readString();
        genretv = in.readString();
        languagetv = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(postertv);
        dest.writeString(titletv);
        dest.writeString(releasetv);
        dest.writeString(scoretv);
        dest.writeString(overviewtv);
        dest.writeString(statustv);
        dest.writeString(runtimetv);
        dest.writeString(genretv);
        dest.writeString(languagetv);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tvshow> CREATOR = new Creator<Tvshow>() {
        @Override
        public Tvshow createFromParcel(Parcel in) {
            return new Tvshow(in);
        }

        @Override
        public Tvshow[] newArray(int size) {
            return new Tvshow[size];
        }
    };

    public int getPostertv() {
        return postertv;
    }

    public void setPostertv(int postertv) {
        this.postertv = postertv;
    }

    public String getTitletv() {
        return titletv;
    }

    public void setTitletv(String titletv) {
        this.titletv = titletv;
    }

    public String getReleasetv() {
        return releasetv;
    }

    public void setReleasetv(String releasetv) {
        this.releasetv = releasetv;
    }

    public String getScoretv() {
        return scoretv;
    }

    public void setScoretv(String scoretv) {
        this.scoretv = scoretv;
    }

    public String getOverviewtv() {
        return overviewtv;
    }

    public void setOverviewtv(String overviewtv) {
        this.overviewtv = overviewtv;
    }

    public String getStatustv() {
        return statustv;
    }

    public void setStatustv(String statustv) {
        this.statustv = statustv;
    }

    public String getRuntimetv() {
        return runtimetv;
    }

    public void setRuntimetv(String runtimetv) {
        this.runtimetv = runtimetv;
    }

    public String getGenretv() {
        return genretv;
    }

    public void setGenretv(String genretv) {
        this.genretv = genretv;
    }
}
