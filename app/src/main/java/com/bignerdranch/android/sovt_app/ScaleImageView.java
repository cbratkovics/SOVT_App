package com.bignerdranch.android.sovt_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ScaleImageView extends android.support.v7.widget.AppCompatImageView {
    private float lastX, lastY;// saved touch point
    private float lastDistance;//distance between 2 touch points

    public ScaleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleImageView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = event.getX();
                lastY = event.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() == 2) {//if get 2 touch point
                    final float disX = Math.abs(event.getX(0) - event.getX(1));//moved distance for first point
                    final float disY = Math.abs(event.getY(0) - event.getY(1));//moved distance for second point
                    final float dis = (float) Math.sqrt(disX * disX + disY * disY);//record the distance
                    if (lastDistance == 0) {
                        lastDistance = dis;//first record
                    } else {
                        float scale = dis / lastDistance;
                        lastDistance = dis;//replace the previous
                        scaleImage(scale);
                    }
                } else if (event.getPointerCount() == 1) {//only one touch point
                    final float currentX = event.getX();
                    final float currentY = event.getY();
                    final float disX = currentX - lastX;
                    final float disY = currentY - lastY;
                    scrollBy(-(int) disX, -(int) disY);//drag the image
                    lastX = currentX;//replace the previous position
                    lastY = currentY;
                }
                break;
            case MotionEvent.ACTION_UP:
                lastX = 0;//initialize the position
                lastY = 0;
                lastDistance = 0;
                break;
            default:
                break;
        }

        super.onTouchEvent(event);
        return true;
    }

    /**
     * scaling
     * @param scale
     */
    private void scaleImage(float scale) {
        final int width = getWidth();
        final int newWidth = (int) (width * scale);
        final int height = getHeight();
        final int newHeight = (int) (height * scale);
        ViewGroup.LayoutParams params = getLayoutParams();
        params.height = newHeight;
        params.width = newWidth;
        setLayoutParams(params);
    }

}
