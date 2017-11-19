package com.othershe.chartstest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lineChart(View v) {
        startActivity(new Intent(this, LineChartActivity.class));
    }

    public void barChart(View v) {
        startActivity(new Intent(this, BarChartActivity.class));
    }
}
