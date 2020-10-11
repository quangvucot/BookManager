package com.example.bookmanager.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQL extends SQLiteOpenHelper {
    public MySQL(Context context) {
        super(context, "mydata.sql", null, 1);
    }

    //KHoi Tao Ban
    @Override
    public void onCreate(SQLiteDatabase db) {

        String table_user = "CREATE TABLE USER (username varchar(50) primary key, " +
                "password varchar(50) NOT NULL, " +
                "tenNguoiDung varchar(50), " +
                "emailNguoiDung varchar(50), " +
                "repeatPassword varchar(50) NOT NULL, " +
                "sdtNguoiDung varchar(11)) ";

        String table_book = "CREATE TABLE BOOK (idSach char(5) primary key, " +
                "tenSach varchar(50), " +
                "giaSach FLOAT, " +
                "soLuong INTEGER, " +
                "nhaXuatBan varchar(50), " +
                "maLoaiSach char(5), " +
                "tacGia varchar(50)) ";


        String table_bill = "CREATE TABLE BILL (maHoaDon char(5) primary key NOT NULL" +
                ",nguoiMua varchar(50)" +
                ",nguoiTao varchar(50)" +
                ",thoigian DATE" +
                ",soLuong INTEGER" +
                ",tongTien FLOAT" +
                ",email varchar(50)" +
                ",gia FLOAT)";

//        String bill_data = "create table billData " + "(idHoaDon NCHAR(5)," +
//                "idSach NCHAR(5)," +
//                "ghiChu NVARCHAR(150))";
//        String table_loaiSach = "create table kindOfBook" + "( idLoaiSach NCHAR(5)," +
//                "tenLoai NVARCHAR(50))";
        db.execSQL(table_user);
        db.execSQL(table_book);
        db.execSQL(table_bill);
//        db.execSQL(bill_data);
//        db.execSQL(table_loaiSach);

    }

    //cap nhat cau truc sql
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
