package me.samlss.broccoli;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;

/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description The parameter of placeholder
 */
public class PlaceholderParameter {
    private int color;
    private int colorRes;
    private Drawable drawable;
    private int drawableRes;

    private Animation animation;
    private View view;
    private PlaceholderPreStateSaver placeholderPreStateSaver;

    private PlaceholderParameter(){
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColorRes() {
        return colorRes;
    }

    public void setColorRes(int colorRes) {
        this.colorRes = colorRes;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    protected void setPlaceholderPreStateSaver(PlaceholderPreStateSaver placeholderPreStateSaver) {
        this.placeholderPreStateSaver = placeholderPreStateSaver;
    }

    protected PlaceholderPreStateSaver getPlaceholderPreStateSaver() {
        return placeholderPreStateSaver;
    }

    public static class Builder{
        private PlaceholderParameter mPlaceholderParameter;

        public Builder(){
            mPlaceholderParameter = new PlaceholderParameter();
        }

        /**
         * Set the view which you want to display placeholder.
         * */
        public Builder setView(View view) {
            mPlaceholderParameter.view = view;
            return this;
        }

        /**
         * Set the color of the placeholder.
         *
         * @param color The color value.
         * */
        public Builder setColor(int color){
            mPlaceholderParameter.setColor(color);
            return this;
        }

        /**
         * Set the color of the placeholder.
         *
         * @param colorRes The color resource id.
         * */
        public Builder setColorRes(int colorRes){
            mPlaceholderParameter.setColorRes(colorRes);
            return this;
        }

        /**
         * Set the drawable of the placeholder.
         *
         * @param drawable The drawable.
         * */
        public Builder setDrawable(Drawable drawable) {
            mPlaceholderParameter.drawable = drawable;
            return this;
        }

        /**
         * Set the drawable of the placeholder.
         *
         * @param drawableRes The drawable resource id.
         * */
        public Builder setDrawableRes(int drawableRes) {
            mPlaceholderParameter.drawableRes = drawableRes;
            return this;
        }

        public Builder setAnimation(Animation animation){
            mPlaceholderParameter.animation = animation;
            return this;
        }

        /**
         * Now build a {@link PlaceholderParameter}
         * */
        public PlaceholderParameter build(){
            return mPlaceholderParameter;
        }
    }
}
