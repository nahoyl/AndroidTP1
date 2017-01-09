package com.iutmontpellier.dallecortb.tp1ex3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.iut2016.photos.PhotosController;
import com.iut2016.photos.PhotosLayout;

public class ImageScrollerActivity extends Activity {

    private PhotosController photosController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String nom      = getIntent().getStringExtra("nom");
        String prenom   = getIntent().getStringExtra("prenom");

        photosController   = new PhotosController(getApplicationContext(), nom, prenom);
        View photosLayout  = new PhotosLayout(getApplicationContext(), photosController);
        setContentView(photosLayout);
    }


}
