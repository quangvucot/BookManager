package com.example.bookmanager.HoaDon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bookmanager.Database.BillDao;
import com.example.bookmanager.Database.MySQL;
import com.example.bookmanager.Database.UserDAO;
import com.example.bookmanager.Model.HoaDon;
import com.example.bookmanager.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class ThemHoaDonActivity extends AppCompatActivity {
    TextInputLayout tipMaHoaDon, tipNguoiTaoHD, tipNguoiMuaHD, tipTongTienHD, tipSoLuongHD, tipGiaHD, tipNgayTao;
    TextInputEditText edtMaHoaDon, edtNguoiTaoHD, edtNguoiMuaHD, edtTongTien, edtSoLuongHD, edtGiaHD, edtNgayTao;
    private MySQL mySQL;
    Button btnThemHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don);
        mySQL = new MySQL(this);
        final BillDao billDao = new BillDao(mySQL);
        AnhXa();
        btnThemHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themHoaDon();
            }
        });
    }

    public void AnhXa() {
        tipMaHoaDon = findViewById(R.id.tipMaHoaDon);
        tipNguoiTaoHD = findViewById(R.id.tipNguoiTaoHD);
        tipNguoiMuaHD = findViewById(R.id.tipNguoiMuaHD);
        tipTongTienHD = findViewById(R.id.tipTongTienHD);
        tipSoLuongHD = findViewById(R.id.tipSoLuongHD);
        tipGiaHD = findViewById(R.id.tipGiaTienHD);
        tipNgayTao = findViewById(R.id.tipNgayTaoHD);
        btnThemHoaDon = findViewById(R.id.btnThemHD);

        edtMaHoaDon = findViewById(R.id.edtMaHoaDon);
        edtNguoiTaoHD = findViewById(R.id.edtNguoiTaoHD);
        edtNguoiMuaHD = findViewById(R.id.edtNguoiMuaHD);
        edtTongTien = findViewById(R.id.edtTongTienHD);
        edtSoLuongHD = findViewById(R.id.edtSoLuong);
        edtGiaHD = findViewById(R.id.edtSoLuongHD);
        edtNgayTao = findViewById(R.id.edtNgayTaoHD);

    }

    public void themHoaDon() {
        HoaDon hoaDon = new HoaDon();
        hoaDon.maHoaDon = edtMaHoaDon.getText().toString().trim();
        hoaDon.nguoiMua = edtNguoiMuaHD.getText().toString().trim();
        hoaDon.nguoiTao = edtNguoiTaoHD.getText().toString().trim();
//        hoaDon.tongTien = Float.parseFloat(edtTongTien.getText().toString().trim());
//        hoaDon.gia = Float.parseFloat(edtGiaHD.getText().toString().trim());
//        hoaDon.soLuong = Integer.parseInt(edtSoLuongHD.getText().toString().trim());
        hoaDon.thoiGian = edtNgayTao.getText().toString().trim();
        BillDao billDao = new BillDao(mySQL);
        boolean kq = billDao.themHoaDon(hoaDon);
        Toast.makeText(this, hoaDon.maHoaDon, Toast.LENGTH_SHORT).show();
        if (kq) {
            Toast.makeText(this, "Chúc mừng bạn đã thêm hóa đơn thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Thêm hóa đơn thất bại", Toast.LENGTH_SHORT).show();
        }
    }
}