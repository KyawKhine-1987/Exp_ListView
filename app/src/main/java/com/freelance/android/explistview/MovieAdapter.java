package com.freelance.android.explistview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class MovieAdapter extends BaseExpandableListAdapter {

    private static final String LOG_TAG = MovieAdapter.class.getName();

    private List<String> mMenuList;
    private HashMap<String, List<String>> mSubMenuList;
    private Context mContext;

    public MovieAdapter(Context context, List<String> menuList, HashMap<String, List<String>> subMenuList) {
        Log.i(LOG_TAG, "TEST: MovieAdapter() constructor is called...");

        this.mMenuList = menuList;
        this.mSubMenuList = subMenuList;
        this.mContext = context;
    }


    @Override
    public int getGroupCount() {
        Log.i(LOG_TAG, "TEST: getGroupCount() is called...");

        return mMenuList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        Log.i(LOG_TAG, "TEST: getChildrenCount() is called...");

        return mSubMenuList.get(mMenuList.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        Log.i(LOG_TAG, "TEST: getGroup() is called...");

        return mMenuList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        Log.i(LOG_TAG, "TEST: getChild() is called...");

        return mSubMenuList.get(mMenuList.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        Log.i(LOG_TAG, "TEST: getGroupId() is called...");

        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        Log.i(LOG_TAG, "TEST: getChildId() is called...");

        return i1;
    }

    @Override
    public boolean hasStableIds() {
        Log.i(LOG_TAG, "TEST: hasStableIds() is called...");

        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        Log.i(LOG_TAG, "TEST: getGroupView() is called...");

        String title = (String) this.getGroup(i);

        if (view == null) {
            LayoutInflater mLayoutInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = mLayoutInflater.inflate(R.layout.parent_activity, null);
        }

        TextView tv = view.findViewById(R.id.mMenu);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setText(title);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Log.i(LOG_TAG, "TEST: getChildView() is called...");

        String title = (String) this.getChild(i, i1);

        if (view == null) {
            LayoutInflater mLayoutInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = mLayoutInflater.inflate(R.layout.children_activity, null);
        }

        TextView tv = view.findViewById(R.id.mSubMenu);
        tv.setText(title);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        Log.i(LOG_TAG, "TEST: isChildSelectable() is called...");

        return true;
    }
}
