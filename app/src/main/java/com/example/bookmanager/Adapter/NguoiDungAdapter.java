package com.example.bookmanager.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookmanager.Database.MySQL;
import com.example.bookmanager.Database.UserDAO;
import com.example.bookmanager.Model.NguoiDung;
import com.example.bookmanager.R;
import com.example.bookmanager.TrangChu.TrangChuActivity;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {


    public NguoiDungAdapter(List<NguoiDung> nguoiDungList) {
        this.nguoiDungList = nguoiDungList;
    }

    private List<NguoiDung> nguoiDungList;

    @Override
    public int getCount() {
        return nguoiDungList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
//
//    private class ViewHolder {
//        ImageView avatar;
//        TextView hoTen, username;
//
//    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_trangchu, parent, false);
        TextView tvTTHoTen = convertView.findViewById(R.id.tvTTHoTen);
        TextView tvTTUsername = convertView.findViewById(R.id.tvTTUsername);
        tvTTHoTen.setText(nguoiDungList.get(position).tenNguoiDung);
        tvTTUsername.setText(nguoiDungList.get(position).username);

        TextView tvXoaUser = convertView.findViewById(R.id.tvXoaUser);
        tvXoaUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder aBuilder = new AlertDialog.Builder(parent.getContext());
                aBuilder.setTitle("Cảnh Báo");
                aBuilder.setMessage("Bạn có muốn xóa người dùng này không?");
                aBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UserDAO userDAO = new UserDAO(new MySQL(parent.getContext()));
                        String username = nguoiDungList.get(position).username;
                        boolean ketqua = userDAO.xoaNguoiDung(username);
                        if (ketqua) {
                            Toast.makeText(parent.getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                            nguoiDungList.remove(position);
                            notifyDataSetChanged();
                        } else {
                            Toast.makeText(parent.getContext(), "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                aBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                aBuilder.show();
            }

        });
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//            layoutInflater.inflate(layout, null);
//            viewHolder = new ViewHolder();
//            viewHolder.avatar = convertView.findViewById(R.id.imgAvatar);
//            viewHolder.hoTen = convertView.findViewById(R.id.tvTTHoTen);
//            viewHolder.username = convertView.findViewById(R.id.tvTTUsername);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        viewHolder.hoTen.setText(nguoiDungList.get(position).tenNguoiDung);
//        viewHolder.username.setText(nguoiDungList.get(position).username);
        return convertView;
    }
}
