package com.dlc.base.BaseUtils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

/**
 * 作者：create by zzy on 2017/3/23 08:46
 * 邮箱：kevinchung0769@gmail.com
 * Glide工具类
 */


/**
 * load SD卡资源：load("file://"+ Environment.getExternalStorageDirectory().getPath()+"/test.jpg")
 load assets资源：load("file:///android_asset/f003.gif")
 load raw资源：load("Android.resource://com.frank.glide/raw/raw_1")或load("android.resource://com.frank.glide/raw/"+R.raw.raw_1)
 load drawable资源：load("android.resource://com.frank.glide/drawable/news")或load("android.resource://com.frank.glide/drawable/"+R.drawable.news)
 load ContentProvider资源：load("content://media/external/images/media/139469")
 load http资源：load("http://img.my.csdn.net/uploads/201508/05/1438760757_3588.jpg")
 load https资源：load("https://img.alicdn.com/tps/TB1uyhoMpXXXXcLXVXXXXXXXXXX-476-538.jpg_240x5000q50.jpg_.webp")
 */
public class GlideUtil {
    /**
     * 加载图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadImg(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     *
     * @param context
     * @param file
     * @param imageView
     */
    public static void loadImg(Context context, File file, ImageView imageView){
        Glide.with(context).load(file).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadCircleImg(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).transform(new GlideCircleTransform(context)).into(imageView);
    }

    /**
     *
     * @param context
     * @param file
     * @param imageView
     */
    public static void loadCircleImg(Context context, File file, ImageView imageView){
        Glide.with(context).load(file).diskCacheStrategy(DiskCacheStrategy.ALL).transform(new GlideCircleTransform(context)).into(imageView);
    }

    /**
     * 圆角图形
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadRoundImg(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).transform(new GlideRoundTransform(context)).into(imageView);
    }

    /**
     * 这里配置glide
     */
    public static void initGlide(){

    }
}
