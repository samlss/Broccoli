package me.samlss.broccoli;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description Used to restore the state of the original view when the placeholder is cleared.
 */
class PlaceholderPreStateSaver {
    //for TextView.
    /**
     * This is for {@link android.widget.TextView}, when remove the placeholder of view by calling {@link Broccoli#removePlaceholder(View)}or
     * {@link Broccoli#clearPlaceholder(View)}, will set the text color as {@link #restoredTextColor} to {@link android.widget.TextView}
     * */
    private ColorStateList restoredTextColor;
    private Drawable restoredTextLeftDrawable;
    private Drawable restoredTextTopDrawable;
    private Drawable restoredTextRightDrawable;
    private Drawable restoredTextBottomDrawable;

    //for ImageView.
    /**
     * This is for {@link android.widget.ImageView}, when remove the placeholder of view by calling {@link Broccoli#removePlaceholder(View)} or
     * {@link Broccoli#clearPlaceholder(View)}, will set the text color as {@link #restoredTextColor} to {@link android.widget.TextView}
     * */
    private Drawable restoredImageDrawable;

    //for all views.
    private Drawable restoredBackgroundDrawable;

    public PlaceholderPreStateSaver(){

    }

    protected ColorStateList getRestoredTextColor() {
        return restoredTextColor;
    }

    protected void setRestoredTextColor(ColorStateList restoredTextColor) {
        this.restoredTextColor = restoredTextColor;
    }

    protected Drawable getRestoredTextLeftDrawable() {
        return restoredTextLeftDrawable;
    }

    protected void setRestoredTextLeftDrawable(Drawable restoredTextLeftDrawable) {
        this.restoredTextLeftDrawable = restoredTextLeftDrawable;
    }

    protected Drawable getRestoredTextTopDrawable() {
        return restoredTextTopDrawable;
    }

    protected void setRestoredTextTopDrawable(Drawable restoredTextTopDrawable) {
        this.restoredTextTopDrawable = restoredTextTopDrawable;
    }

    protected Drawable getRestoredTextRightDrawable() {
        return restoredTextRightDrawable;
    }

    protected void setRestoredTextRightDrawable(Drawable restoredTextRightDrawable) {
        this.restoredTextRightDrawable = restoredTextRightDrawable;
    }

    protected Drawable getRestoredTextBottomDrawable() {
        return restoredTextBottomDrawable;
    }

    protected void setRestoredTextBottomDrawable(Drawable restoredTextBottomDrawable) {
        this.restoredTextBottomDrawable = restoredTextBottomDrawable;
    }

    public Drawable getRestoredImageDrawable() {
        return restoredImageDrawable;
    }

    public void setRestoredImageDrawable(Drawable restoredImageDrawable) {
        this.restoredImageDrawable = restoredImageDrawable;
    }

    public Drawable getRestoredBackgroundDrawable() {
        return restoredBackgroundDrawable;
    }

    public void setRestoredBackgroundDrawable(Drawable restoredBackgroundDrawable) {
        this.restoredBackgroundDrawable = restoredBackgroundDrawable;
    }
}
