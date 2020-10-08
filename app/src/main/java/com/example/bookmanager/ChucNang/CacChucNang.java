package com.example.bookmanager.ChucNang;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CacChucNang {

    public void checkEmty(String id, TextInputLayout textInputLayout) {
        if (id.isEmpty()) {
            textInputLayout.setError("Không được để trống");
            return;
        } else {
            textInputLayout.setError(null);
        }
    }

    public void checkEmail(String email, TextInputLayout textInputLayout) {
        String reg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(reg);
        Matcher check = pattern.matcher(email);
        if (!check.matches()) {
            textInputLayout.setError("Không đúng định dạng Email");
            return;
        }
    }
}
