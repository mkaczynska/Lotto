package com.blstream.kaczynska.lotto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class DrawingXTextView extends TextView {

    private final Paint paint = new Paint();
    private final static String tileXText = "X";
    private boolean startToDraw = false;

    public DrawingXTextView(Context context) {
        super(context);
    }

    public DrawingXTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawingXTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        if (startToDraw) {
            paint.setColor(Color.BLUE);
            paint.setTextSize(super.getWidth());
            setCanvasSize(canvas);
            canvas.drawText(tileXText, (super.getWidth() - paint.measureText(tileXText)) / 2, (super.getHeight() + paint.measureText(tileXText)) / 2, paint);
        }
    }

    private void setCanvasSize(Canvas canvas) {
        setWidth(canvas.getWidth());
        setHeight(canvas.getHeight());
    }

    public void drawX() {
        startToDraw = true;
        invalidate();
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec)
    {
        final int width = getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec);
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh)
    {
        super.onSizeChanged(w, w, oldw, oldh);
    }
}


