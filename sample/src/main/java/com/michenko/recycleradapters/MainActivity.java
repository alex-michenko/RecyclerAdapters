package com.michenko.recycleradapters;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.michenko.recycleradapters.adapters.SamplePagerAdapter;
import com.michenko.recycleradapters.fragments.SimpleAdapterFragment;
import com.michenko.recycleradapters.fragments.TypedAdapterFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findUI();
        setAdapter();
    }

    private void findUI() {
        vpSamples = (ViewPager) findViewById(R.id.vpSamples);
    }

    private void setAdapter() {
        SamplePagerAdapter pagerAdapter = new SamplePagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(new SimpleAdapterFragment());
        pagerAdapter.addFragment(new TypedAdapterFragment());

        vpSamples.setAdapter(pagerAdapter);
    }
}
