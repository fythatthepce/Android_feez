package com.example.feez.simple_option_menu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Hashtable;
//import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by feez on 6/20/2017 AD.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    public MyFragmentAdapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            default:
                return new Fragment1();
        }


    }

    @Override
    public CharSequence getPageTitle(int position){
        String[] tabs = {"Tab1","Tab2","Tab3"};
        return tabs[position];
    }


}
