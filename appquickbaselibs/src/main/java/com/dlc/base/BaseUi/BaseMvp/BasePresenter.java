package com.dlc.base.BaseUi.BaseMvp;

/**
 * @date 2017/3/22
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  Presenter的base接口，基础的操作可以封装在这里
 */

public interface BasePresenter {
    void start();//同步Activity或者Fragment的生命周期
    void destory();

}
