package com.example.balu.myapplication.Model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.example.balu.myapplication.Presenter.iRouteDetails;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by balu on 1/5/18.
 */

public class RouteDetailImpl {


    public void getBitmapFromUrl(final iRouteDetails listener, final String url) {

        new AsyncTask<Void, String, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... voids) {

                return getBitmapFromURL(url);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                listener.setRouteImage(bitmap);
            }
        }.execute();

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
