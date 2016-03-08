package com.dreamfactory.widget;
/**
 * Author：kurtishu on 3/8/16
 * Eevery one should have a dream, what if one day it comes true!
 */
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;


/**
 * Class defined custom Pop up window.
 */
public class CustomPopupWindow  extends PopupWindow {

    private Activity activity;
    private View shadowView;

    /**
     * Create a new popup window which can display the contentView.
     * The dimension of the window must be passed to this constructor.</p>
     *
     * The popup does not provide any background. This should be handled
     * by the content view.
     *
     * @param popupWindowContentView the popup's content
     * @param width the popup's width
     * @param height the popup's height
     */
    public CustomPopupWindow (Activity context, View popupWindowContentView,
                              int width, int height) {
        this(context, popupWindowContentView, width, height, false);
    }

    /**
     * Create a new popup window which can display the contentView.
     * The dimension of the window must be passed to this constructor.</p>
     *
     * The popup does not provide any background. This should be handled
     * by the content view.
     *
     * @param popupWindowContentView the popup's content
     * @param width the popup's width
     * @param height the popup's height
     * @param focusable true if the popup can be focused, false otherwise
     */
    public CustomPopupWindow (Activity context, View popupWindowContentView,
                              int width, int height, boolean focusable) {
        super(popupWindowContentView, width, height, focusable);
        this.activity = context;
        setWidth(width);
        setHeight(height);
        setContentView(popupWindowContentView);
        shadowView = new View(context);
        shadowView.setBackgroundColor(context.getResources().getColor(
                R.color.subtransparent));
        ViewGroup view = (ViewGroup) context.getWindow().getDecorView();
        if (null != view) {
            view.addView(shadowView, new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT));
        }
    }

    /**
     * Dispose of the popup window. This method can be invoked only after
     * {@link #showAsDropDown(android.view.View)} has been executed. Failing that, calling
     * this method will have no effect.
     *
     */
    @ Override
    public void dismiss() {
        ViewGroup view = (ViewGroup) activity.getWindow().getDecorView();
        if (null != view) {
            view.removeView(shadowView);
        }
        super.dismiss();
    }
}
