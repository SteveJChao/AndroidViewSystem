package com.example.a15616.view_layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by hungryao on 3/5/2018.
 */

public class CustomView extends View {
    private int lastX;
    private int lastY;

    private static final String TAG = "CustomView";

    /**
     * 三个构造方法
     * @param context
     */
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取手指触摸点的坐标
        int x = (int) event.getX();
        int y = (int) event.getY();

//        Log.d(TAG, "onTouchEvent: 手指触摸点的坐标" + x + "..." + y);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;

//                Log.d(TAG, "onTouchEvent: 按下后的坐标" + lastX + "..." + lastY);

                break;
            case MotionEvent.ACTION_MOVE:
                //偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
//                Log.d(TAG, "onTouchEvent: 偏移量" + offsetX + "..." + offsetY);

                //调用layout方法更新位置
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                break;
        }

        return true;
    }


}
