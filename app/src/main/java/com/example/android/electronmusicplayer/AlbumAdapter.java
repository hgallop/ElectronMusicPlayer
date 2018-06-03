package com.example.android.electronmusicplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Music> {

    //constructor method to create an album adapter object
    AlbumAdapter(Activity context, ArrayList<Music> list){
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //set the album list item view to the value of the view to change
        View albumListItem = convertView;

        //inflates a layout for list items if no layout is already active
        if (albumListItem == null) {
            albumListItem = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }

        //variable that stores the current list item
        Music currentAlbum = getItem(position);

        //access the image view
        ImageView albumCover = albumListItem.findViewById(R.id.album_image);
        //access the title view
        TextView albumTitle = albumListItem.findViewById(R.id.album_title);
        //access the description view
        TextView albumDescription = albumListItem.findViewById(R.id.album_description);
        if (currentAlbum != null) {
            //set the image view for the image resource of the current music item
            albumCover.setImageResource(currentAlbum.getImageId());
            //set the title view for the string resource of the current music item
            albumTitle.setText(currentAlbum.getMusicTitle());
            //set the description view for the string resource of the current music item
            albumDescription.setText(currentAlbum.getMusicDescription());
        }
        //return the current item to display in the list layout
        return albumListItem;

    }
}
