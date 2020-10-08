package com.example.bookmanager.BoLoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.bookmanager.MainActivity;
import com.example.bookmanager.R;

public class BoLocActivity extends AppCompatActivity {
    Button btnMucGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bo_loc);
        btnMucGia = findViewById(R.id.btnMucGia);
        btnMucGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnMucGia);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.giaDuoi100k:
                        btnMucGia.setText("Dưới 100.000 VND");
                        break;
                    case R.id.giaDuoi200kVND:
                        btnMucGia.setText("Dưới 200.000 VND");
                        break;
                    case R.id.giaDuoi500k:
                        btnMucGia.setText("Dưới 500.000 VND");
                        break;
                    case R.id.giaDuoi1000k:
                        btnMucGia.setText("Dưới 1.000.000 VND");
                        break;
                    case R.id.giaDuoi2000k:
                        btnMucGia.setText("Dưới 2.000.000 VND");
                        break;
                    case R.id.giaDuoi5000k:
                        btnMucGia.setText("Dưới 5.000.000 VND");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();

    }
}