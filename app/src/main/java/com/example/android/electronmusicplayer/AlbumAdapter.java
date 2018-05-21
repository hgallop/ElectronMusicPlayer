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
        View musicListItem = convertView;

        if(musicListItem == null){
            musicListItem = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }

        Music currentMusic = getItem(position);

        ImageView albumCover = musicListItem.findViewById(R.id.album_image);
        assert currentMusic != null;
        albumCover.setImageResource(currentMusic.getImageId());

        TextView albumTitle = musicListItem.findViewById(R.id.album_title);
        albumTitle.setText(currentMusic.getMusicTitle());

        TextView albumDescription = musicListItem.findViewById(R.id.album_description);
        albumDescription.setText(currentMusic.getMusicDescription());

        return musicListItem;

    }
}
