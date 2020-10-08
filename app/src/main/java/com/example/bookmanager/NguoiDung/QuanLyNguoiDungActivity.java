package com.example.bookmanager.NguoiDung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bookmanager.Adapter.NguoiDungAdapter;
import com.example.bookmanager.Database.MySQL;
import com.example.bookmanager.Database.UserDAO;
import com.example.bookmanager.Model.NguoiDung;
import com.example.bookmanager.R;

import java.util.List;

public class QuanLyNguoiDungActivity extends AppCompatActivity {
    ListView listView;
    private MySQL mySQL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_nguoi_dung);
        listView = findViewById(R.id.lv);
        mySQL = new MySQL(this);
        UserDAO userDAO = new UserDAO(mySQL);
        List<NguoiDung> nguoiDungList = userDAO.getAllUser();
        NguoiDungAdapter adapter = new NguoiDungAdapter(nguoiDungList);
        listView.setAdapter(adapter);
    }
}