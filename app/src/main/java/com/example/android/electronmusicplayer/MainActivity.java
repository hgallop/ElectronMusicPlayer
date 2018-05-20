package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String ID ="id";
    private final String IMAGE = "imageId";
    private final String SONG = "song";
    private final String ALBUM = "album";

    int identity = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView albums = findViewById(R.id.albums);
        TextView songs = findViewById(R.id.songs);
        TextView playing = findViewById(R.id.playing);

        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(intent);
            }
        });

        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                intent.putExtra(ID, identity);
                startActivity(intent);
            }
        });

        playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int imageId = R.drawable.a_new_beginning;
                String song = getResources().getString(R.string.new_beginning);
                String album = getResources().getString(R.string.bensound_sample_hits);

                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                intent.putExtra(IMAGE, imageId);
                intent.putExtra(SONG, song);
                intent.putExtra(ALBUM, album);
                intent.putExtra(ID, identity);
                startActivity(intent);

            }
        });
    }
}