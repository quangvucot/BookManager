package com.example.bookmanager.TrangChu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookmanager.Adapter.NguoiDungAdapter;
import com.example.bookmanager.Database.MySQL;
import com.example.bookmanager.Database.UserDAO;
import com.example.bookmanager.Model.NguoiDung;
import com.example.bookmanager.NguoiDung.QuanLyNguoiDungActivity;
import com.example.bookmanager.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);


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