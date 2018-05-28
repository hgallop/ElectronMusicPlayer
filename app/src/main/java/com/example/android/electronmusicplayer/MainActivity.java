package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //keys for sending intent
    private final static String IDENTITY ="identity";
    private final static String IMAGE_ID = "imageId";
    private final static String SONG = "song";
    private final static String ALBUM = "album";

    //create variable to identify navigation from home screen
    private final static int identity = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize views
        final TextView allAlbums = findViewById(R.id.albums);
        final TextView allSongs = findViewById(R.id.songs);
        final TextView nowPlaying = findViewById(R.id.now_playing);

        //when albums is clicked launch albums activity
        allAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(intent);
            }
        });

        //when songs clicked start song activity, add identity as an extra to indicate songs was accessed from main page
        allSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                intent.putExtra(IDENTITY, identity);
                startActivity(intent);
            }
        });

        //when songs is clicked send along the data for the first song of the first album to display, send identity to indicate that songs is accessed from main page
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //information for first song
                int imageId = R.drawable.a_new_beginning;
                String song = getResources().getString(R.string.new_beginning);
                String album = getResources().getString(R.string.bensound_sample_hits);

                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                intent.putExtra(IMAGE_ID, imageId);
                intent.putExtra(SONG, song);
                intent.putExtra(ALBUM, album);
                intent.putExtra(IDENTITY, identity);
                startActivity(intent);

            }
        });
    }
}