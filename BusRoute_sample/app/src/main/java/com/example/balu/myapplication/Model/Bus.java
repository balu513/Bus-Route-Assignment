package com.example.balu.myapplication.Model;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by balu on 1/5/18.
 */

public class Bus {
    private int id;
    private String name;
    private List<String> listStops;
    private String desc;
    private boolean accesible;
    private String img;

    public Bitmap getImgBitmap() {
        return imgBitmap;
    }

    public void setImgBitmap(Bitmap imgBitmap) {
        this.imgBitmap = imgBitmap;
    }

    private Bitmap imgBitmap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getListStops() {
        return listStops;
    }

    public void setListStops(List<String> listStops) {
        this.listStops = listStops;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isAccesible() {
        return accesible;
    }

    public void setAccesible(boolean accesible) {
        this.accesible = accesible;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listStops=" + listStops +
                ", desc='" + desc + '\'' +
                ", accesible=" + accesible +
                ", img='" + img + '\'' +
                '}';
    }
}
