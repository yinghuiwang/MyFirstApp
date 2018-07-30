package com.example.wangyinghui.a0720_myfirstapp.page.guide;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.example.wangyinghui.a0720_myfirstapp.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyinghui on 2018/7/23.
 */

public class GuideActivity extends AppCompatActivity implements GuideContract.IGuideView, View.OnClickListener {

    private ViewPager mViewPager;
    private LinearLayout mLlDots;
    private ImageView mIvLightDot;
    private Button mBtnNext;
    private int mDistance;
    private ImageView mOne_dot;
    private ImageView mTwo_dot;
    private ImageView mThree_dot;
    private List<View> mViewList;
    private GuideContract.IGuidePresenter iGuidePresenter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_guide);
        mLlDots = findViewById(R.id.ll_guide_dots);
        mIvLightDot = findViewById(R.id.iv_guide_light_dots);
        mBtnNext = findViewById(R.id.btn_guide_next);
        mViewPager = this.findViewById(R.id.vp_guide);

        initDate();
        mViewPager.setAdapter(new GuideAdapter(mViewList));

        addDots();
        moveDots();
        new GuidePresenter(this);
        mBtnNext.setOnClickListener(this);
    }

    private void moveDots() {
        mIvLightDot.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override public void onGlobalLayout() {
                // 获取两个圆点的距离
                mDistance = mLlDots.getChildAt(1).getLeft() - mLlDots.getChildAt(0).getLeft();
                mIvLightDot.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // 页面滚动时小白点移动的距离，并通过setLayoutParams(params)不断跟新其位置
                float leftMargin = mDistance *(position + positionOffset);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mIvLightDot.getLayoutParams();
                params.leftMargin = (int) leftMargin;
                mIvLightDot.setLayoutParams(params);
                if (position == 2) {
                    mBtnNext.setVisibility(View.VISIBLE);
                }
                if(position != 2 && mBtnNext.getVisibility() == View.VISIBLE) {
                    mBtnNext.setVisibility(View.GONE);
                }

            }

            @Override public void onPageSelected(int position) {
                // 页面跳转时，设置小圆点的margin
                float leftMargin = mDistance * position;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mIvLightDot.getLayoutParams();
                params.leftMargin = (int)leftMargin;
                mIvLightDot.setLayoutParams(params);
                if (position == 2) {
                    mBtnNext.setVisibility(View.VISIBLE);
                }

                if (position != 2 && mBtnNext.getVisibility() == View.VISIBLE) {
                    mBtnNext.setVisibility(View.GONE);
                }
            }

            @Override public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void addDots() {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,0,40,0);

        mOne_dot = createDot(layoutParams, 0);
        mLlDots.addView(mOne_dot, layoutParams);

        mTwo_dot = createDot(layoutParams, 1);
        mLlDots.addView(mTwo_dot, layoutParams);

        mThree_dot = createDot(layoutParams, 2);
        mLlDots.addView(mThree_dot, layoutParams);

    }

    private ImageView createDot(LinearLayout.LayoutParams layoutParams, int item) {
        ImageView dot = new ImageView(this);
        dot.setImageResource(R.drawable.guide_gray_dot);
        dot.setOnClickListener(new View.OnClickListener() {
            private int currentItem;
            @Override public void onClick(View view) {
                mViewPager.setCurrentItem(currentItem);
            }

            public View.OnClickListener setCurrentItem(int currentItem) {
                this.currentItem = currentItem;
                return this;
            }
        }.setCurrentItem(item));

        return dot;
    }

    private void initDate () {
        mViewList = new ArrayList<View>();
        LayoutInflater lif = getLayoutInflater().from(this);
        mViewList.add(lif.inflate(R.layout.view_guide_1, null));
        mViewList.add(lif.inflate(R.layout.view_guide_2, null));
        mViewList.add(lif.inflate(R.layout.view_guide_3, null));
    }

    @Override public void setPresenter(GuideContract.IGuidePresenter presenter) {
        this.iGuidePresenter = presenter;
    }

    @Override public Activity getActivity() {
        return this;
    }

    @Override public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_guide_next:
                iGuidePresenter.jumpPage();
                break;
        }
    }

    private class GuideAdapter extends PagerAdapter {

        private List<View> mViewList;

        public GuideAdapter(List<View> viewList) {
            mViewList = viewList;
        }

        @Override public int getCount() {
            return mViewList.size();
        }

        @Override public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override public void destroyItem(@NonNull ViewGroup container, int position,
            @NonNull Object object) {
            container.removeView(mViewList.get(position));
        }
    }
}
