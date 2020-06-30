package com.example.mynavigation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SelectionPagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;

    public SelectionPagerAdapter(Context mContext, FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mContext = mContext;
    }
    @StringRes
    private final int[] TAB_TITLE=new int[]{
            R.string.title_home,
            R.string.titile_profil

    };


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch(position){
            case 0:
                fragment=new HomeFragment();
                break;
            case 1:
                fragment=new profileFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLE[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
