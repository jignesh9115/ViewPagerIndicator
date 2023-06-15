package com.ai.viewpagerindicatordemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class viewPagerAdapter extends PagerAdapter {

    ArrayList<String> arrayList;
    Context context;

    public viewPagerAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view=LayoutInflater.from(context).inflate(R.layout.entity_view_pager,container,false);


        ImageView img_property=view.findViewById(R.id.img_property);


        RequestOptions options=new RequestOptions().placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_background);
        Glide.with(context).load("BASE_URL"+arrayList.get(position))
                .apply(options)
                .into(img_property);

        container.addView(view,0);
        return view;
    }


    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
