package com.iutmontpellier.dallecortb.photos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.renderscript.Matrix3f;
import android.view.View;

/**
 * Created by dallecortb on 25/01/17.
 */
public class PhotoView extends View
{
    private Bitmap _bmp;
    private Matrix _mat;
    private float _rotation = 0;

    public PhotoView(Context context, Bitmap bmp) {
        super(context);
        _bmp = bmp;
        _mat = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(_bmp, _mat, null);
        _mat.setRotate(2.0f, 0.5f, 0.5f);

        canvas.drawText("Mon image", _bmp.getWidth() / 2, _bmp.getHeight() + 12,null);
        invalidate();
    }

}
