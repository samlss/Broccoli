package me.samlss.broccoli_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startLayoutSample(View view) {  // 静态
        startActivity(new Intent(this, LayoutSimpleSampleActivity.class));
    }

    public void startAdvancedLayoutSample(View view) {  // 动画
        startActivity(new Intent(this, LayoutAdvancedSampleActivity.class));
    }

    public void startRecyclerViewSample(View view) {    // 列表
        startActivity(new Intent(this, RecyclerViewSampleActivity.class));
    }

    public void startDingDingSample(View view) {
        startActivity(new Intent(this, DingDingSampleActivity.class));
    }
}
