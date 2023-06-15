package com.ai.viewpagerindicatordemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.zhpan.indicator.IndicatorView;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;
import com.zhpan.indicator.utils.IndicatorUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager banner_view;
    IndicatorView indicator_view;

    ArrayList<String> arrayList_images;
    viewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner_view=(ViewPager)findViewById(R.id.banner_view);
        indicator_view=(IndicatorView)findViewById(R.id.indicator_view);

        arrayList_images=new ArrayList<>();
        arrayList_images.add("images/1592050095941.jpg");
        arrayList_images.add("images/1592050136395.jpg");
        arrayList_images.add("images/224060b825fdcfbc0c05bbe529db4066.jpg");
        arrayList_images.add("images/1bc84d2f00e24ee7c8e67ada564710a3.jpg");
        arrayList_images.add("images/606520c8423ed39e826efcd6fce1fb7c.jpg");

        viewPagerAdapter=new viewPagerAdapter(arrayList_images,getApplicationContext());
        banner_view.setAdapter(viewPagerAdapter);


        indicator_view .setSliderColor(Color.parseColor("#ffffff"), Color.parseColor("#FF4500"))
                .setSliderWidth(30)
                .setSliderHeight(30)
                .setSlideMode(IndicatorSlideMode.WORM)
                .setIndicatorStyle(IndicatorStyle.CIRCLE)
                .setupWithViewPager(banner_view);

    }
}