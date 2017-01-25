package com.iutmontpellier.dallecortb.tp1ex3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.iutmontpellier.dallecortb.photos.PhotosController;

import java.util.zip.Inflater;


public class ImageScrollerActivity extends Activity {

    private PhotosController photosController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View contentView = View.inflate(this, R.layout.activity_blank, null);
        setContentView(contentView);


        String nom      = getIntent().getStringExtra("nom");
        String prenom   = getIntent().getStringExtra("prenom");

        photosController   = new PhotosController(this, (ViewGroup)contentView, nom, prenom);

    }


}
