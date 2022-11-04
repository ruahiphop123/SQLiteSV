package com.example.sqlitesinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.constraintlayout.utils.widget.ImageFilterView;

import com.example.sqlitesinhvien.R;
import com.example.sqlitesinhvien.model.SinhVien;

import java.util.List;

public class SVadapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> list;

    public SVadapter(Context context, int layout, List<SinhVien> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView maSV, hoTen, SDT, email;
        ImageFilterView gTinh;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.hoTen = view.findViewById(R.id.txtHoTen);
            holder.maSV = view.findViewById(R.id.txtMaSV);
            holder.email = view.findViewById(R.id.txtEmail);
            holder.SDT = view.findViewById(R.id.txtSDT);
            holder.gTinh = view.findViewById(R.id.hinhAnh);
            view.setTag(holder);
        }
        else
            holder = (ViewHolder) view.getTag();

        SinhVien sv = list.get(i);

        holder.hoTen.setText("Họ tên: " + sv.getHoTen());
        holder.maSV.setText("Mã sv: "+sv.getHoTen());
        holder.SDT.setText("SĐT: "+sv.getSdt());
        holder.email.setText("Email:"+sv.getEmail());

        if(sv.getGioiTinh() == 0)//Nữ là 1
            holder.gTinh.setImageResource(R.drawable.girl);
        else
            holder.gTinh.setImageResource(R.drawable.boy);
        return view;
    }
}
