package com.josepcode.petagramFragments.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by JR on 06/06/2016.
 */
/*Creamos un adapter para trabajar con el View Pager
* Ayuda a manejar toda la parte de incrustar un fragment en cada tab de mi aplicación*/
public class PageAdapter extends FragmentPagerAdapter {
    // el view pager serà un arreglo de fragments, tendremos un fragment en cada tabs.
    private ArrayList<Fragment> mFragments;

    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
