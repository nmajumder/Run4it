package hu.ait.android.run4it.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hu.ait.android.run4it.fragment.CompActiveFragment;
import hu.ait.android.run4it.fragment.CompDoneFragment;


public class CompPagerAdapter extends FragmentPagerAdapter {
    Context context;

    public CompPagerAdapter(Context context, FragmentManager fm) {
        super(fm);

        this.context = context;
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return new CompActiveFragment();
            case 1:
                return new CompDoneFragment();
            default:
                return new CompDoneFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Active";
            case 1:
                return "Completed";
            default:
                return "unknown";
        }
    }
}