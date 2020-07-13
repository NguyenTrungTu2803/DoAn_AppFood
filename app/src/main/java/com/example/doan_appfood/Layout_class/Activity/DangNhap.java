package com.example.doan_appfood.Layout_class.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.doan_appfood.Interface.ModelResponseToPresenter;
import com.example.doan_appfood.Model.DangNhap_M;
import com.example.doan_appfood.R;
import com.example.doan_appfood.Adapter.ViewPage_DN_Adapter;
import com.example.doan_appfood.Layout_class.fagment.fagment_login;
import com.example.doan_appfood.Layout_class.fagment.fragment_register;
import com.google.android.material.tabs.TabLayout;

public class DangNhap extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        findId();
        TabAdd(viewPager);
    }

    private void TabAdd(ViewPager viewPager) {
        ViewPage_DN_Adapter viewPage_dn_adapter = new ViewPage_DN_Adapter(getSupportFragmentManager());
        viewPage_dn_adapter.add(new fagment_login(), "Đăng nhập");
        viewPage_dn_adapter.add(new fragment_register(), "Đăng ký");
        viewPager.setAdapter(viewPage_dn_adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void findId(){
        viewPager = findViewById(R.id.vpdangnhap);
        tabLayout = findViewById(R.id.tabdangnhap);
    }
}
