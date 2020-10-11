package com.example.bookmanager.HoaDon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bookmanager.Adapter.HoaDonAdapter;
import com.example.bookmanager.Adapter.NguoiDungAdapter;
import com.example.bookmanager.Database.BillDao;
import com.example.bookmanager.Database.MySQL;
import com.example.bookmanager.Database.UserDAO;
import com.example.bookmanager.Model.HoaDon;
import com.example.bookmanager.Model.NguoiDung;
import com.example.bookmanager.R;

import java.util.List;

public class QuanLyHoaDonActivity extends AppCompatActivity {
    ListView listView;
    private MySQL mySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_hoa_don);
        listView = findViewById(R.id.lvHoaDon);
        mySQL = new MySQL(this);
        BillDao userDAO = new BillDao(mySQL);
        List<HoaDon> hoaDonList = userDAO.getAllHoaDon();
        HoaDonAdapter adapter = new HoaDonAdapter(hoaDonList);
        listView.setAdapter(adapter);
    }
}