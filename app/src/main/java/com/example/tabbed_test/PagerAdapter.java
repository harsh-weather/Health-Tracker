package com.example.tabbed_test;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {         // position == tab number
        switch(position){
            case 0:
                return new GeneralFragment();
            case 1:
                return new FirstFragment();
            case 2:
                return new SecondFragment();
            case 3:
                return new ThirdFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
