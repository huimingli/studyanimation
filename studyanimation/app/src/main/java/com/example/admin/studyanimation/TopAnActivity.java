package com.example.admin.studyanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by admin on 2015/7/11.
 */
public class TopAnActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.top);
        MyTopAnimView myAnimView = (MyTopAnimView) findViewById(R.id.an);
        Point point1 = new Point(0, 0);
        Point point2 = new Point(300, 300);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), point1, point2);
        anim.setDuration(5000);
        anim.start();

        ObjectAnimator oanim = ObjectAnimator.ofObject(myAnimView, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        oanim.setDuration(5000);
        oanim.start();
    }
}
