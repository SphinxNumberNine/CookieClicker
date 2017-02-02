package org.a10019420sbstudents.cookieclickerv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    ImageView cookieImageView;
    TextView cookieTextView;
    AtomicInteger cookieCount = new AtomicInteger(0);
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cookieImageView = (ImageView) findViewById(R.id.cookieImageView);
        cookieTextView = (TextView) findViewById(R.id.cookiesTextView);
        layout = (RelativeLayout) findViewById(R.id.relativeLayout);
        cookieImageView.setImageResource(R.drawable.cookie);
        cookieImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.00f, 0.75f, 1.00f, 0.75f, Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
                scaleAnimation.setDuration(100);
                v.startAnimation(scaleAnimation);
                cookieCount.incrementAndGet();
                cookieTextView.setText(cookieCount + " Cookies");
                final TextView plusOne = new TextView(MainActivity.this);
                plusOne.setText("+1");
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.BELOW, R.id.cookieImageView);
                params.addRule(RelativeLayout.CENTER_HORIZONTAL, R.id.cookieImageView);
                int xpad1 = (int)(Math.random() * 500);
                int xpad2 = (int)(Math.random() * 500);
                plusOne.setPadding(xpad1, 0, xpad2, 0);
                layout.addView(plusOne, params);
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -10);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        layout.removeView(plusOne);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                translateAnimation.setDuration(3000);
                plusOne.startAnimation(translateAnimation);
            }
        });
        Thread passiveIncome = new Thread(){
            public void run(){
                if(cookieCount.get() > 50){

                }
            }
        };
    }
}
