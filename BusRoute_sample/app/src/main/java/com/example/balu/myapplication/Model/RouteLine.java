package com.example.balu.myapplication.Model;

public class RouteLine {
    private int startX;
    private int startY;
    private int stopX;
    private int stopY;

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getStopX() {
        return stopX;
    }

    public void setStopX(int stopX) {
        this.stopX = stopX;
    }

    public int getStopY() {
        return stopY;
    }

    public void setStopY(int stopY) {
        this.stopY = stopY;
    }

    public RouteLine(int startX, int startY, int stopX, int stopY) {
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;

    }

    @Override
    public String toString() {
        String str = "startX:" + startX + "  startY:" + startY + "   stopX:" + stopX + "  stopY:" + stopY;
        return str;
    }
}