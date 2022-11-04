package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sqlitesinhvien.adapter.SVadapter;
import com.example.sqlitesinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class ListSinhVien extends AppCompatActivity {
    SQLiteDatabase database;
    List<SinhVien> listSV;
    SVadapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sinh_vien);
        getSupportActionBar().hide();
        listSV = new ArrayList<>();
        updateUI();
    }

    public void updateUI() {
        database = openOrCreateDatabase("sinhvien.db", MODE_PRIVATE, null);
        if (database != null) {
            Cursor cursor = database.query("SinhVien", null, null, null, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                SinhVien data = new SinhVien();
                data.setMaSV(cursor.getInt(0));
                data.setHoTen(cursor.getString(1));
                data.setGioiTinh(cursor.getInt(2));
                data.setSdt(cursor.getString(3));
                data.setEmail(cursor.getString(4));
                listSV.add(data);
                cursor.moveToNext();
            }
            cursor.close();
            adapter = new SVadapter(ListSinhVien.this, R.layout.line_item_sv, listSV);
            listView = (ListView) findViewById(R.id.listViewSinhVien);
            listView.setAdapter(adapter);
        }
    }
}