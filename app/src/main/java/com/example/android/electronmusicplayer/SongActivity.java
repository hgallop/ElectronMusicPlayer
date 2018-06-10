package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    //keys for save/restore and retrieving intent extra
    private static final String POSITION = "position";
    private static final String IMAGE_ID = "imageId";
    private static final String SONG = "song";
    private static final String ALBUM = "album";
    private static final String IDENTITY = "identity";

    //variable to store an arbitrary album length
    private static final int ALBUM_LENGTH = 8;

    int identity;

    //creates an array list of music objects for each song
    final ArrayList<Music> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        //receives the information sent along from other activities
        Intent intent = getIntent();
        identity = intent.getIntExtra(IDENTITY, 0);

        // Add a return to previous screen in top left corner
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //switch statement uses identity to create needed songs array list(s) by calling the correct helper method for each album
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
                //resets the identity of each song in the list to 8 in order to send the identity to the next activity
                for(int i = 0; i < songs.size(); i++) {
                    songs.get(i).setIdentity(9);
                }
                break;
            case 9:
                albumZero();
                albumOne();
                albumTwo();
                albumThree();
                albumFour();
                albumFive();
                albumSix();
                albumSeven();
                //resets the identity of each song in the list to 8 in order to send the identity to the next activity
                for(int i = 0; i < songs.size(); i++) {
                    songs.get(i).setIdentity(9);
                }
                break;
        }

        //access the list layout
        ListView songList = findViewById(R.id.list);

        //create custom adapter object to handle displaying the array list to the layout
        SongAdapter songAdapter = new SongAdapter(this, songs);

        //connect adapter to the list layout
        songList.setAdapter(songAdapter);

        //set a click listener on each array list item displayed
        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //store information from the array list item clicked
                int imageId = songs.get(position).getImageId();
                String songTitle = songs.get(position).getMusicTitle();
                String albumTitle = songs.get(position).getMusicDescription();
                int identity = songs.get(position).getIdentity();

                //create an intent to start the now playing activity, send along values of item clicked, flag activity to recall now playing activity to the top if it already exists
                Intent intent = new Intent(SongActivity.this, NowPlayingActivity.class);
                intent.putExtra(POSITION, position);
                intent.putExtra(IMAGE_ID, imageId);
                intent.putExtra(SONG, songTitle);
                intent.putExtra(ALBUM, albumTitle);
                intent.putExtra(IDENTITY, identity);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    //save app data upon change
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(IDENTITY, identity);
    }

    //restore app data
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        identity = savedInstanceState.getInt(IDENTITY);
    }

    // Return to previous activity
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    //helper method to create an array of music objects to represent all the songs on the album in the 0th position of the albums array list from the album activity
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

    //helper method to create an array of music objects to represent all the songs on the album in the 1st position of the albums array list from the album activity.
    private void albumOne() {
        //creates the array with a loop since identical dummy data is being applied to each position of this array list
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_one), 1));
        }
    }

    //helper method to create an array of music objects to represent all the songs on the album in the 2nd position of the albums array list from the album activity.
    private void albumTwo() {
        //creates the array with a loop since identical dummy data is being applied to each position of this array list
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_two,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_two), 2));
        }
    }

    //helper method to create an array of music objects to represent all the songs on the album in the 3rd position of the albums array list from the album activity.
    private void albumThree() {
        //creates the array with a loop since identical dummy data is being applied to each position of this array list
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_3,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_three), 3));
        }
    }

    //helper method to create an array of music objects to represent all the songs on the album in the 4th position of the albums array list from the album activity.
    private void albumFour() {
        //creates the array with a loop since identical dummy data is being applied to each position of this array list
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_four,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_four), 4));
        }
    }

    //helper method to create an array of music objects to represent all the songs on the album in the 5th position of the albums array list from the album activity.
    private void albumFive() {
        //creates the array with a loop since identical dummy data is being applied to each position of this array list
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_five,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_five), 5));
        }
    }

    //helper method to create an array of music objects to represent all the songs on the album in the 5th position of the albums array list from the album activity.
    private void albumSix() {
        //creates the array with a loop since identical dummy data is being applied to each position of this array list
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_six,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_six), 6));
        }
    }

    //helper method to create an array of music objects to represent all the songs on the album in the 5th position of the albums array list from the album activity.
    private void albumSeven() {
        //creates the array with a loop since identical dummy data is being applied to each position of this array list
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_seven,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_seven), 7));
        }
    }
}
