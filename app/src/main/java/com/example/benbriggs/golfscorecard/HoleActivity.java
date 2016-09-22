package com.example.benbriggs.golfscorecard;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HoleActivity extends AppCompatActivity implements ParDialogFragment.ParDialogListener{

    public Course mCourse;
    public Hole mHole;

    @Bind(R.id.currentStrokesView)
    TextView mCurrentStrokesView;
    @Bind(R.id.parView)
    TextView mParView;
    @Bind(R.id.nextHoleButton)
    Button mNextHoleButton;
    @Bind(R.id.holeTitle)
    TextView mHoleTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mCourse = intent.getParcelableExtra(MainActivity.COURSE);

        int currentHole = mCourse.getCurrentHole() + 1;
        mHoleTitle.setText("Hole " + currentHole);

        DialogFragment parDialogFragment = new ParDialogFragment();
        parDialogFragment.show(getFragmentManager(), "ParDialogFragment");

        if(mCourse.getAmountOfHoles() - 1 == mCourse.getCurrentHole()){
            //code for last hole here
            mNextHoleButton.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    public void onClick(DialogFragment dialog, int i, String[] types){
        int par = i + 2;
        mHole = new Hole(par);
        mParView.setText("" + par);
    }

    @OnClick (R.id.addStrokeButton)
    public void addStroke(){
        mHole.incrementStrokes();
        mCurrentStrokesView.setText("" + mHole.getStrokes());
    }

    @OnClick (R.id.nextHoleButton)
    public void startNextHole(View view){
        Intent intent = new Intent(this, HoleActivity.class);
        mCourse.addHole(mHole);
        mCourse.incrementCurrentHole();
        intent.putExtra(MainActivity.COURSE, mCourse);
        startActivity(intent);
    }
}
