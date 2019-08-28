package com.jimison.f2e2019.chatroom;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    //定義圖片陣列
    private int images[] = {R.drawable.ic_landing, R.drawable.ic_rule1, R.drawable.ic_rule2, R.drawable.ic_rule3};
    //定義一個View的陣列
    private List<View> views = new ArrayList<>();
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.viewPager);

        for (int i : images) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            views.add(imageView);
        }

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View v = views.get(position);
                container.addView(v);
                return v;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View v = views.get(position);
                //前一張圖片劃過後刪除該View
                container.removeView(v);
            }
        });
    }
}
