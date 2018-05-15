package com.gizwits.opensource.appkit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT =3;
    private String tabTitles[]=new String[]{"TAB1","TAB2","TAB3"};
    private Context context;
    public SampleFragmentPagerAdapter(FragmentManager fm,Context context){
        super(fm);
        this.context=context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position+1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
