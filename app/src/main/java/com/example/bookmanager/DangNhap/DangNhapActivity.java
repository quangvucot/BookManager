package com.example.bookmanager.DangNhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookmanager.ChucNang.CacChucNang;
import com.example.bookmanager.DangKy.DangKyActivity;
import com.example.bookmanager.Database.MySQL;
import com.example.bookmanager.Database.UserDAO;
import com.example.bookmanager.Model.NguoiDung;
import com.example.bookmanager.R;
import com.example.bookmanager.TrangChu.TrangChuActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class DangNhapActivity extends AppCompatActivity {
    TextInputEditText edtPassword_DN, edtUser_DN;
    TextInputLayout input_user, input_password;
    Button btnDangNhap;
    TextView tvDangKy;
    MySQL mySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        mySQL = new MySQL(this);
        edtUser_DN = (TextInputEditText) findViewById(R.id.edtUser_DN);
        edtPassword_DN = (TextInputEditText) findViewById(R.id.edtPassword_DN);
        input_user = findViewById(R.id.input_user);
        input_password = findViewById(R.id.input_password);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate();
                dangNhap();
            }
        });
        tvDangKy = findViewById(R.id.dangKy);
        tvDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDangKy.setTextColor(Color.GREEN);
                IntentDangKy();

            }
        });
    }

    private void Validate() {

        CacChucNang cacChucNang = new CacChucNang();
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.username = edtUser_DN.getText().toString().trim();
        nguoiDung.password = edtPassword_DN.getText().toString().trim();
        cacChucNang.checkEmty(nguoiDung.username, input_user);
        cacChucNang.checkEmty(nguoiDung.password, input_password);

    }

    private void IntentDangKy() {

        Intent intent = new Intent(this, DangKyActivity.class);
        startActivity(intent);
    }

    private void dangNhap() {

        NguoiDung nguoiDung = new NguoiDung();
        String a = edtUser_DN.getText().toString().trim();
        String b = edtPassword_DN.getText().toString().trim();
        UserDAO userDAO = new UserDAO(mySQL);
        List<NguoiDung> nguoiDungs = userDAO.checkDangNhap(a, b);
        if (nguoiDungs.size() == 0) {
            Toast.makeText(this, "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TrangChuActivity.class);
            startActivity(intent);
        }
    }
}