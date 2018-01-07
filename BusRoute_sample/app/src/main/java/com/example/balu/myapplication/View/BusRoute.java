package com.example.balu.myapplication.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.balu.myapplication.Model.RouteLine;
import com.example.balu.myapplication.Model.StopCirlce;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by balu on 1/5/18.
 */

public class BusRoute extends View {

    private static final String TAG = "BusRoute";
    private List<String> listroutes;
    int noOfStops;
    int gap = 400;

    public BusRoute(Context context) {
        super(context);
    }

    public BusRoute(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BusRoute(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setBusListroutes(List<String> listroutes) {
        this.listroutes = listroutes;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw:   canvas width: " + canvas.getWidth() + "  canvas height: " + canvas.getHeight());
        noOfStops = listroutes.size();
        drawRoute(canvas);
        drawStops(canvas);
    }

    private void drawRoute(Canvas canvas) {
        List<RouteLine> lineCoordinates = getLineCoordinates();
        Paint routePaint = getRoutePaint();
        for (int i = 0; i < noOfStops - 1; i++) {
            RouteLine routeLine = lineCoordinates.get(i);
            canvas.drawLine(routeLine.getStartX(), routeLine.getStartY(), routeLine.getStopX(), routeLine.getStopY(), routePaint);
        }
    }

    private void drawStops(Canvas canvas) {
        List<StopCirlce> stops = getStops();
        Paint stopPaint = getStopPaint();
        for (int i = 0; i < noOfStops; i++) {
            StopCirlce stopCirlce = stops.get(i);
            canvas.drawCircle(stopCirlce.getCx(), stopCirlce.getCy(), 50, stopPaint);
            canvas.drawText(listroutes.get(i), stopCirlce.getCx() + 100, stopCirlce.getCy(), getTextPaint());
        }
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        super.onSizeChanged(width, height, oldw, oldh);
        invalidate();
    }

    private List<RouteLine> getLineCoordinates() {
        List<RouteLine> routeLines = new ArrayList<RouteLine>();

        for (int i = 1; i <= noOfStops; i++) {
            int startX = 100;
            int startY = i * gap;
            int stopX = 100;
            int stopY = startY + gap;
            RouteLine routeLine = new RouteLine(startX, startY, stopX, stopY);
            routeLines.add(routeLine);
        }
        Log.d(TAG, routeLines.toString());
        return routeLines;
    }

    private List<StopCirlce> getStops() {
        List<StopCirlce> stops = new ArrayList<StopCirlce>();
        int radus = 50;
        for (int i = 1; i <= noOfStops + 1; i++) {
            StopCirlce stopCirlce = new StopCirlce(100, i * gap, radus);
            stops.add(stopCirlce);
        }
        Log.d(TAG, stops.toString());
        return stops;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "widthMeasureSpec:" + widthMeasureSpec + "  heightMeasureSpec:" + heightMeasureSpec);
    }

    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "getX: " + event.getX() + "  getY: " + getY());
        return super.onTouchEvent(event);
    }

    private Paint getTextPaint() {
        Paint paint = new Paint();
        paint.setTextSize(30);
        paint.setColor(Color.BLACK);
        return paint;
    }

    private Paint getStopPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private Paint getRoutePaint() {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((20));
        return paint;
    }

}
