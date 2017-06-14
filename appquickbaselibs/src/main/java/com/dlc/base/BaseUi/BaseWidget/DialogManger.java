package com.dlc.base.BaseUi.BaseWidget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.dlc.base.BaseUtils.ScreenUtils;
import com.dlc.base.R;

import java.util.Arrays;


/**
 * Created by zzy on 2016/1/19. 管理对话框的Manger
 */
public class DialogManger{

    /********************对话框的类型*************************/


    /**
     * 等待对话框
     */
    public final static int DIALOG_TYPE_1 = 1;



    /********************对话框的实现类型*************************/

    /**
     * 请求网络对话框
     */
    public final static int DIALOG_TYPE_1_1 = 101;


    private int dialogTpye; //对话框类型

    private int dialogContentType; //对话框内容类型

    private Context mContext;

    private MyDialog mDialog;

    /**
     *
     * @param context
     *
     * @param dialogTpye //对话框类型
     *
     * @param dialogContentType //对话框内容类型
     * */
    public DialogManger(Context context, int dialogTpye, int dialogContentType) {
        this.mContext = context;
        this.dialogTpye = dialogTpye;
        this.dialogContentType = dialogContentType;
        initDialog();
    }

      /**
       * 初始化dialog
       * */
      private void  initDialog()
      {
          mDialog = new MyDialog(mContext, R.style.defalut_dlg_style);
          int dialogLayout = getLayout();
          setData(dialogLayout, dialogContentType);
      }

    /**
     * 根据Dialog类型返回对应的布局id
     * */
    private int  getLayout()
    {
        int layoutId = 0;
        switch (dialogTpye)
        {

            case DIALOG_TYPE_1:
                layoutId = R.layout.wait_dlg;
                break;
        }
         return layoutId;
    }


    /**
     * 根据Dialog 内容类型 初始化相应的数据
     * */
    private void setData(int dialogLayout,int dialogContentType)
    {
        mDialog.setContentView(dialogLayout);
        switch (dialogContentType) {
            case DIALOG_TYPE_1_1:{
                setWaitDlg();
            }
            break;

        }

    }


   private void initWaitDlg(){
       int with = (int) (ScreenUtils.getScreenWidth(mContext) * 0.30);
       int height = with;
       mDialog.getWindow().setLayout(with, height);
       mDialog.setCanceledOnTouchOutside(true);//
   }

   private void setWaitDlg(){
       initWaitDlg();
   }



    public void showDlg()
    {
        if(mDialog != null && !mDialog.isShowing())
            mDialog.show();
    }

    public void dismissDlg()
    {
        if(mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
    }


    class MyDialog extends Dialog {

        public MyDialog(Context context) {
            super(context);
        }

        public MyDialog(Context context, int themeResId) {
            super(context, themeResId);
        }

        public MyDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
            super(context, cancelable, cancelListener);
        }
    }




}
