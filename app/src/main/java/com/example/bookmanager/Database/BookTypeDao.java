package com.example.bookmanager.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bookmanager.Model.Sach;
import com.example.bookmanager.Model.TheLoai;

import java.util.ArrayList;
import java.util.List;

class BookTypeDao {
    private MySQL sql;

    public BookTypeDao(MySQL sql) {
        this.sql = sql;
    }

    public long themLoaiSach(TheLoai theLoai) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("theLoaiSach", theLoai.theLoaiSach);
        contentValues.put("viTri", theLoai.viTri);
        contentValues.put("moTa", theLoai.moTa);
        contentValues.put("maLoaiSach", theLoai.maLoaiSach);
        return sqLiteDatabase.insert("table_loaiSach", null, contentValues);
    }

    public int suaSach(TheLoai theLoai) {
        SQLiteDatabase sqLiteDatabase = sql.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("theLoaiSach", theLoai.theLoaiSach);
        contentValues.put("viTri", theLoai.viTri);
        contentValues.put("moTa", theLoai.moTa);
        contentValues.put("maLoaiSach", theLoai.maLoaiSach);

        return sqLiteDatabase.update("table_loaiSach", contentValues, "maLoaiSach", new String[]{theLoai.maLoaiSach});

    }

    public List<TheLoai> getAllUser() {
        List<TheLoai> theLoaiList = new ArrayList<>();
        String truyVan = "SELECT * FROM table_loaiSach";
        Cursor cursor = sql.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String maLoaiSach = cursor.getString(cursor.getColumnIndex("maLoaiSach"));
                String moTa = cursor.getString(cursor.getColumnIndex("moTa"));
                String viTri = cursor.getString(cursor.getColumnIndex("viTri"));
                String theLoaiSach = cursor.getString(cursor.getColumnIndex("theLoaiSach"));
                TheLoai theLoai = new TheLoai();
                theLoai.maLoaiSach = maLoaiSach;
                theLoai.moTa = moTa;
                theLoai.viTri = viTri;
                theLoai.theLoaiSach = theLoaiSach;
                cursor.moveToNext();
            }
            cursor.close();
        }
        return theLoaiList;
    }
}
