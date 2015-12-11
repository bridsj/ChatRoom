package com.zuiapps.chat.room.listview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.zuiapps.chat.room.adapter.ZUIBaseAdapter;
import com.zuiapps.chat.room.observer.ZUIObserver;

/**
 * Created by dengshengjin on 15/12/4.
 */
public class ZUIBaseListView extends ViewGroup {
    private boolean mDataChanged;
    private boolean mIsAttached;
    private ZUIObserver mZUIObserver;
    protected ZUIBaseAdapter mAdapter;
    private int mOldItemCount, mItemCount;
    private boolean mInLayout;

    public ZUIBaseListView(Context context) {
        super(context);
    }

    public ZUIBaseListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZUIBaseListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ZUIBaseListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mAdapter != null && mZUIObserver == null) {
            mZUIObserver = new ZUIObserver();
            mAdapter.registerObserver(mZUIObserver);
            mDataChanged = true;
            mOldItemCount = mItemCount;
            mItemCount = mAdapter.getCount();
        }
        mIsAttached = true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mInLayout = true;
        if (changed) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).forceLayout();
            }
        }
        layoutChildren();
        mInLayout = false;
    }

    private void layoutChildren() {
        invalidate();
        fillSpecific(0, 0);
    }

    private View fillSpecific(int position, int top) {
        return fillDown(position + 1, 100);
    }

    private View fillDown(int pos, int nextTop) {
        View selectedView = null;

        while (nextTop < 1 && pos < mItemCount) {
            // is this the selected item?
            boolean selected = pos == 1;
            View child = makeAndAddView(pos, nextTop, true, 1, selected);

            nextTop = child.getBottom() + 1;
            if (selected) {
                selectedView = child;
            }
            pos++;
        }

        return selectedView;
    }

    private View makeAndAddView(int position, int y, boolean flow, int childrenLeft,
                                boolean selected) {
        View child;

        // 代码省略
        // Make a new view for this position, or convert an unused view if possible
        child = obtainView(position, null);

        return child;
    }

    View obtainView(int position, boolean[] isScrap) {
        isScrap[0] = false;
        View scrapView;
        // 从缓存的Item View中获取,ListView的复用机制就在这里
        scrapView = null;

        View child;
        if (scrapView != null) {
            // 代码省略
            child = mAdapter.getView(position, scrapView, this);
            // 代码省略
        } else {
            child = mAdapter.getView(position, null, this);
            // 代码省略
        }

        return child;
    }
}
