package com.example.admin.studyanimation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by admin on 2015/7/11.
 */
public class SingleRotationAnActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);
        final TextView t = (TextView) findViewById(R.id.textview);

        ObjectAnimator animator = ObjectAnimator.ofFloat(t,"rotation",0f,360f);
        animator.setDuration(5000);
        animator.start();
    }
}
