package me.samlss.broccoli_demo;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description The utils of drawable.
 */
public class DrawableUtils {
    private DrawableUtils(){
        throw new UnsupportedOperationException("Can not be instantiated.");
    }

    public static GradientDrawable createRectangleDrawable(int color, float cornerRadius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadius(cornerRadius);
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static GradientDrawable createRectangleDrawable(int[] colors, float cornerRadius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadius(cornerRadius);
        gradientDrawable.setColors(colors);
        return gradientDrawable;
    }

    public static GradientDrawable createOvalDrawable(int color) {
        GradientDrawable gradientDrawable =  new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static GradientDrawable createOvalDrawable(int[] colors) {
        GradientDrawable gradientDrawable =  new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColors(colors);
        return gradientDrawable;
    }
}
