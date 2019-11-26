package com.example.customviewsb;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CircleBudgetLayout extends View {

    final Paint CIRCL_PAINT = new Paint(Paint.ANTI_ALIAS_FLAG);
    final Paint CIRCL_PAINT_UP = new Paint(Paint.ANTI_ALIAS_FLAG);
    final Paint TEXT_PAIN = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final float STROKE_WIDTH = 50f;
    private static final float RADIUS = 400f;
    final RectF rectF = new RectF(STROKE_WIDTH/2,STROKE_WIDTH/2,2*RADIUS, 2*RADIUS);
    final RectF rectFup = new RectF(STROKE_WIDTH/2,STROKE_WIDTH/2,2*RADIUS, 2*RADIUS);

    private int mProgress = 0;

    public int getmProgress() {
        return mProgress;
    }

    public void setmProgress(int mProgress) {
        this.mProgress = mProgress;
    }

    public CircleBudgetLayout(Context context) {
        this(context, null, 0);
    }

    public CircleBudgetLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public CircleBudgetLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(atr);
    }

    public CircleBudgetLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(rectF, 0, 360,false,CIRCL_PAINT);
        canvas.drawArc(rectF, 0,45, false, CIRCL_PAINT_UP);
        canvas.drawLine(0,RADIUS,RADIUS*2,RADIUS,TEXT_PAIN);
        //canvas.drawLine(RADIUS,0,RADIUS*2,RADIUS,TEXT_PAIN);
        final String text = String.format("%d %%", mProgress);
        final float mesuretext = TEXT_PAIN.measureText(text);
        canvas.drawText(text, RADIUS, RADIUS, TEXT_PAIN);
    }

    public void drawText(){

    }

    private void extractAttr(Context context, AttributeSet attributeSet){
        final Resources.Theme theme = context.getTheme();
        final TypedArray typedArray = theme.obtainStyledAttributes(attr, )
    }

    private void init(AttributeSet attributeSet) {

        CIRCL_PAINT.setColor(Color.GRAY);
        CIRCL_PAINT.setStyle(Paint.Style.STROKE);
        CIRCL_PAINT.setStrokeWidth(STROKE_WIDTH);

        CIRCL_PAINT_UP.setColor(Color.RED);
        CIRCL_PAINT_UP.setStyle(Paint.Style.STROKE);
        CIRCL_PAINT_UP.setStrokeWidth(STROKE_WIDTH);

        TEXT_PAIN.setColor(Color.GREEN);
        TEXT_PAIN.setStyle(Paint.Style.FILL);
        TEXT_PAIN.setTextSize(128);
    }
}
