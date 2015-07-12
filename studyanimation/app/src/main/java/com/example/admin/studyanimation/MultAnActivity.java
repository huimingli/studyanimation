package com.example.admin.studyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by admin on 2015/7/11.
 */
public class MultAnActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);
        final TextView t = (TextView) findViewById(R.id.textview);

        ObjectAnimator moveIn = ObjectAnimator.ofFloat(t, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(t, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(t, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
    }
}
