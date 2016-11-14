package es.source.wuzejun.shareu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import es.source.wuzejun.shareu.activity.MainActivity;
import view.PhotoText;

/**
 * Created by wuzejun on 2016/11/2.
 */
public class Main extends AppCompatActivity implements View.OnClickListener {
    PhotoText dataTab;
    PhotoText settingTab;

    FragmentManager fm;
    ViewPager viewPager;
    ArrayList<Fragment> fragmentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("ShareU");
        setSupportActionBar(toolbar);

        fm = getFragmentManager();
        fragmentsList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentsList.add(new Fragment1());
        fragmentsList.add(new Fragment2());
        dataTab= (PhotoText) findViewById(R.id.data_tab);
        settingTab= (PhotoText) findViewById(R.id.setting_tab);

        viewPager = (ViewPager) findViewById(R.id.content);
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(fm) {
            @Override
            public android.app.Fragment getItem(int position) {
                return fragmentsList.get(position);

            }

            @Override
            public int getCount() {
                return fragmentsList.size();
            }

        };
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                selectTab(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        dataTab.setOnClickListener(this);
        settingTab.setOnClickListener(this);
        selectTab(0);
    }

    /*
    传入0表示第一个tab被选择
    1表示第二个变选中,设置selected
     */
    public void selectTab(int tab){
        switch (tab){
            case 0:
                dataTab.setSelected(true);
                settingTab.setSelected(false);
                break;
            case 1:
                dataTab.setSelected(false);
                settingTab.setSelected(true);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.data_tab:
                viewPager.setCurrentItem(0);
                break;
            case R.id.setting_tab:
                viewPager.setCurrentItem(1);
        }
    }
}
