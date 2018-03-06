package com.example.a15616.view_layout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by hungryao on 3/6/2018.
 */

public class CustomView4 extends View {
    int lastX;
    int lastY;

    public CustomView4(Context context) {
        super(context);
    }

    public CustomView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                //使用View的ScrollBy方法来实现对VIew或VIewGroup中的VIew的滑动

                int offsetX = x - lastX;
                int offsetY = y - lastY;

                ((View)getParent()).scrollBy(-offsetX, -offsetY);
                break;

        }

        return true;
    }
}
