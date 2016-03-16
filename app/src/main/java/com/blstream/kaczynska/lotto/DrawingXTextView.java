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
            paint.setTextSize(100);
            canvas.drawText(tileXText, (super.getWidth()- paint.measureText(tileXText))/2, super.getBaseline(), paint);
        }
    }

    public void drawX() {
        startToDraw = true;
        invalidate();
    }

}
