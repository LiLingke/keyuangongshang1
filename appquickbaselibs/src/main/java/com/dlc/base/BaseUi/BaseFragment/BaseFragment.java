package com.dlc.base.BaseUi.BaseFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @date 2017/5/6
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  basefragment ，这里还没有提供懒加载，以后再提供
 */

public abstract class BaseFragment extends Fragment {
    public Context mContext;
    public View mRoomView;// fragment rootview
    public abstract void initView(@Nullable Bundle savedInstanceState,View rootview);
    public abstract void initBus();//监听事件
    public abstract void initDatas();//初始化数据
    public abstract int findLayoutId();//布局id
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         mRoomView = inflater.inflate(findLayoutId(),container,false);
         initView(savedInstanceState,mRoomView);
         initBus();
         initDatas();
         return mRoomView;
    }
}
