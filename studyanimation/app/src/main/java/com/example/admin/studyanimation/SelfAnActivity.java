package com.example.admin.studyanimation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by admin on 2015/7/11.
 */
public class SelfAnActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);
        WindowManager wm = this.getWindowManager();

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        MySelfAnimView mySelfAnimView = (MySelfAnimView) findViewById(R.id.an);
        mySelfAnimView.setText("hello world huimingli");
        mySelfAnimView.setStartx(0);
        mySelfAnimView.setEndx(0);
        mySelfAnimView.setStarty(0);
        mySelfAnimView.setEndy(height/2);
       MySelfAnimView myAnimView = (MySelfAnimView) findViewById(R.id.an);
        ObjectAnimator oanim = ObjectAnimator.ofObject(myAnimView, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        oanim.setDuration(5000);
        oanim.start();
    }


}
