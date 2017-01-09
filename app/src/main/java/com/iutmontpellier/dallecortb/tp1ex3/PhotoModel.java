package com.iutmontpellier.dallecortb.tp1ex3;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.util.Log;

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
    }

    public String getName() {
        return name;
    }

    public Bitmap getBitmap(int desiratedHeight){

        Log.i(TAG, "getThumbBitmap()");

        Bitmap bitmap;
        Log.i(TAG, "getThumbBitmap() - First generation of the bitmap...");
        AssetManager assetManager = MainActivity.getContext().getAssets();

        InputStream inputStream = null;

        try {
            inputStream = assetManager.open(name);
            size = inputStream.available();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        options.inSampleSize = getSampleSizeToFitThumbSize(options, desiratedHeight);

        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeStream(inputStream, null, options);
        Log.i(TAG, "getThumbBitmap() - First generation done !");

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
        if (thumbBitmap != null){
            thumbBitmap = getBitmap(80);
        }
        return thumbBitmap;
    }
    public Bitmap getFullscreenBitmap() {
        if (largeBitmap != null){
            largeBitmap = getBitmap(500);
        }
        return largeBitmap;
    }
}
