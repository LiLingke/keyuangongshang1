package com.dlc.base.BaseApp;

import android.app.Activity;
import android.app.Application;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2017/5/6
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  baseApplication 管理应用初始化，提供弱引用管理activity
 */

public abstract class BaseApplication extends Application {

    public abstract void onInitAppCreate();//baseApplication初始化方法
    public static Map<String,WeakReference<Activity>> activityLists;//保持activity
    private static Activity mCurrentActivity;//记录当前activity
    public static BaseApplication mInstance;//静态对象，内部使用


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        activityLists = new HashMap<>();
        onInitAppCreate();
    }



    public BaseApplication() {

    }

    /**
     * 添加activity
     * @param activity
     */
    public static void addActivity(Activity activity){
        if(activity != null){
            activityLists.put(activity.getClass().getSimpleName(),new WeakReference<Activity>(activity));
        }
    }

    /**
     * 移除activity
     * @param activity
     */
    public static void moveActivity(Activity activity){
        if(activity != null) {
            activityLists.remove(activity.getClass().getSimpleName());
        }
    }

    /**
     * 获取当前运行的activity
     * @return
     */
    public static Activity getCurrentActivity(){
        return mCurrentActivity;
    }
    public static void setCurrentActivity(Activity activity){
        mCurrentActivity = activity;
    }

    /**
     * 退出应用，移除所以activity
     */
    public static void exitApp(){
        for (Map.Entry<String,WeakReference<Activity>> entry :activityLists.entrySet()){
             WeakReference<Activity> activityWeakReference = entry.getValue();
             if(activityWeakReference != null && activityWeakReference.get() != null){
                 activityWeakReference.get().finish();
             }
        }

        System.exit(0);
    }

}
