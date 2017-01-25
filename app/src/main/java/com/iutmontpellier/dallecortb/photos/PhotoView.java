package com.iutmontpellier.dallecortb.photos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.renderscript.Matrix3f;
import android.view.View;

import com.iutmontpellier.dallecortb.tp1ex3.R;

import static com.iutmontpellier.dallecortb.tp1ex3.R.*;

/**
 * Created by dallecortb on 25/01/17.
 */
public class PhotoView extends View
{
    private Bitmap _bmp;
    private Matrix _mat;
    private String _imageName;
    private float _rotation = 0;

    public PhotoView(Context context, Bitmap bmp, String imageName) {
        super(context);
        _bmp = bmp;
        _mat = new Matrix();
        _imageName = imageName;

        centerPicture();
    }

    private void centerPicture() {
        int w, h;
        h = getHeight();
        w = getWidth();

        float dx, dy;

        dx = (float)w/2.0f;
        dy = (float)_bmp.getHeight()/2;

        _mat.setTranslate(dx, dy);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int w, h;
        h = getMeasuredHeight();
        w = getMeasuredWidth();

        Paint pt = new Paint(Paint.ANTI_ALIAS_FLAG);
        pt.setTextSize(12);
        pt.setColor(Color.RED);
        pt.setTextAlign(Paint.Align.CENTER);



        canvas.drawBitmap(_bmp, _mat, pt);



        canvas.drawText(_imageName, w/2, h - 12, pt);
//        invalidate();
    }

}
