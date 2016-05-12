package hu.ait.android.run4it.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import hu.ait.android.run4it.R;
import hu.ait.android.run4it.fragment.ProfGoalsFragment;
import hu.ait.android.run4it.fragment.ProfMainInfoFragment;
import hu.ait.android.run4it.fragment.ProfStatsFragment;

/**
 * Created by nathanmajumder on 5/12/16.
 */
public class ProfPagerAdapter extends FragmentPagerAdapter {
    Context context;

    public ProfPagerAdapter(Context context, FragmentManager fm) {
        super(fm);

        this.context = context;
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return new ProfMainInfoFragment();
            case 1:
                return new ProfStatsFragment();
            case 2:
                return new ProfGoalsFragment();
            default:
                return new ProfMainInfoFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Main Info";
            case 1:
                return "Statistics";
            case 2:
                return "Personal Goals";
            default:
                return "unknown";
        }
    }
}
