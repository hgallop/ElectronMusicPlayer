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

    //constructor method to create a song adapter object
    SongAdapter(Activity context, ArrayList<Music> list){
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //set the song list item view to the value of the view to change
        View songListItem = convertView;

        //inflates a layout for list items if no layout is already active
        if (songListItem == null) {
            songListItem = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        //variable that stores the current list item
        Music currentSong = getItem(position);

       //access and set the image view for the image resource of the current music item
        ImageView songArt = songListItem.findViewById(R.id.song_image);
        assert currentSong != null;
        songArt.setImageResource(currentSong.getImageId());

        //access and set the title view for the string resource of the current music item
        TextView songTitle = songListItem.findViewById(R.id.song_title);
        songTitle.setText(currentSong.getMusicTitle());

        //access and set the album title view for the string resource of the current music item
        TextView songAlbum = songListItem.findViewById(R.id.song_album);
        songAlbum.setText(currentSong.getMusicDescription());

        //return the current item to display in the list layout
        return songListItem;
    }
}
