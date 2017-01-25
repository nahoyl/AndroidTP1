package com.iutmontpellier.dallecortb.photos;

import android.content.Context;

/**
 * Created by dallecortb on 25/01/17.
 */
public class PhotoGestureController {

    private PhotoView   _photoView;
    private Context     _context;

    public  PhotoGestureController(Context context, PhotoView photoView){
        _context    = context;
        _photoView  = photoView;
    }
}
