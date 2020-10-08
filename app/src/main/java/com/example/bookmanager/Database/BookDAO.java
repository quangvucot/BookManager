package com.example.bookmanager.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bookmanager.Model.NguoiDung;
import com.example.bookmanager.Model.Sach;

import java.util.ArrayList;
import java.util.List;

class BookDAO {
    private MySQL mySQL;

    public BookDAO(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    //them
    //sua
    //xoa
    //select
    public long themSach(Sach sach) {
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maHoaDon", sach.maHoaDon);
        contentValues.put("tenSach", sach.tenSach);
        contentValues.put("tacgia", sach.tacgia);
        contentValues.put("nhaXuatBan", sach.nhaXuatBan);
        contentValues.put("thoiGianThem", sach.thoiGianThem);
        contentValues.put("giaSach", sach.giaSach);
        contentValues.put("soLuong", sach.soLuong);
        return sqLiteDatabase.insert("table_book", null, contentValues);
    }

    public int suaSach(Sach sach) {
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maSach", sach.maSach);
        contentValues.put("maHoaDon", sach.maHoaDon);
        contentValues.put("tenSach", sach.tenSach);
        contentValues.put("tacgia", sach.tacgia);
        contentValues.put("nhaXuatBan", sach.nhaXuatBan);
        contentValues.put("thoiGianThem", sach.thoiGianThem);
        contentValues.put("giaSach", sach.giaSach);
        contentValues.put("soLuong", sach.soLuong);
        return sqLiteDatabase.update("table_book", contentValues, "maSach", new String[]{sach.maSach});

    }

    public List<Sach> getAllUser() {
        List<Sach> sachList = new ArrayList<>();
        String truyVan = "SELECT * FROM table_book";
        Cursor cursor = mySQL.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String maSach = cursor.getString(cursor.getColumnIndex("maSach"));
                String maHoaDon = cursor.getString(cursor.getColumnIndex("maHoaDon"));
                String tenSach = cursor.getString(cursor.getColumnIndex("tenSach"));
                String tacgia = cursor.getString(cursor.getColumnIndex("tacgia"));
                String nhaXuatBan = cursor.getString(cursor.getColumnIndex("nhaXuatBan"));
                String thoiGianThem = cursor.getString(cursor.getColumnIndex("thoiGianThem"));
                String soLuong = cursor.getString(cursor.getColumnIndex("soLuong"));
                String giaSach = cursor.getString(cursor.getColumnIndex("giaSach"));
                Sach sach = new Sach();
                sach.maSach = maSach;
                sach.maHoaDon = maHoaDon;
                sach.tenSach = tenSach;
                sach.nhaXuatBan = nhaXuatBan;
                sach.tacgia = tacgia;
                sach.thoiGianThem = thoiGianThem;
                sach.soLuong = Integer.parseInt(soLuong);
                sach.giaSach = Float.valueOf(giaSach);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sachList;
    }

}
