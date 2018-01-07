package com.example.balu.myapplication.Model;

public class StopCirlce {
    private int cx;
    private int cy;
    private int radius;

    public StopCirlce(int cx, int cy, int radius) {
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {

        String str = "cx:" + cx + "  cy:" + cy + " radius:" + radius;
        return str;
    }
}