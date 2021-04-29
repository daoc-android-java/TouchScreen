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
    int blue2white;

    public DrawingView(Context context) {
        super(context);

        x = 0;
        y = 0;

        paint = new Paint();
        paint.setARGB(255, 0, 255, 0);

        blue2white = 0;
        bGround = new Paint();
        bGround.setARGB(255, blue2white, blue2white, 255);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(bGround);
        canvas.drawCircle(x, y, 20, paint);
        blue2white = (blue2white + 20) % 255;
        bGround.setARGB(255, blue2white, blue2white, 255);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getActionMasked()) {
            case (MotionEvent.ACTION_DOWN):
                x = event.getX();
                y = event.getY();
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }
}
