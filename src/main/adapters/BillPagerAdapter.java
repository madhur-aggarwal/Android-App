package hexa.congressApp.com.congress.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hexa.congressApp.com.congress.fragments.legislators.bills.ActiveBillsFragment;
import hexa.congressApp.com.congress.fragments.legislators.bills.NewBillsFragment;

public class BillPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public BillPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ActiveBillsFragment tab1 = new ActiveBillsFragment();
                return tab1;
            case 1:
                NewBillsFragment tab2 = new NewBillsFragment();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
