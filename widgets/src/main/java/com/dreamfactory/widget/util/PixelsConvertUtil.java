package com.dreamfactory.widget.util;

/**
 * Author：kurtishu on 3/8/16
 * Eevery one should have a dream, what if one day it comes true!
 */

import android.content.Context;

/**
 * This class provide the way to convert dip to pixels and pixels to dip.
 *
 */
public final class PixelsConvertUtil {

    /**
     * Convert dip to pixels.
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = 1;
        if (context != null) {
            scale = context.getResources().getDisplayMetrics().density;
        }
        return (int) (dpValue * scale + 0.5f);
    }


    /**
     * Convert pixels to dip.
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, double pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * Utility classes should not have a public or default constructor.
     */
    private PixelsConvertUtil() {

    }
}
