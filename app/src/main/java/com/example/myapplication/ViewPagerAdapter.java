package com.example.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super (fm);
    }

    private final List<Fragment> FragmentsList = new ArrayList<>();
    private final List<String> titlesList = new ArrayList<>();


    public void addFragment(Fragment fragment, String titulo){
        FragmentsList.add(fragment);
        titlesList.add(titulo);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlesList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentsList.size();
    }

}
