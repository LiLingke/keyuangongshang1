package com.dlc.base.BaseUi.BaseWidget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @date 2017/4/5
 * @autor KevinChung
 * @email KevinChung0769@gmail.com
 * @Description  列表view
 */

public class AutoRecycerView extends RecyclerView {

    public AutoRecycerView(Context context) {
        this(context,null);
    }

    public AutoRecycerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
