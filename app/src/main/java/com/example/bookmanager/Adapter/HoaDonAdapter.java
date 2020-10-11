package com.example.bookmanager.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookmanager.Model.HoaDon;
import com.example.bookmanager.R;

import java.util.List;

public class HoaDonAdapter extends BaseAdapter {
    private List<HoaDon> hoaDonList;

    public HoaDonAdapter(List<HoaDon> hoaDonList) {
        this.hoaDonList = hoaDonList;
    }

    @Override
    public int getCount() {
        return hoaDonList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_trangchu, parent, false);
        TextView tvTTHoTen = convertView.findViewById(R.id.tvTTHoTen);
        TextView tvTTUsername = convertView.findViewById(R.id.tvTTUsername);
        tvTTHoTen.setText(hoaDonList.get(position).maHoaDon);
        tvTTUsername.setText(hoaDonList.get(position).nguoiMua);
        return convertView;
    }
}
