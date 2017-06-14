package com.dlc.keyuan.app;


import com.dlc.base.BaseApp.BaseApplication;
import com.dlc.base.BaseHttp.RetrofitUtil;

/**
 * Created by zhongzhiyuan on 2017/5/13.
 */

public class DlcApplication extends BaseApplication {

    @Override
    public void onInitAppCreate() {
        RetrofitUtil.initRetrofit(Constants.ApiConstant.BASE_URL);
    }
}
