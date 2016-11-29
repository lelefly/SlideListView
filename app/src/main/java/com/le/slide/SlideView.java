package com.le.slide;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.right;

/**
 * Created by admin on 2016/11/24.
 */

public class SlideView extends LinearLayout {

    int lastX;
    int lastY;

    public SlideView(Context context) {
        super(context);
    }

    public SlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int scrollX = getScrollX();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - lastX;
                int deltaY = y - lastY;
                int newScrollX = scrollX - deltaX;
                if (Math.abs(deltaX) < Math.abs(deltaY)) {
                    break;
                }
                this.scrollTo(newScrollX,0);
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        lastX = x;
        lastY = y;
        return super.onTouchEvent(event);
    }
}
