package com.dlc.base.BaseUi.BaseAdapter;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * @date 2017/5/9
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  //baseadapter 使用github的引用，自行再实现其他功能
 */

public abstract class BaseAppAdapter<T> extends BaseQuickAdapter<T> {

    public BaseAppAdapter(int layoutResId, List<T> data) {
        super(layoutResId, data);
    }
}
