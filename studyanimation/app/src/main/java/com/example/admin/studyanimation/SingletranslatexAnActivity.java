package com.example.admin.studyanimation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by admin on 2015/7/11.
 */
public class SingletranslatexAnActivity extends Activity{
    private static final String TAG = "Singletranslatex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);
        final TextView t = (TextView) findViewById(R.id.textview);

        ObjectAnimator animator = ObjectAnimator.ofFloat(t, "translationX", 10f, 500f ,50f);
        animator.setDuration(5000);
        animator.start();
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"clicked");

            }
        });
    }
}
