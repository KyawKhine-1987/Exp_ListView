package com.freelance.android.explistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();
    ExpandableListView mExpandableListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "TEST: onCreate() is called...");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTask();
    }

    private void initTask() {
        Log.i(LOG_TAG, "TEST: initTask() is called...");

        mExpandableListView = this.findViewById(R.id.mExpandableListView);
        List<String> mMenuList = new ArrayList<>();
        List<String> mML1 = new ArrayList<>();
        List<String> mML2 = new ArrayList<>();
        List<String> mML3 = new ArrayList<>();

        HashMap<String, List<String>> mSubMenuList = new HashMap<String, List<String>>();

        String mMenuHeadingList[] = getResources().getStringArray(R.array.header_titles);
        String mMHL1[] = getResources().getStringArray(R.array.h1_items);
        String mMHL2[] = getResources().getStringArray(R.array.h2_items);
        String mMHL3[] = getResources().getStringArray(R.array.h3_items);

        for (String title : mMenuHeadingList) {
            mMenuList.add(title);
        }

        for (String title : mMHL1) {
            mML1.add(title);
        }

        for (String title : mMHL2) {
            mML2.add(title);
        }

        for (String title : mMHL3) {
            mML3.add(title);
        }

        mSubMenuList.put(mMenuList.get(0), mML1);
        mSubMenuList.put(mMenuList.get(1), mML2);
        mSubMenuList.put(mMenuList.get(2), mML3);

        MovieAdapter mMovieAdapter = new MovieAdapter(this, mMenuList, mSubMenuList);
        mExpandableListView.setAdapter(mMovieAdapter);
    }
}
