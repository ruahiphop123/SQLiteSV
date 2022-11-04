package com.example.sqlitesinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddSinhVien extends AppCompatActivity {
    Button btinsert;
    EditText maSV, ten, sdt, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);

        maSV = findViewById(R.id.editTextMaSV);
        ten = findViewById(R.id.editTextTen);
        sdt = findViewById(R.id.editTextSDT);
        email = findViewById(R.id.editTextEmail);
        btinsert = findViewById(R.id.btThemSV);

        btinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("masv", maSV.getText().toString());
                bundle.putString("ten", ten.getText().toString());
                bundle.putString("sdt", sdt.getText().toString());
                bundle.putString("email", email.getText().toString());
                intent.putExtra("DATA_SV", bundle);
                setResult(MainActivity.SEND_DATA_FROM_AUTHOR_ACTIVITY, intent);
                AddSinhVien.this.finish();
            }
        });
    }
}