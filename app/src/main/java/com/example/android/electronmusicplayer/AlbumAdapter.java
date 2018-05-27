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

    AlbumAdapter(Activity context, ArrayList<Music> list){
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View albumListItem = convertView;

        if(albumListItem == null){
            albumListItem = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }

        Music currentAlbum = getItem(position);

        ImageView albumCover = albumListItem.findViewById(R.id.album_image);
        assert currentAlbum != null;
        albumCover.setImageResource(currentAlbum.getImageId());

        TextView albumTitle = albumListItem.findViewById(R.id.album_title);
        albumTitle.setText(currentAlbum.getMusicTitle());

        TextView albumDescription = albumListItem.findViewById(R.id.album_description);
        albumDescription.setText(currentAlbum.getMusicDescription());

        return albumListItem;

    }
}
