package com.hebth.mobilelibrary.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

/**
 * Created by hebth on 2017-06-08.
 * Fragment的基础类，抽象一些共有的方法，提取共有的变量
 */

public abstract class BaseFragment extends Fragment {
    public static final String TAG = BaseFragment.class.getSimpleName();

    public View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(getLayoutRes(), container, false);

        initView(savedInstanceState);

        initListener();

        return mView;
    }

    public abstract int getLayoutRes();

    public abstract void initView(Bundle savedInstanceState);

    public abstract void initListener();

    private void unbindDrawables(View view)
    {
        if (view.getBackground() != null)
        {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup && !(view instanceof AdapterView))
        {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++)
            {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
        }
    }
}
