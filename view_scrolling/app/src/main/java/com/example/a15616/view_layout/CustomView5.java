package com.example.a15616.view_layout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by hungryao on 3/6/2018.
 */

/**
 * 使用Scroller 和 View 的computeScroll()来完成平滑的移动
 */

public class CustomView5 extends View {

    public Scroller mScroller;

    public CustomView5(Context context) {
        super(context);
    }

    public CustomView5(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //初始化Scroller
        mScroller = new Scroller(context);

    }

    public CustomView5(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;

        int scrollY = getScrollY();
        int deltaY = destY - scrollY;
        mScroller.startScroll(scrollX, 0, deltaX, deltaY, 8000);
    }
}
