package com.nure.labdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by igor.bogdanov on 22.05.2017.
 */
public class DrawView extends View {

    private RectF rect;
    private Paint paint;
    private Path path;
    private Path pathDst;
    private Matrix matrix;
    private Canvas canvas;

    private int fillColor;
    private int stockColor;

    public DrawView(Context context) {
        super(context);

        matrix = new Matrix();
        paint = new Paint();
        path = new Path();
        pathDst = new Path();
        rect = new RectF();

        fillColor = Color.RED;
        stockColor = Color.RED;


        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        canvas.drawColor(Color.WHITE);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(fillColor);
        canvas.drawRect(rect, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(stockColor);
        canvas.drawRect(rect, paint);

        /*matrix.reset();
        matrix.setRotate(45, 400, 200);
        matrix.postTranslate(500, 0);
        path.transform(matrix, pathDst);
        paint.setColor(Color.GREEN);
        canvas.drawPath(pathDst, paint);

        matrix.reset();
        matrix.setRotate(45, 400, 200);
        matrix.preTranslate(500, 0);
        path.transform(matrix, pathDst);
        paint.setColor(Color.RED);
        canvas.drawPath(pathDst, paint);*/
    }

    public void createRect(View view) {
        rect.set(300, 100, 500, 300);

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float touchX = motionEvent.getX();
                float touchY = motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("Touching down!");
                        if (rect.contains(touchX, touchY)) {
                            stockColor = Color.BLACK;
                            view.invalidate();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println("Touching up!");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("Sliding your finger around on the screen.");
                        break;
                }
                return true;
            }
            
        });

        view.invalidate();
    }




}
