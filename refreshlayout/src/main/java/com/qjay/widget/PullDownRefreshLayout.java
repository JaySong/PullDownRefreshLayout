package com.qjay.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingParent;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/**
 * Created by 仇杰 on 2016/1/10.
 *
 * @author 仇杰、陈军
 * @version 1.0.0
 *          <p>
 *          #.实现一个可自定义刷新View样式的刷新控件，非侵入式实现，适用于所有View
 *          #.实现的两个接口来自v4包，所以使用此控件可能要将v4包添加到项目中
 *          #.实现原理参考{@link android.support.v4.widget.SwipeRefreshLayout}
 *          </p>
 * @see android.support.v4.view.NestedScrollingParent
 * @see android.support.v4.view.NestedScrollingChild
 */
public class PullDownRefreshLayout extends ViewGroup implements NestedScrollingParent,
        NestedScrollingChild {
    /**
     * 是否可用属性
     */
    private static final int[] LAYOUT_ATTRS = new int[] {
            android.R.attr.enabled
    };
    /**
     * 目标View,即响应刷新控件的View,is this view group's child view
     */
    private View mTarget;
    /**
     * 刷新样式的View
     */
    private View mRefreshView;
    /**
     * 当前是否刷新中
     */
    private boolean isRefreshing;
    private int mTouchSlop;
    private int mMediumAnimationDuration;

    public PullDownRefreshLayout(Context context) {
        this(context, null);
    }

    public PullDownRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mMediumAnimationDuration = getResources().getInteger(
                android.R.integer.config_mediumAnimTime);
        //下面三行主要设置是否可用
        final TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
        setEnabled(a.getBoolean(0, true));
        a.recycle();

        final DisplayMetrics metrics = getResources().getDisplayMetrics();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 确保目标不为空,ensure target view not null.
     */
    private void ensureTarget() {
        if (mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (!child.equals(mRefreshView)) {
                    mTarget = child;
                    break;
                }
            }
        }
    }

    /**
     * @return 返回当前是否正在刷新中
     */
    public boolean isRefreshing() {
        return isRefreshing;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {

    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return false;
    }

    @Override
    public boolean startNestedScroll(int axes) {
        return false;
    }

    @Override
    public void stopNestedScroll() {

    }

    @Override
    public boolean hasNestedScrollingParent() {
        return false;
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return false;
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return false;
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return false;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {

    }

    @Override
    public void onStopNestedScroll(View target) {

    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {

    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        return 0;
    }

    /**
     * 设置刷新监听对象，当触发刷新动作时此对象会回调{@link OnRefreshListener#onRefresh()}方法
     *
     * @param listener {@link com.qjay.widget.PullDownRefreshLayout.OnRefreshListener}
     */
    public void setOnRefreshListener(OnRefreshListener listener) {

    }

    /**
     * 开始刷新，负责刷新动作后续一系列的调用
     */
    public void startRefresh() {

    }

    /**
     * 停止、结束刷新
     */
    public void stopRefresh() {

    }

    /**
     * <p>
     * 当刷新时此监听负责通知使用者，即回调{@link #onRefresh()}方法
     * </p>
     */
    public interface OnRefreshListener {
        /**
         * 当开始刷新的时候回调，即用户松开手刷新动作开始时
         */
        void onRefresh();
    }
}
