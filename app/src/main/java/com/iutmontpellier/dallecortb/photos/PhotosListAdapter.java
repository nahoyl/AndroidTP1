package com.iutmontpellier.dallecortb.photos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iutmontpellier.dallecortb.tp1ex3.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by dallecortb on 07/01/17.
 */

public class PhotosListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener  {

    private ArrayList<PhotoModel>   _photoModelList;
    private Context                 _context;

    public PhotosListAdapter(Context context) {
        _context = context;
        createPhotoModelArrayList();
    }

    private void createPhotoModelArrayList() {
        _photoModelList = new ArrayList<PhotoModel>();
    }

    public void addItem(PhotoModel photoModel) {
        _photoModelList.add(photoModel);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public int getCount() {
        return _photoModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return _photoModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        if (convertView == null) {
            Context context =  parent.getContext();
            view = createItemViewByInflater(context, position);
        }else{
            view = convertView;
        }

        configureItemView(position, view);

        return view;
    }

    /**
     * Configure an ItemView :
     *  - set bitmap to ImageView
     *  - set Texts
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param view        The view we want to configure
     *
     */
    private void configureItemView(int position, View view) {

        TextView textViewPrenom;
        TextView textViewNom;
        TextView textViewSize;
        ImageView imageView;
        Bitmap bitmapImage;
        PhotoModel photoModel = _photoModelList.get(position);

        boolean estUnItemPair = position % 2 == 0;
        if (estUnItemPair){
            view.setBackgroundColor(Color.WHITE);
        }else{
            view.setBackgroundColor(Color.LTGRAY);
        }

        imageView = (ImageView)view.findViewById(R.id.image);
        bitmapImage = photoModel.getThumbBitmap();
        imageView.setImageBitmap(bitmapImage);

        textViewPrenom = (TextView)view.findViewById(R.id.labelPrenom);
        textViewPrenom.setText(photoModel.getName());

        textViewNom = (TextView)view.findViewById(R.id.labelNom);
        textViewNom.setText(photoModel.getName());

        textViewSize = (TextView)view.findViewById(R.id.size);

        if (textViewSize != null) {
            textViewSize.setText(photoModel.getImageSizeString());
        }
    }

    private View createItemViewByInflater(Context context, int position) {
        final View view = View.inflate(context, R.layout.photo_item, null);
        return view;
    }

    @Override
    public int getItemViewType(int position) {return 0;}

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        openInFullScreen((PhotoModel)getItem(position));
    }

    public void openInFullScreen(PhotoModel photoModel){
        String photoName = photoModel.getName();
        Log.i(TAG, "openInFullscreen(" + photoName + ")");
        Intent intent = new Intent(_context, FullscreenPhotoActivity.class);
        intent.putExtra("photoName", photoName);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(intent);
    }

}
