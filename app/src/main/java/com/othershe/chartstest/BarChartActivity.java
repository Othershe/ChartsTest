package com.othershe.chartstest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart barChart = findViewById(R.id.bar_chart);

        barChart.setNoDataText("暂无数据");
        Description description = new Description();
        description.setText("just a test");
        barChart.setDescription(description);
        // 是否绘制表格背景
        barChart.setDrawGridBackground(true);

        // 是否可以缩放
//        lineChart.setScaleEnabled(false);
        // 是否可以拖拽
//        lineChart.setDragEnabled(false);


        YAxis leftAxis = barChart.getAxisLeft();
        YAxis rightAxis = barChart.getAxisRight();

        // 设置left-y轴属性
        leftAxis.setDrawGridLines(false);
        leftAxis.setTextColor(Color.RED);
        leftAxis.setAxisMinimum(-100f);
        leftAxis.setAxisMaximum(100f);
        leftAxis.setAxisLineColor(Color.BLACK);
        leftAxis.setLabelCount(20);

        // 设置zero-line
        leftAxis.setDrawZeroLine(true);
        leftAxis.setZeroLineColor(Color.BLACK);

        // 不显示right-y轴
        rightAxis.setEnabled(false);

        // 设置x轴属性
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.RED);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(20);
        xAxis.setLabelCount(20);

//        BarDataSet barDataSet = new BarDataSet(initData(), "BarChar-1");
//        barDataSet.setColor(Color.RED);
//        barDataSet.setHighLightColor(Color.GREEN);
//        barDataSet.setValueTextSize(12f);
//        BarData barData = new BarData(barDataSet);
//        barData.setBarWidth(0.8f);
//        barChart.setFitBars(true);
//        barChart.setData(barData);
//        barChart.invalidate();

        BarDataSet barDataSet1 = new BarDataSet(initGroupData1(), "group1");
        barDataSet1.setColor(Color.RED);
        BarDataSet barDataSet2 = new BarDataSet(initGroupData2(), "group2");
        barDataSet2.setColor(Color.BLUE);
        float groupSpace = 0.1f;
        float barSpace = 0.02f;
        float barWidth = 0.45f;
        BarData barData = new BarData(barDataSet1, barDataSet2);
        barData.setBarWidth(barWidth); // set the width of each bar
        barChart.setData(barData);
        barChart.groupBars(0, groupSpace, barSpace);
        barChart.invalidate();
    }

    private List<BarEntry> initData() {
        int[] points = new int[]{0, 30, 1, 80, 2, 60, 3, 50, 4, 20, 5, 70, 6, -40, 7, 10, 8, 90, 9, 80, 10, 30};
        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            entries.add(new BarEntry(points[2 * i], points[2 * i + 1]));
        }
        return entries;
    }

    private List<BarEntry> initGroupData1() {
        int[] d1 = new int[]{30, 80, 60, 50, 20, 70, -40, 10, 90, 80, 30};
        List<BarEntry> entries1 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            entries1.add(new BarEntry(i, d1[i]));
        }
        return entries1;
    }

    private List<BarEntry> initGroupData2() {
        int[] d2 = new int[]{60, 40, 20, 80, 70, 10, -80, 30, 50, 90, 70};
        List<BarEntry> entries2 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            entries2.add(new BarEntry(i, d2[i]));
        }
        return entries2;
    }
}
