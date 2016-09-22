package com.example.benbriggs.golfscorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String COURSE = "COURSE";

    public int mAmountOfHoles;
    @Bind(R.id.parInput) EditText mHoleInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.startRoundButton)
    public void startHoleActivity(View view){
        Intent intent = new Intent(this, HoleActivity.class);
        mAmountOfHoles = Integer.parseInt(mHoleInput.getText().toString());
        Course course = new Course(mAmountOfHoles);
        Toast.makeText(this, "hi", Toast.LENGTH_LONG).show();
        intent.putExtra(COURSE, course);
        startActivity(intent);
    }
}
