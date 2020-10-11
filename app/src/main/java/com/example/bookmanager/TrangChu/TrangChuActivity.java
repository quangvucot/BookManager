package com.example.bookmanager.TrangChu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.bookmanager.Adapter.SachAdapter;
import com.example.bookmanager.Database.BookDAO;
import com.example.bookmanager.Database.MySQL;
import com.example.bookmanager.Model.Sach;
import com.example.bookmanager.NguoiDung.QuanLyNguoiDungActivity;
import com.example.bookmanager.R;

import java.util.List;

public class TrangChuActivity extends AppCompatActivity {
    ListView lv;
    Intent intent;
    MySQL mySQL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        lv = findViewById(R.id.lv);
        mySQL = new MySQL(this);
        BookDAO bookDAO = new BookDAO(mySQL);
        List<Sach> bookDAOList = bookDAO.getAllBook();
        SachAdapter adapter = new SachAdapter(bookDAOList);
        lv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trangchu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.qlTaiKhoan:
                intent = new Intent(this, QuanLyNguoiDungActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}