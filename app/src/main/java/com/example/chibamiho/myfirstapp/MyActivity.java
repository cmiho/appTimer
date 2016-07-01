package com.example.chibamiho.myfirstapp;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Chronometer;

public class MyActivity extends AppCompatActivity {
    boolean chk = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Chronometer mChronometer = (Chronometer) findViewById(R.id.chronometer);

        //start button//
        Button Start = (Button)findViewById(R.id.Start);
        Start.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        if (chk) {
                            mChronometer.start();
                        }
                        else {
                            mChronometer.setBase(SystemClock.elapsedRealtime());
                            mChronometer.start();
                        }
                    }
                }
        );

        //stop button//
        Button sp_b = (Button)findViewById(R.id.Stop);
        sp_b.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        mChronometer.stop();
                        chk = true;
                    }
                }
        );

        //reset button//
        Button rt_b = (Button)findViewById(R.id.Reset);
        rt_b.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        mChronometer.stop();
                        mChronometer.setBase(SystemClock.elapsedRealtime());
                        chk = false;
                    }
                }
        );

    }
/*
    public void start (View view){
        Chronometer mChronometer = (Chronometer) findViewById(R.id.chronometer);
        mChronometer.start();
    }
    public void stop(View view) {
        Chronometer mChronometer = (Chronometer) findViewById(R.id.chronometer);
        mChronometer.stop();
    }
    public void reset(View view) {
        Chronometer mChronometer = (Chronometer) findViewById(R.id.chronometer);
        mChronometer.setBase(SystemClock.elapsedRealtime());
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_myv, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
