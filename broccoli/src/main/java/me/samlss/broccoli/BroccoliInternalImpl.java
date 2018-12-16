package me.samlss.broccoli;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import me.samlss.broccoli.util.Utils;

/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description  Mainly responsible for the show the all the placeholder of views.
 */
class BroccoliInternalImpl {
    private Map<View, PlaceholderParameter> mPlaceholderViewMap;

    public BroccoliInternalImpl() {
        synchronizedMap();
    }

    private void synchronizedMap(){
        mPlaceholderViewMap = Collections.synchronizedMap(new HashMap<View, PlaceholderParameter>());
    }

    /**
     * Add a placeholder for view.
     *
     * @param parameter The parameter of the placeholder.
     * */
    protected void addPlaceholder(PlaceholderParameter parameter){
        if (mPlaceholderViewMap == null){
            synchronizedMap();
        }

        mPlaceholderViewMap.put(parameter.getView(), parameter);
    }

    /**
     * Remove the placeholder of view.
     *
     * @param view The placeholder of the view which needs to be removed.
     * */
    protected void removePlaceholder(View view){
        if (mPlaceholderViewMap == null){
            return;
        }

        if (mPlaceholderViewMap.containsKey(view)){
            clearPlaceholder(view);
            mPlaceholderViewMap.remove(view);
        }
    }

    protected void clearPlaceholder(View view){
        PlaceholderParameter parameter = mPlaceholderViewMap.get(view);
        if (view == null
                || parameter == null){
            return;
        }

        view.clearAnimation();

        if (view.getBackground() != null
                && view.getBackground() instanceof BroccoliGradientDrawable){
            ((BroccoliGradientDrawable)view.getBackground()).cancelAnimation();
        }

        if (view instanceof TextView){
            restoreTextViewState((TextView) view, parameter.getPlaceholderPreStateSaver());
        }else if (view instanceof  ImageView){
            restoreImageState((ImageView) view, parameter.getPlaceholderPreStateSaver());
        }

        restoreBackgroundState(view, parameter.getPlaceholderPreStateSaver());
    }

    private void restoreTextViewState(TextView textView, PlaceholderPreStateSaver stateSaver){
        if (textView == null
            || stateSaver == null){
            return;
        }

        textView.setTextColor(stateSaver.getRestoredTextColor());
        textView.setCompoundDrawables(stateSaver.getRestoredTextLeftDrawable(),
                stateSaver.getRestoredTextTopDrawable(),
                stateSaver.getRestoredTextRightDrawable(),
                stateSaver.getRestoredTextBottomDrawable());
    }

    private void restoreImageState(ImageView imageView, PlaceholderPreStateSaver stateSaver){
        if (imageView == null
                || stateSaver == null){
            return;
        }

        imageView.setImageDrawable(stateSaver.getRestoredImageDrawable());
        Utils.setBackgroundDrawable(imageView, stateSaver.getRestoredBackgroundDrawable());
    }

    private void restoreBackgroundState(View view, PlaceholderPreStateSaver stateSaver){
        if (view == null
                || stateSaver == null){
            return;
        }

        Utils.setBackgroundDrawable(view, stateSaver.getRestoredBackgroundDrawable());
    }

    /**
     * Start to show all placeholders for the view you have set.
     * */
    protected void show(){
        if (mPlaceholderViewMap == null
                || mPlaceholderViewMap.isEmpty()){
            return;
        }

        for (PlaceholderParameter parameter : mPlaceholderViewMap.values()){
            showPlaceholder(parameter);
            showPlaceholderAnimation(parameter);
            showPlaceholderGradientDrawableAnimation(parameter);
        }
    }

    private void showPlaceholderGradientDrawableAnimation(PlaceholderParameter parameter){
        if (parameter == null
                || parameter.getView() == null
                || parameter.getView().getBackground() == null
                || parameter.getView().getBackground() instanceof BroccoliGradientDrawable == false){
            return;
        }

        ((BroccoliGradientDrawable)parameter.getView().getBackground()).attachedView(parameter.getView());
    }

