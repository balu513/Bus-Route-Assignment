package com.example.balu.myapplication.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.balu.myapplication.Model.Bus;
import com.example.balu.myapplication.Model.BusImpl;
import com.example.balu.myapplication.Presenter.iBusList;
import com.example.balu.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements iBusList {

    private static final String TAG = "MainActivity";
    private ListView listViewBuses;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewBuses = findViewById(R.id.listview_buses);
        progressBar = new ProgressDialog(this);
        showProgressBar();

        new BusImpl().getBusList(getApplicationContext(), this);
    }

    private void showProgressBar() {
        progressBar.setCancelable(true);//you can cancel it by pressing back button
        progressBar.setMessage("loading");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();

    }

    @Override
    public void getBusList(final List<Bus> list) {
        Log.d(TAG, list.toString());
        progressBar.cancel();
        listViewBuses.setAdapter(new BusesAdapter(this, list));
        listViewBuses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent = new Intent(MainActivity.this, RouteDetailActivity.class);
                intent.putStringArrayListExtra("stops_list", (ArrayList<String>) list.get(pos).getListStops());
                intent.putExtra("name", list.get(pos).getName());
                intent.putExtra("desc", list.get(pos).getDesc());
                intent.putExtra("url", list.get(pos).getImg());
                startActivity(intent);
            }
        });
    }
}
