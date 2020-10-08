package com.example.bookmanager.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bookmanager.Model.HoaDon;
import com.example.bookmanager.Model.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;

class BillDataDAO {
    private MySQL sql;

    public BillDataDAO(MySQL sql) {
        this.sql = sql;
    }

    public void xoaHoaDonChiTiet(String id) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        sqLiteDatabase.delete("bill_data", "idHoaDon", new String[]{id});

    }

    public long ThemHoaDon(HoaDonChiTiet hoaDonChiTiet) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idHoaDon", hoaDonChiTiet.idHoaDon);
        contentValues.put("idSach", hoaDonChiTiet.idSach);
        contentValues.put("moTa", hoaDonChiTiet.moTa);

        return sqLiteDatabase.insert("bill_data", null, contentValues);
    }

    public List<HoaDonChiTiet> getAllHoaDonChiTiet() {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();
        String get_all_query = "SELECT * FROM bill_data";
        Cursor cursor = sql.getWritableDatabase().rawQuery(get_all_query, null);
        if (cursor.getCount() > 0)
            while (cursor.isAfterLast() == false) {
                cursor.moveToFirst();
                String idHoaDon = cursor.getString(cursor.getColumnIndex("idHoaDon"));
                String idSach = cursor.getString(cursor.getColumnIndex("idSach"));
                String moTa = cursor.getString(cursor.getColumnIndex("moTa"));
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.idHoaDon = idHoaDon;
                hoaDonChiTiet.idSach = idSach;
                hoaDonChiTiet.moTa = moTa;
                hoaDonChiTietList.add(hoaDonChiTiet);
                cursor.moveToNext();
            }
        cursor.close();
        return hoaDonChiTietList;
    }

    public int suaHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idHoaDon", hoaDonChiTiet.idHoaDon);
        contentValues.put("idSach", hoaDonChiTiet.idSach);
        contentValues.put("moTa", hoaDonChiTiet.moTa);
        return sqLiteDatabase.update("bill_data", contentValues, "idHoaDon", new String[]{hoaDonChiTiet.idHoaDon});
    }
}
