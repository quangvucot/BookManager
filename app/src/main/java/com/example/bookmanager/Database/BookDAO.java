package com.example.bookmanager.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.bookmanager.Model.NguoiDung;
import com.example.bookmanager.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private MySQL mySQL;

    public BookDAO(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    //them
    //sua
    //xoa
    //select

    public Boolean themSach(Sach sach) {

        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idSach", sach.maSach);
        contentValues.put("tenSach", sach.tenSach);
        contentValues.put("tacGia", sach.tacgia);
        contentValues.put("nhaXuatBan", sach.nhaXuatBan);
        contentValues.put("giaSach", sach.giaSach);
        contentValues.put("soLuong", sach.soLuong);
        long ketQua = sqLiteDatabase.insert("BOOK", null, contentValues);
        if (ketQua > 0) {
            return true;
        } else return false;
    }

    public int suaSach(Sach sach) {
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idSach", sach.maSach);
        contentValues.put("tenSach", sach.tenSach);
        contentValues.put("tacgia", sach.tacgia);
        contentValues.put("nhaXuatBan", sach.nhaXuatBan);
        contentValues.put("giaSach", sach.giaSach);
        contentValues.put("soLuong", sach.soLuong);
        return sqLiteDatabase.update("BOOK", contentValues, "maSach", new String[]{sach.maSach});

    }

    public List<Sach> getAllBook() {
        List<Sach> sachList = new ArrayList<>();
        String truyVan = "SELECT * FROM BOOK";
        Cursor cursor = mySQL.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String maSach = cursor.getColumnName(0);
                String tenSach = cursor.getColumnName(1);
                String tacgia = cursor.getString(5);
                String nhaXuatBan = cursor.getString(4);
                String soLuong = cursor.getString(3);
                String giaSach = cursor.getString(2);

                Sach sach = new Sach();
                sach.maSach = maSach;
                sach.tenSach = tenSach;
                sach.nhaXuatBan = nhaXuatBan;
                sach.tacgia = tacgia;
                sach.soLuong = Integer.parseInt(soLuong);
                sach.giaSach = Float.valueOf(giaSach);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sachList;
    }



}
