package com.example.a15616.view_layout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.io.LineNumberReader;

/**
 * Created by hungryao on 3/6/2018.
 */

/**
 * 改变布局参数的方法自定义 LayoutParams
 */

public class CustomView3 extends View {

    int lastX;
    int lastY;

    public CustomView3(Context context) {
        super(context);
    }

    public CustomView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //不同在于ActionMove中的代码

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();



        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;

                break;

            case MotionEvent.ACTION_MOVE:

                int offsetX = x - lastX;
                int offsetY = y - lastY;

                ViewGroup.MarginLayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
                break;

        }

        return true;
    }
}
