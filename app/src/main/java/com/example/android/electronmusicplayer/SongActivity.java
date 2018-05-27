package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    private static final String POSITION = "position";
    private static final String IMAGE_ID = "imageId";
    private static final String SONG = "song";
    private static final String ALBUM = "album";
    private static final String IDENTITY = "identity";

    private static final int ALBUM_LENGTH = 8;

    final ArrayList<Music> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        Intent intent = getIntent();
        int identity = intent.getIntExtra(IDENTITY, 0);

        // Add a return to previous screen in top left corner
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switch (identity) {
            case 0:
                albumZero();
                break;
            case 1:
                albumOne();
                break;
            case 2:
                albumTwo();
                break;
            case 3:
                albumThree();
                break;
            case 4:
                albumFour();
                break;
            case 5:
                albumFive();
                break;
            case 6:
                albumSix();
                break;
            case 7:
                albumSeven();
                break;
            case 8:
                albumZero();
                albumOne();
                albumTwo();
                albumThree();
                albumFour();
                albumFive();
                albumSix();
                albumSeven();
                for(int i = 0; i < songs.size(); i++) {
                    songs.get(i).setIdentity(8);
                }
                break;
        }

        ListView songList = findViewById(R.id.list);

        SongAdapter songAdapter = new SongAdapter(this, songs);

        songList.setAdapter(songAdapter);

        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int imageId = songs.get(position).getImageId();
                String songTitle = songs.get(position).getMusicTitle();
                String albumTitle = songs.get(position).getMusicDescription();
                int identity = songs.get(position).getIdentity();

                Intent intent = new Intent(SongActivity.this, NowPlayingActivity.class);
                intent.putExtra(POSITION, position);
                intent.putExtra(IMAGE_ID, imageId);
                intent.putExtra(SONG, songTitle);
                intent.putExtra(ALBUM, albumTitle);
                intent.putExtra(IDENTITY, identity);
                startActivity(intent);
            }
        });
    }

    // Return to previous activity
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void albumZero() {
        songs.add(new Music(R.drawable.a_new_beginning,
                getResources().getString(R.string.new_beginning),
                getResources().getString(R.string.bensound_sample_hits), 0));
        songs.add(new Music(R.drawable.creative_mind,
                getResources().getString(R.string.creative_minds),
                getResources().getString(R.string.bensound_sample_hits), 0));
        songs.add(new Music(R.drawable.cute,
                getResources().getString(R.string.cute),
                getResources().getString(R.string.bensound_sample_hits), 0));
        songs.add(new Music(R.drawable.happy_rock,
                getResources().getString(R.string.happy_rock),
                getResources().getString(R.string.bensound_sample_hits), 0));
        songs.add(new Music(R.drawable.jazzy_frenchy,
                getResources().getString(R.string.jazzy_frenchy),
                getResources().getString(R.string.bensound_sample_hits), 0));
        songs.add(new Music(R.drawable.little_idea,
                getResources().getString(R.string.little_idea),
                getResources().getString(R.string.bensound_sample_hits), 0));
        songs.add(new Music(R.drawable.summer,
                getResources().getString(R.string.summer),
                getResources().getString(R.string.bensound_sample_hits), 0));
        songs.add(new Music(R.drawable.ukulele,
                getResources().getString(R.string.ukulele),
                getResources().getString(R.string.bensound_sample_hits), 0));
    }

    private void albumOne() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_one), 1));
        }
    }

    private void albumTwo() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_two,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_two), 2));
        }
    }

    private void albumThree() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_3,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_three), 3));
        }
    }

    private void albumFour() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_four,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_four), 4));
        }
    }

    private void albumFive() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_five,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_five), 5));
        }
    }

    private void albumSix() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_six,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_six), 6));
        }
    }

    private void albumSeven() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_seven,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_seven), 7));
        }
    }
}
