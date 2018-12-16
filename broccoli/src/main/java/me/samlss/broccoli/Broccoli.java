package me.samlss.broccoli;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.samlss.broccoli.util.LogUtil;

/**
 * @author SamLeung
 * @e-mail samlssplus@gmail.com
 * @github https://github.com/samlss
 * @description An Android library that shows the placeholder of the view.
 */
public class Broccoli {
    protected final static int DEFAULT_PLACEHOLDER_COLOR = Color.parseColor("#dddddd");

    private BroccoliInternalImpl mPlaceholderInternalImpl;

    public Broccoli(){
        mPlaceholderInternalImpl = new BroccoliInternalImpl();
    }

    /**
     * Add a array of {@link PlaceholderParameter} to show placeholders for view.
     *
     * @param activity The activity to which the view is attached
     * @param viewIds The view id array.
     * */
    public Broccoli addPlaceholders(Activity activity, int ... viewIds){
        if (activity == null){
            return this;
        }
        addPlaceholders((ViewGroup) activity.findViewById(android.R.id.content), viewIds);
        return this;
    }

    /**
     * Add a array of {@link PlaceholderParameter} to show placeholders for view.
     *
     * @param parent The views' parent.
     * @param viewIds The view id array.
     * */
    public Broccoli addPlaceholders(ViewGroup parent, int ... viewIds){
        if (parent == null
                || viewIds == null){
            return this;
        }

        for (int id : viewIds){
            addPlaceholder(createDefaultParameter(parent.findViewById(id)));
        }

        return this;
    }

    /**
     * Add a array of {@link PlaceholderParameter} to show placeholders for view.
     *
     * @param views The views' that you want to display their placeholder by default.
     * */
    public Broccoli addPlaceholders(View ... views){
        if (views == null){
            return this;
        }

        for (View view : views){
            addPlaceholder(createDefaultParameter(view));
        }

        return this;
    }

    /**
     * Get a default {@link PlaceholderParameter}
     *
     * @param view The view you want to display the placeholder.
     * */
    private PlaceholderParameter createDefaultParameter(View view){
        return new PlaceholderParameter.Builder()
                .setView(view)
                .setColor(DEFAULT_PLACEHOLDER_COLOR)
                .build();
    }

    /**
     * Add a {@link PlaceholderParameter} to show placeholder for view.
     *
     * @param parameter The parameter of the placeholder.
     * */
    public Broccoli addPlaceholder(PlaceholderParameter parameter){
        if (parameter == null
                || parameter.getView() == null){
            LogUtil.logE("If you want to display a placeholder for view, you can't pass a null parameter or view");
            return this;
        }
        mPlaceholderInternalImpl.addPlaceholder(parameter);
        return this;
    }

    /**
     * Add a list of {@link PlaceholderParameter} to show placeholders for view.
     *
     * @param placeholderParameters The placeholderParameter list.
     * */
    public Broccoli addPlaceholder(List<PlaceholderParameter> placeholderParameters){
        if (placeholderParameters == null
                || placeholderParameters.isEmpty()){
            return this;
        }

        for (PlaceholderParameter parameter : placeholderParameters){
            addPlaceholder(parameter);
        }
        return this;
    }

    /**
     * Add a array of {@link PlaceholderParameter} to show placeholders for view.
     *
     * @param placeholderParameters The placeholderParameter array.
     * */
    public Broccoli addPlaceholders(PlaceholderParameter ... placeholderParameters){
        if (placeholderParameters == null
                || placeholderParameters.length == 0){
            return this;
        }

        for (PlaceholderParameter parameter : placeholderParameters){
            addPlaceholder(parameter);
        }
        return this;
    }

    /**
     * Remove the placeholder of view.
     * Will remove the record of the view from {@link Broccoli}.
     * Will restore the state of the view itself, such as view's background, TextView's textColor, ImageView's imageDrawable, etc.
     * @param view The placeholder of the view which needs to be removed.
     * */
    public Broccoli removePlaceholder(View view){
        mPlaceholderInternalImpl.removePlaceholder(view);
        return this;
    }

    /**
     * Will clear the placeholder of view. But unlike {@link #removePlaceholder(View)},
     * clear placeholder just clear the view's placeholder, but will not remove the record of the view from {@link Broccoli}.
     * Will restore the state of the view itself, such as view's background, TextView's textColor, ImageView's imageDrawable, etc.
     * @param view The placeholder of the view which needs to be cleared.
     * */
    public Broccoli clearPlaceholder(View view){
        mPlaceholderInternalImpl.clearPlaceholder(view);
        return this;
    }

    /**
     * Clear & remove all the placeholders for the view you have added.
     * Will restore the state of the view itself, such as view's background, TextView's textColor, ImageView's imageDrawable, etc.
     * If using {@link BroccoliGradientDrawable}, will cancel the gradient animation.
     * */
    public void removeAllPlaceholders(){
        mPlaceholderInternalImpl.hide(true);
    }

    /**
     * Clear all the placeholders for the view you have added.
     * Will restore the state of the view itself, such as view's background, TextView's textColor, ImageView's imageDrawable, etc.
     * If using {@link BroccoliGradientDrawable}, will cancel the gradient animation.
     * */
    public void clearAllPlaceholders(){
        mPlaceholderInternalImpl.hide(false);
    }

    /**
     * Start to show all placeholders for the view you have set.
     * */
    public void show(){
        mPlaceholderInternalImpl.show();
    }
}
