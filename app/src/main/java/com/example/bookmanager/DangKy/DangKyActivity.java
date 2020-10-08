package com.example.bookmanager.DangKy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.bookmanager.Database.MySQL;
import com.example.bookmanager.Database.UserDAO;
import com.example.bookmanager.Model.NguoiDung;
import com.example.bookmanager.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DangKyActivity extends AppCompatActivity {
    TextInputEditText edtHoTenDK, edtEmailDK, edtUsernameDK, edtPasswordDK, edtRepeatPassDK, edtSoDienThoaiDK;
    RadioButton rdNam, rdNu;
    TextInputLayout edtHoTen, edtUsername, edtEmail, edtPassword, edtrepeatPassword, edtSoDienThoai;
    Button btnDangKy;
    private MySQL mySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        mySQL = new MySQL(this);
        final UserDAO userDAO = new UserDAO(mySQL);
        AnhXa();
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangKy();
            }
        });
    }


    public void AnhXa() {
        edtHoTenDK = findViewById(R.id.edtHoTenDK);
        edtEmailDK = findViewById(R.id.edtEmailDK);
        edtUsernameDK = findViewById(R.id.edtUsernameDK);
        edtPasswordDK = findViewById(R.id.edtPasswordDK);
        edtRepeatPassDK = findViewById(R.id.edtRepeatPassDK);
        edtSoDienThoaiDK = findViewById(R.id.edtSoDienThoaiDK);

        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.edNu);
        btnDangKy = findViewById(R.id.btnDangKy);

        edtHoTen = findViewById(R.id.edtHoTen);
        edtEmail = findViewById(R.id.edtEmail);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtrepeatPassword = findViewById(R.id.edtrepeatPassword);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
    }

    public boolean checkEmty(String id, TextInputLayout textInputLayout) {
        if (id.isEmpty()) {
            textInputLayout.setError("Không được để trống");
            return false;
        } else {
            textInputLayout.setError(null);
            return true;
        }
    }

    public void CheckPassword(String password, String repeatPassword, TextInputLayout textInputLayout) {
        if (password.length() < 8) {
            edtPassword.setError("Mật khẩu phải lớn hơn 8 kí tự");
        } else {
            edtPassword.setError(null);
        }
        if (!password.equals(repeatPassword)) {
            textInputLayout.setError("Không khớp");
        } else {
            textInputLayout.setError(null);

        }
    }

    public boolean checkEmail(String email, TextInputLayout textInputLayout) {
        String reg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(reg);
        Matcher check = pattern.matcher(email);
        if (!check.matches()) {
            textInputLayout.setError("Không đúng định dạng Email");
            return false;
        } else {
            return true;
        }

    }

    public void dangKy() {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.tenNguoiDung = edtHoTenDK.getText().toString().trim();
        nguoiDung.emailNguoiDung = edtEmailDK.getText().toString().trim();
        nguoiDung.username = edtUsernameDK.getText().toString().trim();
        nguoiDung.password = edtPasswordDK.getText().toString().trim();
        nguoiDung.repeatPassword = edtRepeatPassDK.getText().toString().trim();
        nguoiDung.sdtNguoiDung = edtSoDienThoaiDK.getText().toString().trim();
        checkEmty(nguoiDung.tenNguoiDung, edtHoTen);
        checkEmty(nguoiDung.sdtNguoiDung, edtSoDienThoai);
        checkEmty(nguoiDung.emailNguoiDung, edtEmail);
        checkEmty(nguoiDung.username, edtUsername);
        checkEmty(nguoiDung.password, edtPassword);
        checkEmty(nguoiDung.repeatPassword, edtrepeatPassword);
        CheckPassword(nguoiDung.password, nguoiDung.repeatPassword, edtrepeatPassword);
        if (!nguoiDung.tenNguoiDung.isEmpty() && !nguoiDung.emailNguoiDung.isEmpty() && !nguoiDung.username.isEmpty() && !nguoiDung.password.isEmpty() && !nguoiDung.repeatPassword.isEmpty() && !nguoiDung.sdtNguoiDung.isEmpty()) {
            if (checkEmail(nguoiDung.emailNguoiDung, edtEmail) && nguoiDung.password.length() >= 8 && nguoiDung.password.equals(nguoiDung.repeatPassword)) {
                UserDAO userDAO = new UserDAO(mySQL);
                boolean checkKetQua = userDAO.themNguoiDung(nguoiDung);
                if (checkKetQua) {
                    Toast.makeText(this, "Chúc mừng bạn đăng ký thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
            }

        }


    }

    //    public void check() {
//        String checkEmail = edtEmailDK.getText().toString().trim();
//        String checkUser = edtUsernameDK.getText().toString().trim();
//        List<NguoiDung> arrNguoiDungs = new ArrayList<>();
//        UserDAO userDAO = new UserDAO(mySQL);
//        List<NguoiDung> nguoiDungList = userDAO.CheckTonTai(checkUser, checkEmail);
//        if (nguoiDungList.size() == 0){
//
//        }
//    }
    public void deleteall() {

    }
}