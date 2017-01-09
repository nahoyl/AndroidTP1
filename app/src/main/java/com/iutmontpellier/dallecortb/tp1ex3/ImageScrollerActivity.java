package com.iutmontpellier.dallecortb.tp1ex3;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class ImageScrollerActivity extends Activity {

    private String      prenom;
    private String      nom;
    private PhotoModel photo[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getStringExtrasFromIntent();
        loadPhotoAssets();
        createView();
    }

    private void createView() {
        setContentView(R.layout.activity_image_scroller);
        ListView listView               = (ListView) findViewById(R.id.listViewImages);
        ListViewImagesAdapter adapter   = new ListViewImagesAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter);
    }

    private void getStringExtrasFromIntent() {
        Intent intent = getIntent();
        prenom  = intent.getStringExtra(MainActivity.PRENOM);
        nom     = intent.getStringExtra(MainActivity.NOM);
    }

    public int getPhotoCount(){
        return photo.length;
    }

    private void loadPhotoAssets() {
        AssetManager assetManager   = getApplicationContext().getAssets();
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
        Intent intent = new Intent(getApplicationContext(), FullscreenPictureActivity.class);
        intent.putExtra("imageNum", num );
        startActivity(intent);
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

}
