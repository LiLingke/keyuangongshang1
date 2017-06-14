package com.dlc.base.BaseHttp;

import com.dlc.base.BaseApp.BaseApplication;
import com.dlc.base.BaseUi.BaseWidget.DialogManger;

/**
 * @date 2017/5/11
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  请求网络回调实现类，请求默认显示dlg
 */

public abstract class DialogNetCallBack<T> extends BaseRequestCallback<T> {

    private boolean isShowDlg = true;//是否显示dlg，默认显示
    private DialogManger netDlgManger;//dlg

    public DialogNetCallBack() {
        initDlg();
    }

    public DialogNetCallBack(boolean isShowDlg) {
        this.isShowDlg = isShowDlg;
        initDlg();
    }


    private void initDlg(){
        netDlgManger = new DialogManger(BaseApplication.getCurrentActivity(),DialogManger.DIALOG_TYPE_1,DialogManger.DIALOG_TYPE_1_1);
    }

    @Override
    public void requestBefore() {
        if(isShowDlg){
           if(netDlgManger != null){
               netDlgManger.showDlg();
           }
        }
    }

    @Override
    public void requestComplete() {
        if(isShowDlg){
            if(netDlgManger != null){
                netDlgManger.dismissDlg();
            }
        }
    }

    @Override
    public void requestFail(ApiExcetion e) {
        if(isShowDlg){
            if(netDlgManger != null){
                netDlgManger.dismissDlg();
            }
        }
    }
}
