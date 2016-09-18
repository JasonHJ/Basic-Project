package com.hy.basicproject.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hy.basicproject.interfaces.IFragment;
import com.hy.basicproject.interfaces.IRegister;
import com.hy.basicproject.utils.SharedPreferencesUtil;


/**
 * Fragment父类
 *
 * @author qq8585083
 *
 */
public abstract class BaseFragment extends Fragment
        implements IFragment, IRegister, View.OnClickListener {
    private static final String SP_NAME = "firstConfig";
    protected Activity activity;

    private SharedPreferencesUtil mSharedPreferencesUtil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity = getActivity();
        View parentView = inflater.inflate(getLayoutResId(), container, false);
        mSharedPreferencesUtil = new SharedPreferencesUtil(getActivity(), SP_NAME);
        final String simpleName = this.getClass().getSimpleName();
        if (mSharedPreferencesUtil.getBooleanValue(simpleName, true)) {
            onFirst();
            mSharedPreferencesUtil.putBooleanValue(simpleName, false);
        }
        initData();
        initView(parentView, savedInstanceState);
        return parentView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        register();
    }


    @Override
    public void onDestroyView() {
        unRegister();
        super.onDestroyView();
    }


    @Override
    public void onFirst() { }
    @Override
    public void initData() { }
    @Override
    public void initView(View parentView, Bundle savedInstanceState) { }
    @Override
    public void register() { }
    @Override
    public void unRegister() { }
    @Override
    public void onChange() { }
    @Override
    public void onHidden() { }
    @Override
    public void showProgress() { }
    @Override
    public void hideProgress() { }


    @Override
    public void onClick(View v) {
        viewClick(v);
    }

    @Override
    public void viewClick(View v) { }
}
