package com.iutmontpellier.dallecortb.photos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.renderscript.Matrix3f;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;
import static com.iutmontpellier.dallecortb.tp1ex3.R.*;

/**
 * Created by dallecortb on 25/01/17.
 */
public class PhotoView extends View
{
    private final static String TAG = "PhotoView";
    private Bitmap _bitmap;
    private Matrix _matrix;
    private String _imageName;
    private float _rotation = 0;
    private Paint _paint;
    private float _focusX, _focusY;
    private float _scaleX, _scaleY;
    private boolean _firstDraw = true;

    public PhotoView(Context context, Bitmap bmp, String imageName) {
        super(context);
        _bitmap     = bmp;
        _matrix     = new Matrix();
        _imageName  = imageName;
        _paint      = new Paint(Paint.ANTI_ALIAS_FLAG);
        _scaleX     = 1;
        _scaleY     = 1;
    }

    private void centerPicture(Canvas canvas) {

        float h = getMeasuredHeight();
        float w = getMeasuredWidth();

        float imgHeight   = _bitmap.getScaledHeight(canvas);
        float imgWidth    = _bitmap.getScaledWidth(canvas);

        float dx = w/2.0f - imgWidth /2.0f;
        float dy = h/2.0f - imgHeight/2.0f;

        _matrix.setTranslate(dx, dy);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw...");

        if (_firstDraw) {
            centerPicture(canvas);
            _firstDraw = false;
        }
        canvas.drawBitmap(_bitmap, _matrix, null);
        drawBottomText(canvas);
    }

    private void drawBottomText(Canvas canvas) {

        int viewWidth, viewHeight;
        viewHeight = getMeasuredHeight();
        viewWidth = getMeasuredWidth();
        float textSize = getResources().getDimension(dimen.size12dp);
        _paint.setTextSize(textSize);
        _paint.setColor(Color.RED);
        _paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(_imageName, viewWidth/2, viewHeight - textSize, _paint);
    }

    public void onScale(float scaleFactor) {

        Log.d(TAG, "onScale - factor = " + scaleFactor + ", scaleX="+_scaleX+", scaleY="+_scaleY+", focuxX="+_focusX+", focusY="+_focusY);
        _matrix.postScale(_scaleX * scaleFactor, _scaleY * scaleFactor, _focusX, _focusY);
        invalidate();
    }

    public void onScaleBegin(float focusX, float focusY) {
        _focusX = focusX;
        _focusY = focusY;
    }

    public void onScroll(float distanceX, float distanceY) {

        _matrix.postTranslate(- distanceX, - distanceY);

        invalidate();
    }
}
