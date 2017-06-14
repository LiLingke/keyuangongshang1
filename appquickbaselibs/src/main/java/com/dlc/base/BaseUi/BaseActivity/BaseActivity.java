package com.dlc.base.BaseUi.BaseActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dlc.base.BaseApp.BaseApplication;
import com.dlc.base.BaseUi.BaseMvp.BasePresenter;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * @date 2017/5/6
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  baseactivty 提供一些常用接口给子类实现，建议上层再继承这个写一个抽象类
 */

public abstract class BaseActivity<T extends BasePresenter> extends AutoLayoutActivity {
    public abstract int findLayoutId();//获取布局id
    public abstract void initView(@Nullable Bundle savedInstanceState);//初始化view
    public abstract void initBus();//初始化监听事件
    public abstract void initDatas();//初始化数据
    public abstract T initPresenter();//presenter
    public Context mContext;//上下文内容
    public T mPresenter;//presenter
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(findLayoutId());
        ButterKnife.bind(this);
        BaseApplication.addActivity(this);
        BaseApplication.setCurrentActivity(this);
        mContext = this;
        mPresenter = initPresenter();
        initView(savedInstanceState);
        initBus();
        initDatas();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mPresenter != null)
        mPresenter.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null)
        mPresenter.destory();
        BaseApplication.moveActivity(this);
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        BaseApplication.setCurrentActivity(this);

    }
}
