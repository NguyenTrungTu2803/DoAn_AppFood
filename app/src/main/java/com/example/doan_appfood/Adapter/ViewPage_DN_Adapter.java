package com.example.doan_appfood.Adapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPage_DN_Adapter extends FragmentPagerAdapter{

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titleFrm = new ArrayList<>();

    public ViewPage_DN_Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPage_DN_Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleFrm.get(position);
    }
    public void add(Fragment frament, String t){
        fragmentList.add(frament);
        titleFrm.add(t);
    }
}
