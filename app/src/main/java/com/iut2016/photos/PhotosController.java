package com.iut2016.photos;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * Created by dallecortb on 09/01/17.
 */

public class PhotosController {

    private String      prenom;
    private String      nom;
    private PhotoModel  photo[];
    private Context     context;

    public PhotosController(Context _context, String _nom, String _prenom){
        prenom  = _prenom;
        nom     = _nom;
        context = _context;
        loadPhotoAssets();
    }

    public int getPhotoCount(){
        return photo.length;
    }

    private void loadPhotoAssets() {
        AssetManager assetManager   = context.getAssets();
        String[]     assetNameList;
        try {
            assetNameList       = assetManager.list("images/galerie");
            photo = new PhotoModel[assetNameList.length];
            for (int i=0; i < assetNameList.length; i++) {
                photo[i] = new PhotoModel("images/galerie/"+assetNameList[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Start a new activity that open an image in fullscreen mode.
     *
     * @param num         The number of the picture in the picture list.
     *
     */
    public void openInFullScreen(int num){
        Log.i(TAG, "openInFullscreen(" + num + ")");
        Intent intent = new Intent(context, FullscreenPhotoActivity.class);
        intent.putExtra("photoName", photo[num].getName());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }

    public Bitmap getThumbBitmap(int num){
        return photo[num].getThumbBitmap();
    }

    public Bitmap getFullscreenBitmap(int num){
        return photo[num].getFullscreenBitmap();
    }

    public String getImageSizeString(int num){
        return photo[num].getImageSizeString();
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Context getContext() {
        return context;
    }
}
