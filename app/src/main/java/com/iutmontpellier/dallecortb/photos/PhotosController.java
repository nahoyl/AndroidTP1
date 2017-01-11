package com.iutmontpellier.dallecortb.photos;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;

/**
 * Created by dallecortb on 09/01/17.
 */

public class PhotosController {

    private String          _prenom;
    private String          _nom;
    private Context         _context;
    private PhotosLayout    _photoLayout;

    public PhotosController(Context context, String nom, String prenom){

        _prenom         = prenom;
        _nom            = nom;
        _context        = context;
        _photoLayout    = new PhotosLayout(context, this);

        loadPhotoAssets();
    }


    private void loadPhotoAssets() {
        AssetManager assetManager   = _context.getAssets();
        String[]     assetNameList;
        try {
            assetNameList       = assetManager.list("images/galerie");

            for (int i=0; i < assetNameList.length; i++) {
                PhotoModel photoModel = new PhotoModel("images/galerie/"+assetNameList[i]);
                _photoLayout.addPhoto(photoModel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String get_prenom() {
        return _prenom;
    }

    public String get_nom() {
        return _nom;
    }

    public Context get_context() {
        return _context;
    }
}
