package com.example.balu.myapplication.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.balu.myapplication.Model.Bus;
import com.example.balu.myapplication.R;
import java.util.List;

/**
 * Created by balu on 1/5/18.
 */

public class BusesAdapter extends BaseAdapter {

    private Context context;
    private List<Bus> list;

    public BusesAdapter(Context context, List<Bus> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Bus getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item, null);
        ViewHolder viewHolder = null;

        if (view == null) {
            viewHolder = new ViewHolder();
            viewHolder.tvBusName = (TextView) itemView.findViewById(R.id.tv_busname);
            viewHolder.ivBus = (ImageView) itemView.findViewById(R.id.iv_bus);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }
        viewHolder.tvBusName.setText(list.get(i).getName());
        viewHolder.ivBus.setImageBitmap(list.get(i).getImgBitmap());
        return itemView;
    }

    private static class ViewHolder {
        public ImageView ivBus;
        public TextView tvBusName;
    }


}
