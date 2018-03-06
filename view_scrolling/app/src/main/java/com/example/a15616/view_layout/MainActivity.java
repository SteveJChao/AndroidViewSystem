package com.example.a15616.view_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    public CustomView customView;
    public CustomView5 customView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView = (CustomView) findViewById(R.id.custom_view);
        customView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));

        customView5 = (CustomView5) findViewById(R.id.custom_view5);
        customView5.smoothScrollTo(-400, -225);
    }
}
