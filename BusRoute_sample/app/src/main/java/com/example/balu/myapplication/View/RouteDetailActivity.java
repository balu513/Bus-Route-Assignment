package com.example.balu.myapplication.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.balu.myapplication.Model.RouteDetailImpl;
import com.example.balu.myapplication.Model.RouteLine;
import com.example.balu.myapplication.Model.StopCirlce;
import com.example.balu.myapplication.Presenter.iRouteDetails;
import com.example.balu.myapplication.R;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RouteDetailActivity extends AppCompatActivity implements iRouteDetails {

    private ArrayList<String> listStops;

    private String name;
    private String desc;
    private String img_url;
    private ImageView iv_bus;

    private TextView tv_bus;
    private TextView tv_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_detail);
        Intent intent = getIntent();
        if (intent != null) {
            listStops = intent.getStringArrayListExtra("stops_list");
            name = intent.getStringExtra("name");
            desc = intent.getStringExtra("desc");
            img_url = intent.getStringExtra("url");
        }
        iv_bus = findViewById(R.id.iv_busimage_detail);
        tv_bus = findViewById(R.id.tv_busname_detail);
        tv_des = findViewById(R.id.tv_desc);

        tv_bus.setText(name);
        tv_des.setText(desc);

        @SuppressLint("WrongViewCast")
        BusRoute busRoute = findViewById(R.id.viewroutes);
        busRoute.setBusListroutes(listStops);
        busRoute.invalidate();

        new RouteDetailImpl().getBitmapFromUrl(this, img_url);
    }


    @Override
    public void setRouteImage(Bitmap bitmap) {
        iv_bus.setImageBitmap(bitmap);

    }
}
