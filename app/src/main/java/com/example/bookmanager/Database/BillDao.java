package com.example.bookmanager.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bookmanager.Model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class BillDao {
    private MySQL sql;

    public BillDao(MySQL mySQL) {
        MySQL sql = this.sql;
    }

    public void xoaHoaDon(String id) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        sqLiteDatabase.delete("BILL", "maHoaDon", new String[]{id});
    }

    public boolean themHoaDon(HoaDon hoaDon) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon", hoaDon.maHoaDon);
        contentValues.put("nguoiMua", hoaDon.nguoiMua);
        contentValues.put("nguoiTao", hoaDon.nguoiTao);
        contentValues.put("email", hoaDon.email);
        contentValues.put("thoigian", hoaDon.thoiGian);
        contentValues.put("gia", hoaDon.gia);
        contentValues.put("soLuong", hoaDon.soLuong);
        contentValues.put("tongTien", hoaDon.tongTien);
        long kq = sqLiteDatabase.insert("BILL", null, contentValues);
        if (kq > 0)
            return true;
        else return false;

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
        return sqLiteDatabase.update("BILL", contentValues, "maHoaDon", new String[]{hoaDon.maHoaDon});
    }

    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> hoaDonList = new ArrayList<>();
        String truyVan = "SELECT * FROM BILL";
        Cursor cursor = sql.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String nguoiTao = cursor.getString(2);
                String maHoaDon = cursor.getString(0);
                String nguoiMua = cursor.getString(1);
                String thoiGian = cursor.getString(3);
                String Email = cursor.getString(6);
                String gia = cursor.getString(7);
                String soLuong = cursor.getString(4);
                String tongTien = cursor.getString(5);

                HoaDon hoaDon = new HoaDon();
                hoaDon.nguoiMua = nguoiMua;
                hoaDon.nguoiTao = nguoiTao;
                hoaDon.email = Email;
                hoaDon.thoiGian = thoiGian;
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

