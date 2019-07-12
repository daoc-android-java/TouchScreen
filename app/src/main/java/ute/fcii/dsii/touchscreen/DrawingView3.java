package ute.fcii.dsii.touchscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView3 extends View {

    Paint paint1;
    Paint paint2;
    float x1;
    float y1;
    float x2;
    float y2;

    public DrawingView3(Context context) {
        super(context);

        x1 = y1 = x2 = y2 = 0;

        paint1 = new Paint();
        paint2 = new Paint();

        paint1.setColor(Color.GREEN);
        paint2.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x1, y1, 20, paint1);
        canvas.drawCircle(x2, y2, 20, paint2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int i = event.getActionIndex();
        if(i > 1) return false;
        if(i == 0) {
            x1 = event.getX(0);
            y1 = event.getY(0);
        }
        if(i == 1) {
            x2 = event.getX(1);
            y2 = event.getY(1);
        }
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                invalidate();
                break;
        }
        return true;
    }
}
