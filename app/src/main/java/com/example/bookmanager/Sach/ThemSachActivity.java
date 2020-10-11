package com.example.bookmanager.Sach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bookmanager.Database.BookDAO;
import com.example.bookmanager.Database.MySQL;
import com.example.bookmanager.Model.Sach;
import com.example.bookmanager.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ThemSachActivity extends AppCompatActivity {
    ListView listView;
    MySQL mySQL;
    TextInputLayout tipTenSach, tipGiaSach, tipnhaXuatBan, tipSoLUong, tipTacGia, tipMaSach;
    TextInputEditText edtTenSach, edtGiaSach, edtNhaXuatBan, edtSoLuong, edtTacGia, edtMaSach;
    Button btnThemSach;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sach);
        AnhXa();
        btnThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangKy();
            }
        });

    }

    public void AnhXa() {
        tipTenSach = findViewById(R.id.tipTenSach);
        tipGiaSach = findViewById(R.id.tipGiaSach);
        tipnhaXuatBan = findViewById(R.id.tipnhaXuatBan);
        tipSoLUong = findViewById(R.id.tipSoLUong);
        tipTacGia = findViewById(R.id.tipTacGia);
        tipMaSach = findViewById(R.id.tipMaSach);

        edtTenSach = findViewById(R.id.edtTenSach);
        edtGiaSach = findViewById(R.id.edtGiaSach);
        edtNhaXuatBan = findViewById(R.id.edtNhaXuatBan);
        edtSoLuong = findViewById(R.id.edtSoLuong);
        edtTacGia = findViewById(R.id.edtTacGia);
        edtMaSach = findViewById(R.id.edtMaSach);
        btnThemSach = findViewById(R.id.btnThemSach);


    }

    public void dangKy() {
        Sach sach = new Sach();
        sach.maSach = edtMaSach.getText().toString().trim();
        sach.tenSach = edtTenSach.getText().toString().trim();
//        sach.giaSach = Float.valueOf(edtGiaSach.getText().toString().trim());
        sach.nhaXuatBan = edtNhaXuatBan.getText().toString().trim();
//        sach.soLuong = Integer.parseInt(edtSoLuong.getText().toString().trim());
        sach.tacgia = edtTacGia.getText().toString().trim();
        BookDAO bookDAO = new BookDAO(mySQL);
        boolean checkKetQua = bookDAO.themSach(sach);
        if (checkKetQua) {
            Toast.makeText(this, "Chúc mừng bạn đã thêm sách thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Thêm Sách Thất Bại", Toast.LENGTH_SHORT).show();
        }

    }
}