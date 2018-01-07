package com.example.balu.myapplication.Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.example.balu.myapplication.Presenter.iBusList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Asyn extends AsyncTask<Void, Void, List<Bus>> {

    private static final String TAG = "asy";

    private String response;
    private iBusList listener;

    public Asyn(String response, iBusList listener) {
        this.response = response;
        this.listener = listener;
    }

    @Override
    protected List<Bus> doInBackground(Void... voids) {
        List<String> stops = null;
        List<Bus> listBuses = new ArrayList<Bus>();
        Bus bus = null;
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray routes = jsonObject.getJSONArray("routes");
            for (int i = 0; i < routes.length(); i++) {
                bus = new Bus();

                JSONObject jsonBusObj = (JSONObject) routes.get(i);

                String id = jsonBusObj.getString("id");
                String name = jsonBusObj.getString("name");
                String description = jsonBusObj.getString("description");
                String accessible = jsonBusObj.getString("accessible");
                String image = jsonBusObj.getString("image");


                JSONArray arrayStops = jsonBusObj.getJSONArray("stops");

                stops = new ArrayList<String>();
                for (int j = 0; j < arrayStops.length(); j++) {
                    JSONObject jsonObjStop = (JSONObject) arrayStops.get(j);
                    String stopName = jsonObjStop.getString("name");
                    stops.add(stopName);
                }

                bus.setId(Integer.parseInt(id));
                bus.setName(name);
                bus.setDesc(description);
                bus.setAccesible(Boolean.parseBoolean(accessible));
                bus.setImg(image);
                bus.setListStops(stops);
                Bitmap bitmapFromURL = getBitmapFromURL(image);
                bus.setImgBitmap(bitmapFromURL);
                listBuses.add(bus);
            }
            return listBuses;
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Bus> listbuses) {
        super.onPostExecute(listbuses);
        if (listbuses != null)
            listener.getBusList(listbuses);
    }
    private Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src", src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap", "returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
            return null;
        }
    }
}
