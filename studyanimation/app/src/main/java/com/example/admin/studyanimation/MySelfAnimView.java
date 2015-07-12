package com.example.admin.studyanimation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by admin on 2015/7/12.
 */
public class MySelfAnimView extends View {

    private String text;
    public static final float RADIUS = 50f;

    private Point currentPoint;

    private Paint mPaint;

    private float startx =0;
    private float starty =0;
    private float endx =0;
    private float endy =0;


    public MySelfAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
        text = "hello";
    }
    public MySelfAnimView(Context context, AttributeSet attrs,float startx,float starty,float endx,float endy) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
        text = "hello";
        this.startx = startx;
        this.starty = starty;
        this.endx = endx;
        this.endy = endy;
    }

    public float getStartx() {
        return startx;
    }

    public void setStartx(float startx) {
        this.startx = startx;
    }

    public float getStarty() {
        return starty;
    }

    public void setStarty(float starty) {
        this.starty = starty;
    }

    public float getEndx() {
        return endx;
    }

    public void setEndx(float endx) {
        this.endx = endx;
    }

    public float getEndy() {
        return endy;
    }

    public void setEndy(float endy) {
        this.endy = endy;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new Point(startx, starty);
            drawText(canvas);
            startAnimation();
        } else {
            drawText(canvas);
        }
    }

    private void drawText(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        mPaint.setTextSize(40);
        canvas.drawText(text, x, y, mPaint);

    }
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void startAnimation() {
        Point startPoint;
        Point endPoint;
        if(startx == 0.0f&&starty == 0.0f&&endx == 0.0f&&endy == 0.0f) {
           startPoint = new Point(getWidth() / 2, RADIUS);
            endPoint = new Point(getWidth() / 2, getHeight() / 2);
        }else{
            startPoint = new Point(startx,starty);
            endPoint = new Point(endx,endy);
        }
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setInterpolator(new BounceInterpolator());
        anim.setDuration(3000);
        anim.start();
    }

}
