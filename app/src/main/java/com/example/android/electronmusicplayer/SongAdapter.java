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

public class SongAdapter extends ArrayAdapter<Music> {

    SongAdapter(Activity context, ArrayList<Music> list){
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View songListItem = convertView;

        if (songListItem == null) {
            songListItem = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        Music currentMusic = getItem(position);

        ImageView songArt = songListItem.findViewById(R.id.song_image);
        songArt.setImageResource(currentMusic.getImageId());

        TextView songTitle = songListItem.findViewById(R.id.song_title);
        songTitle.setText(currentMusic.getMusicTitle());

        TextView songAlbum = songListItem.findViewById(R.id.song_album);
        songAlbum.setText(currentMusic.getMusicDescription());

        return songListItem;
    }
}
