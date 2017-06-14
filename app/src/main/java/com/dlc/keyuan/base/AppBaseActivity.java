package com.dlc.keyuan.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dlc.base.BaseUi.BaseActivity.BaseActivity;
import com.dlc.base.BaseUi.BaseMvp.BasePresenter;
import com.dlc.base.BaseUi.BaseMvp.BaseView;
import com.dlc.base.BaseUtils.ToastUtil;

/**
 * Created by zhongzhiyuan on 2017/5/13.  自行继承baseactivity,再提供一些应用常用的方法
 */

public  abstract class AppBaseActivity<T extends BasePresenter> extends BaseActivity<T> implements BaseView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showTxt(String str) {
        ToastUtil.show(this,str);
    }

    @Override
    public T initPresenter() {
        return null;
    }

    @Override
    public void showDlg() {

    }

    @Override
    public void dissmissDlg() {

    }
}
