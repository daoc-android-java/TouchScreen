package ute.fcii.dsii.touchscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawingView3 extends View {

    Paint paint;
    List<Float> points;

    public DrawingView3(Context context) {
        super(context);

        points = new ArrayList<>();

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float[] fs = new float[points.size()];
        for(int i = 0; i < fs.length; i++) {
            fs[i] = (float) points.get(i);
        }
        canvas.drawPoints(fs, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                int i = event.getActionIndex();
                points.add(event.getX(i));
                points.add(event.getY(i));
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                points.clear();
                break;
        }
        return true;
    }
}
