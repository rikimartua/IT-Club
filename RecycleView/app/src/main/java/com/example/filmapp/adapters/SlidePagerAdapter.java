package com.example.filmapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filmapp.R;
import com.example.filmapp.models.Slide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlidePagerAdapter extends PagerAdapter {

    private Context nContext;
    private List<Slide> nList;

    public SlidePagerAdapter(Context nContext, List<Slide> nList) {
        this.nContext = nContext;
        this.nList = nList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater Inflater=(LayoutInflater) nContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout=Inflater.inflate(R.layout.slide_item,null);

        ImageView slideImage=slideLayout.findViewById(R.id.slide_Img);
        TextView slideText=slideLayout.findViewById(R.id.slide_text);
        slideImage.setImageResource(nList.get(position).getImage());
        slideText.setText(nList.get(position).getTitle());

        container.addView(slideLayout);
        return slideLayout;
    }

    @Override
    public int getCount() {
        return nList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
