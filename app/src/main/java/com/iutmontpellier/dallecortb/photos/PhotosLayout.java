package com.iutmontpellier.dallecortb.photos;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.iutmontpellier.dallecortb.tp1ex3.R;

/**
 * Created by dallecortb on 08/01/17.
 */

public class PhotosLayout extends RelativeLayout{

    private final Context       _context;
    private ListView            _listView;
    private PhotosController    _controller;
    private PhotosListAdapter   _adapter;

    public PhotosLayout(Context context, PhotosController photosController) {
        super(context);
        _context     = context;
        _controller  = photosController;
        createUI();
    }

    private void createUI() {
        _adapter   = new PhotosListAdapter(_context);

        View view = inflate(_context, R.layout.activity_image_scroller, this);
        _listView = (ListView)findViewById(R.id.listViewImages);
        _listView.setOnItemClickListener(_adapter);
        _listView.setAdapter(_adapter);



    }

    public void addPhoto(PhotoModel photoModel) {
        _adapter.addItem(photoModel);
    }
}