    protected void hide(boolean removed){
        if (mPlaceholderViewMap == null
                || mPlaceholderViewMap.isEmpty()){
            return;
        }
        for (View view : mPlaceholderViewMap.keySet()) {
            clearPlaceholder(view);
        }

        if (removed) {
            mPlaceholderViewMap.clear();
        }
    }

    private PlaceholderPreStateSaver getOrNewPreStateSaver(PlaceholderParameter parameter){
        PlaceholderPreStateSaver placeholderPreStateSaver = parameter.getPlaceholderPreStateSaver();
        if (placeholderPreStateSaver == null){
            placeholderPreStateSaver = new PlaceholderPreStateSaver();
            parameter.setPlaceholderPreStateSaver(placeholderPreStateSaver);
        }

        return placeholderPreStateSaver;
    }

    private void recordTextViewOriginalState(TextView textView, PlaceholderParameter parameter){
        if (textView == null
                || parameter == null)
            return;

        PlaceholderPreStateSaver  placeholderPreStateSaver = getOrNewPreStateSaver(parameter);

        Drawable[] drawables = textView.getCompoundDrawables();
        placeholderPreStateSaver.setRestoredTextLeftDrawable(drawables[0]);
        placeholderPreStateSaver.setRestoredTextTopDrawable(drawables[1]);
        placeholderPreStateSaver.setRestoredTextRightDrawable(drawables[2]);
        placeholderPreStateSaver.setRestoredTextBottomDrawable(drawables[3]);

        placeholderPreStateSaver.setRestoredTextColor(textView.getTextColors());
        placeholderPreStateSaver.setRestoredBackgroundDrawable(textView.getBackground());

        textView.setCompoundDrawables(null, null, null, null);
        textView.setTextColor(Color.TRANSPARENT);
    }

    private void recordImageViewOriginalState(ImageView imageView, PlaceholderParameter parameter){
        if (imageView == null
                || parameter == null)
            return;

        PlaceholderPreStateSaver placeholderPreStateSaver = getOrNewPreStateSaver(parameter);
        placeholderPreStateSaver.setRestoredImageDrawable(imageView.getDrawable());

        imageView.setImageDrawable(null);
        Utils.setBackgroundDrawable(imageView, null);
    }

    private void recordBackgroundState(View view, PlaceholderParameter parameter){
        if (view == null
                || parameter == null)
            return;

        PlaceholderPreStateSaver  placeholderPreStateSaver = getOrNewPreStateSaver(parameter);
        placeholderPreStateSaver.setRestoredBackgroundDrawable(view.getBackground());
    }

    private void showPlaceholder(PlaceholderParameter parameter){
        if (parameter.getView() == null
                || parameter == null){
            return;
        }
        View view = parameter.getView();


        if (view instanceof ImageView){
            recordImageViewOriginalState((ImageView) view, parameter);
        } else if(view instanceof TextView){
            recordTextViewOriginalState((TextView) view, parameter);
        }

        recordBackgroundState(view, parameter);

        if (parameter.getDrawable() != null) {
            Utils.setBackgroundDrawable(view, parameter.getDrawable());
            return;
        }

        if (parameter.getDrawableRes() != 0){
            Utils.setBackgroundDrawable(view, Utils.getDrawable(view, parameter.getDrawableRes()));
            return;
        }

        if (parameter.getColor() != 0){
            view.setBackgroundColor(parameter.getColor());
            return;
        }

        if (parameter.getColorRes() != 0){
            view.setBackgroundColor(Utils.getColor(view, parameter.getColorRes()));
            return;
        }

        view.setBackgroundColor(Broccoli.DEFAULT_PLACEHOLDER_COLOR);
    }

    private void showPlaceholderAnimation(PlaceholderParameter parameter){
        if (parameter == null
                || parameter.getView() == null
                || parameter.getAnimation() == null){
            return;
        }

        parameter.getView().startAnimation(parameter.getAnimation());
    }
}
