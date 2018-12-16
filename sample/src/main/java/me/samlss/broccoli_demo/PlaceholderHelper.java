package me.samlss.broccoli_demo;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import me.samlss.broccoli.PlaceholderParameter;

/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description helper of placeholder
 */
public class PlaceholderHelper {
    private PlaceholderHelper() {
        throw new UnsupportedOperationException("Can not be instantiated.");
    }

    public static PlaceholderParameter getParameter(View view) {
        if (view == null) {
            return null;
        }
        int placeHolderColor = Color.parseColor("#dddddd");

        switch (view.getId()) {
            case R.id.tv_view_time:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 0))
                        .build();

            case R.id.tv_collect_time:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 0))
                        .build();


            case R.id.tv_price:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 5))
                        .build();

            case R.id.iv_clock:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createOvalDrawable(placeHolderColor))
                        .build();

            case R.id.tv_time:
                Animation timeAnimation = new ScaleAnimation(0.3f, 1, 1, 1);
                timeAnimation.setDuration(600);
                timeAnimation.setRepeatMode(Animation.REVERSE);
                timeAnimation.setRepeatCount(Animation.INFINITE);
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setAnimation(timeAnimation)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 5))
                        .build();

            case R.id.iv_calendar:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createOvalDrawable(placeHolderColor))
                        .build();

            case R.id.iv_location:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createOvalDrawable(placeHolderColor))
                        .build();

            case R.id.tv_location:
                Animation locationAnimation = new ScaleAnimation(0.4f, 1, 1, 1);
                locationAnimation.setDuration(800);
                locationAnimation.setRepeatMode(Animation.REVERSE);
                locationAnimation.setRepeatCount(Animation.INFINITE);
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setAnimation(locationAnimation)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 5))
                        .build();

            case R.id.iv_arrow_right:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createOvalDrawable(placeHolderColor))
                        .build();

            case R.id.iv_logo:
                Animation scaleAnimation = new ScaleAnimation(0.5f, 1f, 0.5f, 1f, Animation.RELATIVE_TO_SELF ,0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(800);
                scaleAnimation.setRepeatMode(Animation.REVERSE);
                scaleAnimation.setRepeatCount(Animation.INFINITE);
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setAnimation(scaleAnimation)
                        .setDrawable(DrawableUtils.createOvalDrawable(placeHolderColor))
                        .build();

            case R.id.tv_organizer_name:
                Animation onAnimation = new ScaleAnimation(0.45f, 1, 1, 1);
                onAnimation.setDuration(550);
                onAnimation.setRepeatMode(Animation.REVERSE);
                onAnimation.setRepeatCount(Animation.INFINITE);

                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setAnimation(onAnimation)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 5))
                        .build();

            case R.id.tv_organizer_description:
                Animation odAnimation = new ScaleAnimation(0.35f, 1, 1, 1);
                odAnimation.setDuration(650);
                odAnimation.setRepeatMode(Animation.REVERSE);
                odAnimation.setRepeatCount(Animation.INFINITE);

                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setAnimation(odAnimation)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 5))
                        .build();

            case R.id.tv_fans:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 0))
                        .build();

            case R.id.tv_fans_number:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 0))
                        .build();

            case R.id.tv_events:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 0))
                        .build();

            case R.id.tv_events_number:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 0))
                        .build();

            case R.id.tv_follow:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 5))
                        .build();

            case R.id.tv_station:
                return new PlaceholderParameter.Builder()
                        .setView(view)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeHolderColor, 5))
                        .build();

        }

        return null;
    }
}
