package hexa.congressApp.com.congress.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hexa.congressApp.com.congress.fragments.legislators.comm.CommHouseFragment;
import hexa.congressApp.com.congress.fragments.legislators.comm.CommJointFragment;
import hexa.congressApp.com.congress.fragments.legislators.comm.CommSenateFragment;


public class CommPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public CommPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CommHouseFragment tab1 = new CommHouseFragment();
                return tab1;
            case 1:
               CommSenateFragment tab2 = new CommSenateFragment();
                return tab2;
            case 2:
               CommJointFragment tab3 = new CommJointFragment();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

