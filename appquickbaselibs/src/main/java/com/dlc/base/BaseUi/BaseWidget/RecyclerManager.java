package com.dlc.base.BaseUi.BaseWidget;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dlc.base.BaseUi.BaseAdapter.BaseAppAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * @date 2017/4/5
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  封装初始化RecyclerView的builder类
 */

public class RecyclerManager {

    private AutoRecycerView mRecyclerView;
    private TwinklingRefreshLayout mRefreshLy;
    private BaseAppAdapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private RecyclerView.ItemDecoration mDecor;
    private boolean mIsLoadMode = true;
    private boolean mIsRefresh = true;
    private View mFootView;
    private View mHeadView;

    //私有构造函数
    private RecyclerManager(AutoRecycerView recyclerView, TwinklingRefreshLayout refreshLayout){
        this.mRecyclerView = recyclerView;
        this.mRefreshLy = refreshLayout;
    }

    //唯一的静态方法，才能实例化对象
    public static RecyclerManager initView(AutoRecycerView recyclerView, TwinklingRefreshLayout refreshLayout){

        return new RecyclerManager(recyclerView,refreshLayout);
    }

    public static RecyclerManager initView(AutoRecycerView recyclerView){

        return new RecyclerManager(recyclerView,null);
    }

    //设置上下拉控件
    public RecyclerManager setRefreshLy(TwinklingRefreshLayout refreshLayout){
        this.mRefreshLy = refreshLayout;
        return this;
    }

    //设置recyclerview adapter
    public RecyclerManager setAdapter(BaseAppAdapter adapter){
        this.mAdapter = adapter;
        return this;
    }

    //设置  layoutmanager，不设置默认是 LinearLayoutManager
    public RecyclerManager setLayoutManager(RecyclerView.LayoutManager manager){
        this.mManager = manager;
        return this;
    }

    //设置是否可以加载更多，默认开启
    public RecyclerManager setEnableLoadmore(boolean enableLoadMore){
        this.mIsLoadMode = enableLoadMore;
        return this;
    }

    //设置是否下拉刷新，默认开启
    public RecyclerManager setEnableRefresh(boolean enableRefresh){
       this.mIsRefresh = enableRefresh;
        return this;
    }

    //设置recyclerview headview
    public RecyclerManager setHeadView(View headView){
        this.mHeadView = headView;
        return this;
    }

    //设置recyclerview footview
    public RecyclerManager setFootView(View footView){
        this.mFootView = footView;
        return this;
    }


    //完成各种更能的组装
    public void build(Context mContext){
        if(!checkParamNull()) { //检查必要参数是否为空
           initRecycler(mContext);//设置recyclerview
            initRefreshLy();//设置 TwinklingRefreshLayout
        }
    }

    private boolean checkParamNull() {
        if(mRecyclerView == null) {
            throw  new NullPointerException("RecyclerView is Null!");
        }
        if(mAdapter == null) {
            throw  new NullPointerException("BaseQuickAdapter is Null!");
        }

        return false;
    }

    private void initRecycler(Context context){
        if(mManager == null) { //默认是LinearLayoutmanager
            mManager = new LinearLayoutManager(context);
        }
        if(mDecor == null) { //分割线默认自行实现

        }

        if(mHeadView != null){ //设置head
            mAdapter.addHeaderView(mHeadView);
        }

        if(mFootView  != null){ //设置footview
            mAdapter.addFooterView(mFootView);
        }

        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initRefreshLy(){
        if(mRefreshLy != null) {
            mRefreshLy.setEnableRefresh(mIsRefresh);
            mRefreshLy.setEnableLoadmore(mIsLoadMode);
        }
    }

}
