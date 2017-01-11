package com.iutmontpellier.dallecortb.tp1ex3;

import android.app.Activity;
import android.os.Bundle;

import com.iutmontpellier.dallecortb.photos.PhotosController;


public class ImageScrollerActivity extends Activity {

    private PhotosController photosController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String nom      = getIntent().getStringExtra("nom");
        String prenom   = getIntent().getStringExtra("prenom");

        photosController   = new PhotosController(getApplicationContext(), nom, prenom);

    }


}
