package ute.fcii.dsii.touchscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView extends View {

    Paint paint;
    Paint bGround;
    float x;
    float y;
    int blue = 255;

    public DrawingView(Context context) {
        super(context);

        paint = new Paint();
        paint.setARGB(255, 0, 255, 0);
        bGround = new Paint();
        bGround.setARGB(0, 0, 0, blue);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(bGround);
        canvas.drawCircle(x, y, 20, paint);
        blue -= 20;
        bGround.setARGB(0, 0, 0, blue);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()) {
            case (MotionEvent.ACTION_DOWN):
                x = event.getX();
                y = event.getY();
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }
}
