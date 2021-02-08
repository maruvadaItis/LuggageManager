package com.example.luggagemanager.IntroScreen;

import android.content.Context;

import android.support.annotation.NonNull;

import android.support.v4.view.PagerAdapter;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;


import com.example.luggagemanager.R;

import java.util.List;

import static com.example.luggagemanager.R.*;
import static com.example.luggagemanager.R.id.*;


public class IntroViewPagerAdapter extends PagerAdapter {



    Context mContext ;

    List<ScreenItem> mListScreen;



    public IntroViewPagerAdapter(Context mContext, List<ScreenItem> mListScreen) {

        this.mContext = mContext;

        this.mListScreen = mListScreen;

    }





    @NonNull

    @Override

    public Object instantiateItem(@NonNull ViewGroup container, int position) {



        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutScreen = inflater.inflate(layout.layout_screen,null);



        ImageView imgSlide = layoutScreen.findViewById(intro_img);

        TextView title = layoutScreen.findViewById(intro_title);

        TextView description = layoutScreen.findViewById(intro_description);



        title.setText(mListScreen.get(position).getTitle());

        description.setText(mListScreen.get(position).getDescription());

        imgSlide.setImageResource(mListScreen.get(position).getScreenImg());



        container.addView(layoutScreen);



        return layoutScreen;











    }



    @Override

    public int getCount() {

        return mListScreen.size();

    }



    @Override

    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view == o;

    }



    @Override

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {



        container.removeView((View)object);



    }

}

