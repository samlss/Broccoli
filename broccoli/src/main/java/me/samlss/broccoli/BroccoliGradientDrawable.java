package me.samlss.broccoli;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;

import me.samlss.broccoli.util.LogUtil;

/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description The gradient animation drawable class for this library
 */
public class BroccoliGradientDrawable extends ShapeDrawable {
    private int[] mColors;
    private int mNormalColor;
    private int mHighlightColor;
    private int mCanvasWidth;
    private int mCanvasHeight;

    private ValueAnimator valueAnimator ;
    private int mDuration;
    private TimeInterpolator mTimeInterpolator;
    private int mAnimatedValue;

    /**
     *  @param xStartCoordinate The x-coordinate for the start of the gradient line
     *  @param xEndCoordinate The y-coordinate for the start of the gradient line
     * */
    private float xStartCoordinate, xEndCoordinate;
    private Canvas mGradientCanvas;
    private Bitmap mGradientLayer;

    private Canvas mBackgroundCanvas;
    private Bitmap mBackgroundLayer;

    private WeakReference<View> mViewRef;

    /**
     * Construct a rectangle drawable.
     *
     * @param color The color used to fill the shape.
     * @param highlightColor The color of gradient animation.
     * @param radius The radius in pixels of the corners of the rectangle shape.
     * @param duration The duration of the gradient animation.
     * @param timeInterpolator The interpolator of the gradient animation.
     * */
    public BroccoliGradientDrawable(int color, int highlightColor, float radius, int duration,
                                    TimeInterpolator timeInterpolator){
        setShape(getReboundRect(radius));
        init(color, highlightColor, duration, timeInterpolator);
    }

    /**
     * Construct an oval drawable.
     *
     * @param color The color used to fill the shape.
     * @param highlightColor The color of gradient animation.
     * @param duration The duration of the gradient animation.
     * @param timeInterpolator The interpolator of the gradient animation.
     * */
    public BroccoliGradientDrawable(int color, int highlightColor, int duration,
                                    TimeInterpolator timeInterpolator) {
        setShape(getOvalDrawable());
        init(color, highlightColor, duration, timeInterpolator);
    }

    private void init(int color, int highlightColor, int duration,
                      TimeInterpolator timeInterpolator){
        mDuration = duration;
        mTimeInterpolator = timeInterpolator;
        mNormalColor = color;
        mHighlightColor = highlightColor;

        mColors = new int[]{mNormalColor, mHighlightColor, mNormalColor};
    }

    private RoundRectShape getReboundRect(float radius){
        return new RoundRectShape(new float[]{radius, radius, radius, radius, radius, radius, radius, radius},
                null, null);
    }

    private OvalShape getOvalDrawable(){
        return new OvalShape();
    }

    private void setupAnimator(){
        cancelAnimation();
        if (mCanvasWidth == 0
                || mCanvasHeight == 0){
            LogUtil.logE("width and height must be > 0");
            return;
        }

        mGradientLayer = Bitmap.createBitmap(mCanvasWidth, mCanvasHeight, Bitmap.Config.ALPHA_8);
        mGradientCanvas = new Canvas(mGradientLayer);

        mBackgroundLayer = Bitmap.createBitmap(mCanvasWidth, mCanvasHeight, Bitmap.Config.ARGB_8888);
        mBackgroundCanvas = new Canvas(mBackgroundLayer);

        xStartCoordinate = -mCanvasWidth;
        valueAnimator = ValueAnimator.ofInt(-mCanvasWidth, mCanvasWidth);
        valueAnimator.setDuration(mDuration);
        valueAnimator.setInterpolator(mTimeInterpolator);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAnimatedValue = (int) animation.getAnimatedValue();
                invalidateSelf();
            }
        });
        valueAnimator.start();
    }

    @Override
    public void draw(Canvas canvas) {
        if (canvas.getWidth() <= 0
                || canvas.getHeight() <= 0
                || getShape() == null){
            super.draw(canvas);
            return;
        }

        if (mViewRef.get() == null
                || mViewRef.get().getBackground() != this){
            cancelAnimation();
            return;
        }

        if (valueAnimator == null){
            mCanvasWidth  = canvas.getWidth();
            mCanvasHeight = canvas.getHeight();

            setupAnimator();
        }

        getPaint().setColor(mNormalColor);
        getShape().draw(mBackgroundCanvas, getPaint());
        canvas.drawBitmap(mBackgroundLayer, 0, 0, getPaint());

        xStartCoordinate = mAnimatedValue;
        xEndCoordinate = xStartCoordinate + mCanvasWidth;
        getPaint().setShader(new LinearGradient(xStartCoordinate, 0, xEndCoordinate, 0
                , mColors
                , new float[]{0f, 0.4f, 0.8f}
                , Shader.TileMode.CLAMP));
        getShape().draw(mGradientCanvas, getPaint());
        canvas.drawBitmap(mGradientLayer, 0, 0, getPaint());
    }

    /**
     * Attach the view to this drawable.
     *
     * @param view The view which use this drawable.
     * */
    protected void attachedView(View view){
        mViewRef = new WeakReference<>(view);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {

            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                v.removeOnAttachStateChangeListener(this);
                cancelAnimation();
            }
        });
    }

    /**
     * Cancel the gradient animation.
     * */
    public void cancelAnimation(){
        if (valueAnimator != null){
            valueAnimator.cancel();
            valueAnimator = null;
        }

        if (mGradientLayer != null){
            if (!mGradientLayer.isRecycled()){
                mGradientLayer.recycle();
            }

            mGradientLayer = null;
        }

        if (mBackgroundLayer != null){
            if (!mBackgroundLayer.isRecycled()){
                mBackgroundLayer.recycle();
            }

            mGradientLayer = null;
        }
    }
}
