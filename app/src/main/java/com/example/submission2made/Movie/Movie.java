package com.example.submission2made.Movie;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int postermv;
    private String titlemv, releasemv, scoremv, overviewmv, statusmv, runtimemv, genremv, languagemv;

    public String getLanguagemv() {
        return languagemv;
    }

    public void setLanguagemv(String languagemv) {
        this.languagemv = languagemv;
    }

    public Movie(){

    }

    protected Movie(Parcel in) {
        postermv = in.readInt();
        titlemv = in.readString();
        releasemv = in.readString();
        scoremv = in.readString();
        overviewmv = in.readString();
        statusmv = in.readString();
        runtimemv = in.readString();
        genremv = in.readString();
        languagemv = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getPostermv() {
        return postermv;
    }

    public void setPostermv(int postermv) {
        this.postermv = postermv;
    }

    public String getTitlemv() {
        return titlemv;
    }

    public void setTitlemv(String titlemv) {
        this.titlemv = titlemv;
    }

    public String getReleasemv() {
        return releasemv;
    }

    public void setReleasemv(String releasemv) {
        this.releasemv = releasemv;
    }

    public String getScoremv() {
        return scoremv;
    }

    public void setScoremv(String scoremv) {
        this.scoremv = scoremv;
    }

    public String getOverviewmv() {
        return overviewmv;
    }

    public void setOverviewmv(String overviewmv) {
        this.overviewmv = overviewmv;
    }

    public String getStatusmv() {
        return statusmv;
    }

    public void setStatusmv(String statusmv) {
        this.statusmv = statusmv;
    }

    public String getRuntimemv() {
        return runtimemv;
    }

    public void setRuntimemv(String runtimemv) {
        this.runtimemv = runtimemv;
    }

    public String getGenremv() {
        return genremv;
    }

    public void setGenremv(String genremv) {
        this.genremv = genremv;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(postermv);
        dest.writeString(titlemv);
        dest.writeString(releasemv);
        dest.writeString(scoremv);
        dest.writeString(overviewmv);
        dest.writeString(statusmv);
        dest.writeString(runtimemv);
        dest.writeString(genremv);
        dest.writeString(languagemv);
    }
}
