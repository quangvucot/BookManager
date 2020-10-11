package com.example.bookmanager.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bookmanager.Model.NguoiDung;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private MySQL mySQL;

    public UserDAO(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    public boolean xoaNguoiDung(String id) {
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        long ketQua = sqLiteDatabase.delete("USER", "username=?", new String[]{id});
        if (ketQua > 0) return true;
        else return false;
    }

    public boolean themNguoiDung(NguoiDung nguoiDung) {
        // Xin quyen
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        // ghep cap gia tri vao ten cot 2
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenNguoiDung", nguoiDung.tenNguoiDung);
        contentValues.put("username", nguoiDung.username);
        contentValues.put("emailNguoiDung", nguoiDung.emailNguoiDung);
        contentValues.put("password", nguoiDung.password);
        contentValues.put("repeatPassword", nguoiDung.repeatPassword);
        contentValues.put("sdtNguoiDung", nguoiDung.sdtNguoiDung);
        long kq = sqLiteDatabase.insert("USER", null, contentValues);
        if (kq > 0) return true;
        else return false;
    }

    public int suaNguoiDung(NguoiDung nguoiDung) {
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", nguoiDung.username);
        contentValues.put("password", nguoiDung.password);
        contentValues.put("tenNguoiDung", nguoiDung.tenNguoiDung);
        contentValues.put("repeatPassword", nguoiDung.repeatPassword);
        contentValues.put("sodienThoai", nguoiDung.sdtNguoiDung);
        contentValues.put("email", nguoiDung.emailNguoiDung);
        return sqLiteDatabase.update("USER", contentValues, "username=?", new String[]{nguoiDung.username});

    }

    public List<NguoiDung> getAllUser() {
        List<NguoiDung> nguoiDungs = new ArrayList<>();
        String truyVan = "SELECT * FROM USER";
        Cursor cursor = mySQL.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String username = cursor.getColumnName(0);
                String password = cursor.getString(1);
                String repeatPassword = cursor.getString(4);
                String tenNguoiDung = cursor.getString(2);
                String email = cursor.getString(3);
                String sodienThoai = cursor.getString(5);
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.username = username;
                nguoiDung.password = password;
                nguoiDung.emailNguoiDung = email;
                nguoiDung.tenNguoiDung = tenNguoiDung;
                nguoiDung.sdtNguoiDung = sodienThoai;
                nguoiDung.repeatPassword = repeatPassword;
                nguoiDungs.add(nguoiDung);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return nguoiDungs;
    }

    public List<NguoiDung> checkDangNhap(String username, String password) {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        String truyVan = "SELECT username, password FROM USER where username LIKE '" + username + "' AND password LIKE '" + password + "'";
        Cursor cursor = mySQL.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String user = cursor.getString(cursor.getColumnIndex("username"));
                String pass = cursor.getString(cursor.getColumnIndex("password"));
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.username = user;
                nguoiDung.password = pass;
                nguoiDungList.add(nguoiDung);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return nguoiDungList;
    }

    public List<NguoiDung> CheckTonTai(String username, String email) {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        String truyVan = "SELECT username, emailNguoiDung FROM USER where username LIKE '" + username + "' OR emailNguoiDung LIKE '" + email + "'";
        Cursor cursor = mySQL.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                String user = cursor.getString(cursor.getColumnIndex("username"));
                String emailNguoiDung = cursor.getString(cursor.getColumnIndex("emailNguoiDung"));
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.username = user;
                nguoiDung.emailNguoiDung = emailNguoiDung;
                nguoiDungList.add(nguoiDung);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return nguoiDungList;
    }


}
