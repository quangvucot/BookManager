package com.example.bookmanager.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bookmanager.Model.HoaDon;

import java.util.ArrayList;
import java.util.List;

class BillDao {
    private MySQL sql;

    public BillDao() {
        MySQL mySQL = this.sql;
    }

    public void xoaHoaDon(String id) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        sqLiteDatabase.delete("table_bill", "maHoaDon", new String[]{id});
    }

    public long themHoaDon(HoaDon hoaDon) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nguoiMua", hoaDon.nguoiMua);
        contentValues.put("nguoiTao", hoaDon.nguoiTao);
        contentValues.put("Email", hoaDon.email);
        contentValues.put("gia", hoaDon.gia);
        contentValues.put("soLuong", hoaDon.soLuong);
        contentValues.put("tongTien", hoaDon.tongTien);

        return sqLiteDatabase.insert("table_bill", null, contentValues);
    }

    public int suaHoaDon(HoaDon hoaDon) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nguoiMua", hoaDon.nguoiMua);
        contentValues.put("maHoaDon", hoaDon.maHoaDon);
        contentValues.put("nguoiTao", hoaDon.nguoiTao);
        contentValues.put("Email", hoaDon.email);
        contentValues.put("gia", hoaDon.gia);
        contentValues.put("soLuong", hoaDon.soLuong);
        contentValues.put("tongTien", hoaDon.tongTien);
        return sqLiteDatabase.update("table_bill", contentValues, "maHoaDon", new String[]{hoaDon.maHoaDon});
    }

    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> hoaDonList = new ArrayList<>();

        String truyVan = "SELECT * FROM nguoi_dung";
        Cursor cursor = sql.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String NguoiTao = cursor.getString(cursor.getColumnIndex("nguoiTao"));
                String maHoaDon = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String nguoiMua = cursor.getString(cursor.getColumnIndex("nguoiMua"));
                String Email = cursor.getString(cursor.getColumnIndex("Email"));
                String gia = cursor.getString(cursor.getColumnIndex("gia"));
                String soLuong = cursor.getString(cursor.getColumnIndex("soLuong"));
                String tongTien = cursor.getString(cursor.getColumnIndex("tongTien"));

                HoaDon hoaDon = new HoaDon();
                hoaDon.nguoiMua = nguoiMua;
                hoaDon.nguoiTao = NguoiTao;
                hoaDon.email = Email;
                hoaDon.maHoaDon = maHoaDon;
                hoaDon.gia = Float.parseFloat(gia);
                hoaDon.soLuong = Integer.parseInt(soLuong);
                hoaDon.tongTien = Integer.parseInt(tongTien);


                hoaDonList.add(hoaDon);

                cursor.moveToNext();
            }
            cursor.close();

        }

        return hoaDonList;

    }
}

