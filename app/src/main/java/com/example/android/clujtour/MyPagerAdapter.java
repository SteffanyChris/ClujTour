package com.example.android.clujtour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by root on 1/15/18.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public MyPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext=context;
    }

    /**
     *
     * @return the number of tabs
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     *
     * @param position the position of the tab
     * @return returns fragment corresponding to the position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FoodFragment();
            case 1:
                return new AccommodationFragment();
            case 2:
                return new AttractionsFragment();
            case 3:
                return new EntertainmentFragment();
            default:
                return null;
        }
    }

    /**
     *
     * @param position the position of the tab
     * @return corresponding tab name for the fragment found at that position
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.food_tab);
            case 1:
                return mContext.getString(R.string.aco_tab);
            case 2:
                return mContext.getString(R.string.atr_tab);
            case 3:
                return mContext.getString(R.string.en_tab);
            default:
                return null;
        }
    }
}
