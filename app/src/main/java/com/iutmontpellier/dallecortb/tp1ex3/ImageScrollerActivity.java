package com.iutmontpellier.dallecortb.tp1ex3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.iutmontpellier.dallecortb.photos.PhotosController;


public class ImageScrollerActivity extends Activity {

    private PhotosController photosController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        View view = findViewById(R.layout.activity_blank);

        String nom      = getIntent().getStringExtra("nom");
        String prenom   = getIntent().getStringExtra("prenom");

        photosController   = new PhotosController(getApplicationContext(), view, nom, prenom);

    }


}
