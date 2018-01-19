package com.example.android.clujtour;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*finding the view pager in the activity_main.xml and setting the custom MyPagerAdapter
        on the viewPager */
        ViewPager viewPager= (ViewPager)findViewById(R.id.viewpager);
        MyPagerAdapter adapter= new MyPagerAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab());
        tabs.setupWithViewPager(viewPager);
    }
}
