package com.example.wangyinghui.a0720_myfirstapp.page.home;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.wangyinghui.a0720_myfirstapp.R;
import com.example.wangyinghui.a0720_myfirstapp.page.me.MeFragment;
import com.example.wangyinghui.a0720_myfirstapp.page.me.MeFragment.OnFragmentInteractionListener;
import com.example.wangyinghui.a0720_myfirstapp.page.home.NotificationFragment.OnListFragmentInteractionListener;
import com.example.wangyinghui.a0720_myfirstapp.page.home.dummy.DummyContent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyinghui on 2018/7/21.
 */

public class HomeActivity extends AppCompatActivity implements
    DashboardFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener,
    OnListFragmentInteractionListener,OnFragmentInteractionListener {

    private ViewPager mViewPager;
    private MenuItem mMenuItem;
    private BottomNavigationView navigation;
    List<Fragment> list_fragment = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_me:
                    mViewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mViewPager = findViewById(R.id.vp_home);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        list_fragment.add(HomeFragment.newInstance("1", "1"));
        list_fragment.add(DashboardFragment.newInstance("2", "2"));
        list_fragment.add(NotificationFragment.newInstance(1));
        list_fragment.add(MeFragment.newInstance("1", "2"));

        BottomViewAdapter adapter = new BottomViewAdapter(getSupportFragmentManager(), list_fragment);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(4);//设置缓存view 的个数

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (mMenuItem != null) {
                    mMenuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                mMenuItem = navigation.getMenu().getItem(position);
                mMenuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    @Override public void onFragmentInteraction(Uri uri) {

    }

    @Override public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public class BottomViewAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList;

        public BottomViewAdapter(FragmentManager manager, List<Fragment> mFragmentList) {
            super(manager);
            this.mFragmentList = mFragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

    }


}
