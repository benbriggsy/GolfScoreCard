package com.example.benbriggs.golfscorecard;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by benbriggs on 21/09/2016.
 */
public class Course implements Parcelable{
    private Hole[] mHoles;
    private int mParForCourse;
    private int mTotalScore;
    private int mAmountOfHoles;
    private int mCurrentHole;
    private int mScoreParDiff;

    public Course(int amountOfHoles){
        mAmountOfHoles = amountOfHoles;
        mHoles = new Hole[mAmountOfHoles];
        mCurrentHole = 0;
    }

    public void incrementCurrentHole(){
        mCurrentHole++;
    }

    public void addHole(Hole hole){
        mHoles[mCurrentHole] = hole;
        mParForCourse += hole.getParForHole();
        mTotalScore += hole.getStrokes();
        mScoreParDiff = mTotalScore - mParForCourse;
    }

    public int getAmountOfHoles() {
        return mAmountOfHoles;
    }

    public void setAmountOfHoles(int amountOfHoles) {
        mAmountOfHoles = amountOfHoles;
    }

    public Hole[] getHoles() {
        return mHoles;
    }

    public void setHoles(Hole[] holes) {
        mHoles = holes;
    }

    public int getParForCourse() {
        return mParForCourse;
    }

    public int getTotalScore() {
        return mTotalScore;
    }

    public void setTotalScore(int totalScore) {
        mTotalScore = totalScore;
    }

    public int getScoreParDiff() {
        return mScoreParDiff;
    }

    public int getCurrentHole() {
        return mCurrentHole;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(this.mHoles, flags);
        dest.writeInt(this.mParForCourse);
        dest.writeInt(this.mTotalScore);
        dest.writeInt(this.mAmountOfHoles);
        dest.writeInt(this.mCurrentHole);
        dest.writeInt(this.mScoreParDiff);
    }

    protected Course(Parcel in) {
        this.mHoles = in.createTypedArray(Hole.CREATOR);
        this.mParForCourse = in.readInt();
        this.mTotalScore = in.readInt();
        this.mAmountOfHoles = in.readInt();
        this.mCurrentHole = in.readInt();
        this.mScoreParDiff = in.readInt();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel source) {
            return new Course(source);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };
}
