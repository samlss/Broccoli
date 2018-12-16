package me.samlss.broccoli_demo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import me.samlss.broccoli.Broccoli;


/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description The layout sample.
 */
public class LayoutAdvancedSampleActivity extends AppCompatActivity {
    private TextView tvViewTimes;
    private TextView tvCollectTimes;
    private TextView tvPrice;
    private ImageView ivClock;
    private TextView tvTime;
    private ImageView ivCalendar;
    private ImageView ivLocation;
    private TextView tvLocation;
    private ImageView ivRightArrow;
    private View vLine;
    private ImageView ivLogo;
    private TextView tvOrganizer;
    private TextView tvOrganizerDescription;
    private TextView tvFans;
    private TextView tvFansNumber;
    private TextView tvEvents;
    private TextView tvEventsNumber;
    private TextView tvFollow;
    private TextView tvStation;

    private Broccoli mBroccoli;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#847465"));
        }
        setContentView(R.layout.activity_layout_sample);

        initViews();
        initPlaceholders();
    }

    private void initViews(){
        tvViewTimes = findViewById(R.id.tv_view_time);
        tvCollectTimes = findViewById(R.id.tv_collect_time);
        tvPrice = findViewById(R.id.tv_price);
        ivClock = findViewById(R.id.iv_clock);
        tvTime = findViewById(R.id.tv_time);
        ivCalendar = findViewById(R.id.iv_calendar);
        ivLocation = findViewById(R.id.iv_location);
        tvLocation = findViewById(R.id.tv_location);
        ivRightArrow = findViewById(R.id.iv_arrow_right);
        vLine = findViewById(R.id.view_line);
        ivLogo = findViewById(R.id.iv_logo);
        tvOrganizer = findViewById(R.id.tv_organizer_name);
        tvOrganizerDescription = findViewById(R.id.tv_organizer_description);
        tvFans = findViewById(R.id.tv_fans);
        tvFansNumber = findViewById(R.id.tv_fans_number);
        tvEvents = findViewById(R.id.tv_events);
        tvEventsNumber = findViewById(R.id.tv_events_number);
        tvFollow = findViewById(R.id.tv_follow);
        tvStation = findViewById(R.id.tv_station);

        findViewById(R.id.iv_retry).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setPivotX(v.getWidth() / 2);
                v.setPivotY(v.getHeight() / 2);

                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    v.animate()
                            .scaleX(1.3f)
                            .scaleY(1.3f)
                            .setInterpolator(new BounceInterpolator())
                            .setDuration(300)
                            .start();
                }else if (event.getAction() == MotionEvent.ACTION_CANCEL
                        || event.getAction() == MotionEvent.ACTION_UP){
                    v.animate()
                            .scaleX(1)
                            .scaleY(1)
                            .setInterpolator(new BounceInterpolator())
                            .setDuration(300)
                            .start();
                }
                return false;
            }
        });
    }

    private void initPlaceholders(){
        mBroccoli = new Broccoli();
        mBroccoli.addPlaceholders(PlaceholderHelper.getParameter(tvViewTimes),
                    PlaceholderHelper.getParameter(tvCollectTimes),
                    PlaceholderHelper.getParameter(tvPrice),
                    PlaceholderHelper.getParameter(ivClock),
                    PlaceholderHelper.getParameter(tvTime),
                    PlaceholderHelper.getParameter(ivCalendar),
                    PlaceholderHelper.getParameter(ivLocation),
                    PlaceholderHelper.getParameter(tvLocation),
                    PlaceholderHelper.getParameter(ivRightArrow),
                    PlaceholderHelper.getParameter(ivLogo),
                    PlaceholderHelper.getParameter(tvOrganizer),
                    PlaceholderHelper.getParameter(tvOrganizerDescription),
                    PlaceholderHelper.getParameter(tvFans),
                    PlaceholderHelper.getParameter(tvFansNumber),
                    PlaceholderHelper.getParameter(tvEvents),
                    PlaceholderHelper.getParameter(tvEventsNumber),
                    PlaceholderHelper.getParameter(tvFollow),
                    PlaceholderHelper.getParameter(tvStation)
                );

        showPlaceholders();
    }

    private void showPlaceholders(){
        mBroccoli.show();

        mHandler.removeCallbacks(task);
        mHandler.postDelayed(task,3000);
    }

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            showData();
        }
    };

    private void showData(){
        mBroccoli.clearAllPlaceholders();
    }

    public void onRetry(View view) {
        showPlaceholders();
    }
}
