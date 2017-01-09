package com.iut2016.photos;

import android.content.Context;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.iutmontpellier.dallecortb.tp1ex3.R;

/**
 * Created by dallecortb on 08/01/17.
 */

public class PhotosLayout extends RelativeLayout {
    public PhotosLayout(Context context, PhotosController controller) {

        super(context);

        inflate(context, R.layout.activity_image_scroller,this);
        ListView listView = (ListView) findViewById(R.id.listViewImages);

        PhotosListAdapter adapter   = new PhotosListAdapter(controller);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(adapter);
    }
}
