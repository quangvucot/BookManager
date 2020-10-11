package com.example.bookmanager.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookmanager.Model.Sach;
import com.example.bookmanager.R;

import java.util.List;

public  class SachAdapter extends BaseAdapter {
    private List<Sach> sachList;

    public SachAdapter(List<Sach> sachList) {
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
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
        TextView tvTenSach = convertView.findViewById(R.id.tvTenSach);
        TextView tvGiaSach = convertView.findViewById(R.id.tvGiaSach);
        tvTenSach.setText(sachList.get(position).tenSach);
        tvGiaSach.setText(String.valueOf(sachList.get(position).giaSach));
        return convertView;
    }
}
