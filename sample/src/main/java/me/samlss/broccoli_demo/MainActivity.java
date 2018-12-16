package me.samlss.broccoli_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startLayoutSample(View view) {
        startActivity(new Intent(this, LayoutSimpleSampleActivity.class));
    }

    public void startRecyclerViewSample(View view) {
        startActivity(new Intent(this, RecyclerViewSampleActivity.class));
    }

    public void startAdvancedLayoutSample(View view) {
        startActivity(new Intent(this, LayoutAdvancedSampleActivity.class));
    }

    public void startDingDingSample(View view) {
        startActivity(new Intent(this, DingDingSampleActivity.class));
    }
}
