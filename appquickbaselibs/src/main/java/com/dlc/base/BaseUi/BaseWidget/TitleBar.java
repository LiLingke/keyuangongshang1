package com.dlc.base.BaseUi.BaseWidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dlc.base.R;


/**
 * Created by lizhiyong on 2015/12/28.  titlebar 荔枝勇提供的
 */
public class TitleBar extends Toolbar {

    public TextView titleText;
    public ImageButton leftImage;
    public ImageButton rightImage;
    public TextView leftText;
    public TextView rightText;
    private int mHeight;

    public static final int TITLE_TEXT = R.id.titleText;
    public static final int LEFT_IMAGE = R.id.leftImage;
    public static final int RIGHT_IMAGE = R.id.rightImage;
    public static final int LEFT_TEXT = R.id.leftText;
    public static final int RIGHT_TEXT = R.id.rightText;

    public TitleBar(Context context) {
        super(context);
        init(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        // 设置高度
        mHeight = getResources().getDimensionPixelSize(R.dimen.title_height);

        View view = LayoutInflater.from(context).inflate(R.layout.view_title_bar, this, true);

        titleText = (TextView) view.findViewById(TITLE_TEXT);
        leftImage = (ImageButton) view.findViewById(LEFT_IMAGE);
        rightImage = (ImageButton) view.findViewById(RIGHT_IMAGE);
        leftText = (TextView) view.findViewById(LEFT_TEXT);
        rightText = (TextView) view.findViewById(RIGHT_TEXT);

        int backgroundColor = ContextCompat.getColor(getContext(), R.color.main_title_panel);

        int buttonSelectorRes = R.drawable.selector_titlebar_button_bg;

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);

            String titleText = typedArray.getString(R.styleable.TitleBar_titleText);

            this.titleText.setText(titleText);
            
            // 左侧按钮
            int leftDrawableRes = typedArray.getResourceId(R.styleable.TitleBar_leftDrawable, 0);

            if (leftDrawableRes != 0) {
                leftImage.setImageResource(leftDrawableRes);
            }

            boolean showLeftImage =
                typedArray.getBoolean(R.styleable.TitleBar_showLeftImage, leftDrawableRes != 0);

            leftImage.setVisibility(showLeftImage ? VISIBLE : GONE);

            // 右侧按钮
            int rightDrawableRes = typedArray.getResourceId(R.styleable.TitleBar_rightDrawable, 0);

            if (rightDrawableRes != 0) {
                rightImage.setImageResource(rightDrawableRes);
            }

            boolean showRightImage =
                typedArray.getBoolean(R.styleable.TitleBar_showRightImage, rightDrawableRes != 0);

            rightImage.setVisibility(showRightImage ? VISIBLE : GONE);

            // 左侧文字
            String leftString = typedArray.getString(R.styleable.TitleBar_leftText);
            leftText.setText(leftString);
            boolean showLeftText = typedArray.getBoolean(R.styleable.TitleBar_showLeftText,
                !TextUtils.isEmpty(leftString));
            leftText.setVisibility(showLeftText ? VISIBLE : GONE);

            // 右侧文字
            String rightString = typedArray.getString(R.styleable.TitleBar_rightText);
            rightText.setText(rightString);
            boolean showRightText = typedArray.getBoolean(R.styleable.TitleBar_showRightText,
                !TextUtils.isEmpty(rightString));
            rightText.setVisibility(showRightText ? VISIBLE : GONE);

            backgroundColor =
                typedArray.getColor(R.styleable.TitleBar_backgroundColor, backgroundColor);

            buttonSelectorRes =
                typedArray.getResourceId(R.styleable.TitleBar_buttonSelector, buttonSelectorRes);

            typedArray.recycle();
        }

        setBackgroundColor(backgroundColor);
        setButtonSelector(buttonSelectorRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(mHeight, specMode);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setButtonSelector(int resId) {
        leftImage.setBackgroundResource(resId);
        rightImage.setBackgroundResource(resId);
    }

    @Override
    public void setTitle(@StringRes int resId) {
        titleText.setText(resId);
    }

    @Override
    public void setTitle(CharSequence title) {
        titleText.setText(title);
    }
}
