package com.othershe.chartstest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class LineChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        LineChart lineChart = findViewById(R.id.line_chart);
        lineChart.setNoDataText("暂无数据");
        Description description = new Description();
        description.setText("just a test");
        lineChart.setDescription(description);
        // 是否绘制表格背景
        lineChart.setDrawGridBackground(true);

        // 是否可以缩放
//        lineChart.setScaleEnabled(false);
        // 是否可以拖拽
//        lineChart.setDragEnabled(false);


        YAxis leftAxis = lineChart.getAxisLeft();
        YAxis rightAxis = lineChart.getAxisRight();
        // 添加最大值、最小值的限制线
        LimitLine ll = new LimitLine(-11f, "min-line");
        ll.setLineColor(Color.RED);
        ll.setLineWidth(2f);
        ll.setTextColor(Color.BLACK);
        ll.setTextSize(12f);
        leftAxis.addLimitLine(ll);

        // 设置left-y轴属性
        leftAxis.setDrawGridLines(false);
        leftAxis.setTextColor(Color.RED);
        leftAxis.setAxisMinimum(-20f);
        leftAxis.setAxisMaximum(20f);
        leftAxis.setAxisLineColor(Color.BLACK);
        leftAxis.setLabelCount(20);

        // 设置zero-line
        leftAxis.setDrawZeroLine(true);
        leftAxis.setZeroLineColor(Color.BLACK);

        // 不显示right-y轴
        rightAxis.setEnabled(false);

        // 设置x轴属性
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.RED);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(20);
        xAxis.setLabelCount(12);


        LineDataSet dataSet1 = new LineDataSet(initData(0), "Label-1");
        // 设置手指触摸的十字线
        dataSet1.setHighlightEnabled(true);
        dataSet1.setDrawHighlightIndicators(true);
        dataSet1.setHighLightColor(Color.RED);

        //设置连接线的宽度颜色
        dataSet1.setLineWidth(2f);
        dataSet1.setColor(Color.RED);
        // 设置圆圈颜色
        dataSet1.setCircleColor(Color.RED);
        dataSet1.setValueTextColor(Color.BLUE);
        dataSet1.setValueTextSize(12f);

        LineDataSet dataSet2 = new LineDataSet(initData(3), "Label-2");
        // 设置手指触摸的十字线
        dataSet2.setHighlightEnabled(true);
        dataSet2.setDrawHighlightIndicators(true);
        dataSet2.setHighLightColor(Color.GREEN);

        //设置连接线的宽度颜色
        dataSet2.setLineWidth(2f);
        dataSet2.setColor(Color.GREEN);
        // 设置圆圈颜色
        dataSet2.setCircleColor(Color.GREEN);
        dataSet2.setValueTextColor(Color.GREEN);
        dataSet2.setValueTextSize(12f);
        dataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        // 不显示定位线
//        dataSet.setHighlightEnabled(false);
        // 不显示坐标点数据
//        dataSet.setDrawValues(false);
        // 不显示小圆点
//        dataSet.setDrawCircles(false);
        LineData lineData = new LineData(dataSet1, dataSet2);
        lineChart.setData(lineData);
        lineChart.invalidate();

    }

    private List<Entry> initData(int offset) {
        int[] points = new int[]{0, 0, 1, 4, 2, 2, 3, 6, 4, 0, 5, 8, 6, 1, 7, 5, 8, 3, 9, 9, 10, -10, 20, 10};
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            entries.add(new Entry(points[2 * i], points[2 * i + 1] + offset));
        }
        return entries;
    }

}
