package com.iutmontpellier.dallecortb.photos;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.iutmontpellier.dallecortb.tp1ex3.MainActivity;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dallecortb on 09/01/17.
 */
public class PhotoModel {


    private static final String TAG = "PhotoModel";
    String name;
    Bitmap thumbBitmap;
    Bitmap largeBitmap;
    private int size;

    PhotoModel(String photoName){
        name = photoName;
        thumbBitmap = null;
        largeBitmap = null;
    }

    public String getName() {
        return name;
    }

    public Bitmap getBitmap(int desiratedHeight){

        Log.i(TAG, "getBitmap()");

        Bitmap bitmap = null;
        Log.i(TAG, "getBitmap() - First generation of the bitmap...");
        AssetManager assetManager = MainActivity.getContext().getAssets();

        InputStream inputStream = null;

        try {
            inputStream = assetManager.open(name);
            size = inputStream.available();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
            options.inSampleSize = getSampleSizeToFitThumbSize(options, desiratedHeight);

            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
            Log.i(TAG, "getBitmap() - First generation done !");
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    private int getSampleSizeToFitThumbSize(BitmapFactory.Options options, int desiratedHeight) {
        return options.outHeight / desiratedHeight;
    }

    public String getImageSizeString() {
        String str = size/1024 +" Ko";
        return str;
    }

    public Bitmap getThumbBitmap(){
        if (thumbBitmap == null){
            thumbBitmap = getBitmap(80);
        }
        return thumbBitmap;
    }
    public Bitmap getFullscreenBitmap() {
        if (largeBitmap == null){
            largeBitmap = getBitmap(500);
        }
        return largeBitmap;
    }
}
