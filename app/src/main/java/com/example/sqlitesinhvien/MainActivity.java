package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    String msg;
    public static final int SEND_DATA_FROM_AUTHOR_ACTIVITY=2;
    AppCompatButton btToList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        doDeleteDatabase();
        getDatabase();

        btToList = findViewById(R.id.buttonToList);
        btToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListSinhVien.class);
                startActivity(intent);
            }
        });
    }

    public boolean isTableExists(SQLiteDatabase database, String tableName) {
        Cursor cursor = database.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

    public void doDeleteDatabase(){
        if(deleteDatabase("sinhvien.db")==true)
        {
            msg = "Delete database 'computer.db' is successful";
        }
        else
        {
            msg = "Delete database 'computer.db' is failed";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void doCreateSinhVienTable(){
        String sql = "CREATE TABLE SinhVien (";
        sql += "maSV031 Integer primary key,";
        sql += "hoTen031 TEXT,";
        sql += "gioiTinh031 TEXT,";
        sql += "sDT031 TEXT,";
        sql += "email031 TEXT)";
        database.execSQL(sql);
    }

    public void doInsertRecord() {
        ContentValues values = new ContentValues();
        values.put("maSV031", 1);
        values.put("hoTen031", "Nguyễn Trí Đức 031");
        values.put("gioiTinh031", 1);
        values.put("sDT031","0906231002");
        values.put("email031","ricenguyen2310@gmail.com");
        if (database.insert("SinhVien", null, values) == -1) {
            msg = "Failed to insert";
        }

        values.put("maSV031", 2);
        values.put("hoTen031", "Nguyễn Trí Hải 031");
        values.put("gioiTinh031", 1);
        values.put("sDT031","0906231002");
        values.put("email031","nam@gmail.com");
        if (database.insert("SinhVien", null, values) == -1) {
            msg = "Failed to insert";
        }

        values.put("maSV031", 3);
        values.put("hoTen031", "Nguyễn Thị Lan  031");
        values.put("gioiTinh031", 0);
        values.put("sDT031","0906231002");
        values.put("email031","nu2310@gmail.com");
        if (database.insert("SinhVien", null, values) == -1) {
            msg = "Failed to insert";
        }

        values.put("maSV031", 4);
        values.put("hoTen031", "Nguyễn Thị Lan Hương  031");
        values.put("gioiTinh031", 0);
        values.put("sDT031","0906231002");
        values.put("email031","nu@gmail.com");
        if (database.insert("SinhVien", null, values) == -1) {
            msg = "Failed to insert";
        }
    }

    public SQLiteDatabase getDatabase()
    {
        database = openOrCreateDatabase("sinhvien.db", MODE_PRIVATE, null);
        try
        {
            if(database!=null)
            {
                if(isTableExists(database,"tbComputer"))
                    return database;
                doCreateSinhVienTable();
                doInsertRecord();
                Toast.makeText(this, "Tạo", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
        return database;
    }
}