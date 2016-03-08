package com.dreamfactory.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.dreamfactory.widget.util.PixelsConvertUtil;

/**
 * Author：kurtishu on 3/8/16
 * Eevery one should have a dream, what if one day it comes true!
 */
public class IndicateView extends View {

    // Default item count
    private int totalItems = 5;

    private int currentItemIndex = 1;

    private Paint normalPaint = null;
    private Paint currentPaint = null;
    private int offSet = 0;

    public IndicateView(Context context) {
        super(context);
        init(context);
    }

    public IndicateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IndicateView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < totalItems; i++) {
            if (currentItemIndex == i) {
                canvas.drawPoint(offSet * (i + 1), offSet / 2, currentPaint);
            } else {
                canvas.drawPoint(offSet * (i + 1), offSet / 2, normalPaint);
            }
        }
    }

    private void init(Context context) {
        offSet = PixelsConvertUtil.dip2px(context, 20);
        normalPaint = new Paint();
        normalPaint.setAntiAlias(true);
        normalPaint.setStyle(Paint.Style.STROKE);
        normalPaint.setStrokeWidth(PixelsConvertUtil.dip2px(context, 12));
        normalPaint.setColor(Color.GRAY);
        normalPaint.setStrokeCap(Paint.Cap.ROUND);

        currentPaint = new Paint();
        currentPaint.setAntiAlias(true);
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeWidth(PixelsConvertUtil.dip2px(context, 12));
        currentPaint.setColor(Color.WHITE);
        currentPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setCurrentItem(int currentItemIndex) {
        this.currentItemIndex = currentItemIndex;
        invalidate();
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right,
                            int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((totalItems + 1) * offSet, offSet);
    }
}
