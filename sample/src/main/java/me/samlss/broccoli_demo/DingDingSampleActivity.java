package me.samlss.broccoli_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.samlss.broccoli.Broccoli;
import me.samlss.broccoli.PlaceholderParameter;

/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description ding ding check work sample.
 */
public class DingDingSampleActivity extends AppCompatActivity {
    private Broccoli mBroccoli;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingding);

        initPlaceholders();
    }

    private void initPlaceholders(){
        int placeholderColor = Color.parseColor("#DDDDDD");

        mBroccoli = new Broccoli();
        mBroccoli.addPlaceholders(

                new PlaceholderParameter.Builder()
                    .setView(findViewById(R.id.iv_head))
                    .setDrawable(DrawableUtils.createOvalDrawable(placeholderColor))
                    .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_name))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_description))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_day_des))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.v_shangban))
                        .setDrawable(DrawableUtils.createOvalDrawable(placeholderColor))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.v_xiaban))
                        .setDrawable(DrawableUtils.createOvalDrawable(placeholderColor))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.v_timeline))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_shangban))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_xiaban))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_daka))
                        .setDrawable(DrawableUtils.createOvalDrawable(placeholderColor))
                        .build(),

                new PlaceholderParameter.Builder()
                        .setView(findViewById(R.id.tv_daka_des))
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 0))
                        .build()

        );

        showPlaceholders();
    }

    private void showPlaceholders(){
        mBroccoli.show();
        mHandler.removeCallbacks(task);
        mHandler.postDelayed(task,2000);
    }

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            mBroccoli.removeAllPlaceholders();
        }
    };
}
