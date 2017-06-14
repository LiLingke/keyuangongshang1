package com.dlc.base.BaseUi.BaseMvp;

/**
 * @date 2017/3/22
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  view的base接口，封装常用的方法。
 */

  public interface BaseView {
   void showTxt(String str);//显示信息
   void showDlg();//显示对话框
   void dissmissDlg();//隐藏对话框
}
