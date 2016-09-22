package com.example.benbriggs.golfscorecard;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by benbriggs on 21/09/2016.
 */
public class Hole implements Parcelable{
    private int mParForHole;
    private int mStrokes;

    public Hole(int par){
        mParForHole = par;
        mStrokes = 0;
    }

    public void incrementStrokes(){
        mStrokes++;
    }

    public int getParForHole() {
        return mParForHole;
    }

    public void setParForHole(int parForHole) {
        mParForHole = parForHole;
    }

    public int getStrokes() {
        return mStrokes;
    }

    public void setStrokes(int strokes) {
        mStrokes = strokes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mParForHole);
        dest.writeInt(this.mStrokes);
    }

    protected Hole(Parcel in) {
        this.mParForHole = in.readInt();
        this.mStrokes = in.readInt();
    }

    public static final Creator<Hole> CREATOR = new Creator<Hole>() {
        @Override
        public Hole createFromParcel(Parcel source) {
            return new Hole(source);
        }

        @Override
        public Hole[] newArray(int size) {
            return new Hole[size];
        }
    };
}
