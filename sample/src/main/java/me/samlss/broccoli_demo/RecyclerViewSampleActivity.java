package me.samlss.broccoli_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.samlss.broccoli.Broccoli;
import me.samlss.broccoli.PlaceholderParameter;
import me.samlss.broccoli.BroccoliGradientDrawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description Sample of RecyclerView.
 */
public class RecyclerViewSampleActivity extends AppCompatActivity {
    private static int[] sImageIds = new int[]{
            R.mipmap.photo_1,R.mipmap.photo_2,
            R.mipmap.photo_3,R.mipmap.photo_4,
            R.mipmap.photo_5
    };

    private static int[] sPrices = new int[]{
           549, 1499, 1199, 1699, 3388
    };

    private static String[] sTitles = new String[]{
            "honor/荣耀 畅玩7",
            "Huawei/华为 畅想MAX",
            "honor/荣耀 荣耀9i",
            "Huawei/华为 畅想9 PLUS",
            "Huawei/华为 P20",
    };

    private static String[] sDescriptions = new String[]{
            "2018.05上市 | 免举证退换货",
            "2018.10上市 | 免举证退换货",
            "2018.06上市 | 免举证退换货",
            "2018.10上市 | 免举证退换货",
            "2018.04上市 | 免举证退换货",
    };
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private List<DataBean> mDataList = new ArrayList<>();


    private Map<View, Broccoli> mViewPlaceholderManager = new HashMap<>();
    private Map<View, Runnable> mTaskManager = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_sample);

        initData();
        initRecyclerView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDataList.clear();

        for (View view : mTaskManager.keySet()){
            view.removeCallbacks(mTaskManager.get(view));
        }

        //Prevent memory leaks when using BroccoliGradientDrawable
        //防止使用BroccoliGradientDrawable时内存泄露
        for (Broccoli broccoli : mViewPlaceholderManager.values()){
            broccoli.removeAllPlaceholders();
        }

        mViewPlaceholderManager.clear();
        mTaskManager.clear();
    }

    private void initData(){
        for (int i = 0; i < 20; i++){
            DataBean dataBean = new DataBean();
            dataBean.imageRes = sImageIds[i % sImageIds.length];
            dataBean.title = sTitles[i % sTitles.length];
            dataBean.description = sDescriptions[i % sDescriptions.length];
            dataBean.price = sPrices[i % sPrices.length];

            mDataList.add(dataBean);
        }
    }

    private void initRecyclerView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);
    }


    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.recyclerview_sample_item, viewGroup, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int position) {
            Broccoli broccoli = mViewPlaceholderManager.get(myViewHolder.itemView);
            final int itemPos = position;
            if (broccoli == null){
                broccoli = new Broccoli();
                mViewPlaceholderManager.put(myViewHolder.itemView, broccoli);
            }

            broccoli.removeAllPlaceholders();
            broccoli.addPlaceholder(new PlaceholderParameter.Builder()
                    .setView(myViewHolder.tvTitle)
                    .setDrawable(new BroccoliGradientDrawable(Color.parseColor("#DDDDDD"),
                            Color.parseColor("#FF0000"), 0, 1000, new LinearInterpolator()))
                    .build());
            broccoli.addPlaceholder(new PlaceholderParameter.Builder()
                    .setView(myViewHolder.imageView)
                    .setDrawable(new BroccoliGradientDrawable(Color.parseColor("#DDDDDD"),
                            Color.parseColor("#FF0000"), 0, 1000, new LinearInterpolator()))
                    .build());
            broccoli.addPlaceholder(new PlaceholderParameter.Builder()
                    .setView(myViewHolder.tvPrice)
                    .setDrawable(new BroccoliGradientDrawable(Color.parseColor("#DDDDDD"),
                            Color.parseColor("#FF0000"), 0, 1000, new LinearInterpolator()))
                    .build());
            broccoli.addPlaceholder(new PlaceholderParameter.Builder()
                    .setView(myViewHolder.tvDescription)
                    .setDrawable(new BroccoliGradientDrawable(Color.parseColor("#DDDDDD"),
                            Color.parseColor("#FF0000"), 0, 1000, new LinearInterpolator()))
                    .build());
            broccoli.show();


            //delay to show the data
            Runnable task = mTaskManager.get(myViewHolder.itemView);
            if (task == null){
                final Broccoli finalBroccoli = broccoli;
                task = new Runnable() {
                    @Override
                    public void run() {
                        //when you need to update data, you must to call the remove or the clear method.
                        finalBroccoli.removeAllPlaceholders();

                        if (mDataList.isEmpty()){
                            return;
                        }

                        myViewHolder.imageView.setImageResource(mDataList.get(itemPos).imageRes);
                        myViewHolder.tvPrice.setText("¥ "+String.valueOf(mDataList.get(itemPos).price));
                        myViewHolder.tvTitle.setText(mDataList.get(itemPos).title);
                        myViewHolder.tvDescription.setText(mDataList.get(itemPos).description);
                    }
                };
                mTaskManager.put(myViewHolder.itemView, task);
            }else{
                myViewHolder.itemView.removeCallbacks(task);
            }
            myViewHolder.itemView.postDelayed(task, 3000);
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvTitle;
        private TextView tvDescription;
        private TextView tvPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_image);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }


    private static class DataBean{
        int imageRes;
        private String title;
        private String description;
        private int price;
    }
}
