package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class NowPlayingActivity extends AppCompatActivity {

    //keys for save/restore and for intent extras
    private static final String POSITION = "position";
    private static final String IMAGE_ID = "imageId";
    private static final String SONG = "song";
    private static final String ALBUM = "album";
    private static final String IDENTITY = "identity";
    private static final String IS_PLAYING = "isPlaying";
    private static final String IS_PAUSED = "isPaused";
    private static final String PLAY_BUTTON_IMAGE = "playButtonImage";

    //variables for play/pause button logic
    boolean isPlaying;
    boolean isPaused;
    int playButtonImage;

    //variable for storing which song position was chosen from the array list
    int position;
    //variables to store intent extras received from the previous activity
    int imageID;
    String song;
    String album;
    int identity;

    //variable to store an arbitrary album length
    private static final int ALBUM_LENGTH = 8;

    //creates an array list of music objects for each album
    final ArrayList<Music> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        //receives the information sent along from other activities
        Intent intent = getIntent();
        position = intent.getIntExtra(POSITION, 0);
        imageID = intent.getIntExtra(IMAGE_ID, 0);
        song = intent.getStringExtra(SONG);
        album = intent.getStringExtra(ALBUM);
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
                break;

        }

        //initializes variables for all views in the layout
        final ImageView songImage = findViewById(R.id.song_image);
        final TextView songName = findViewById(R.id.song_title);
        final TextView albumName = findViewById(R.id.album_title);
        final ImageButton skipBack = findViewById(R.id.skip_back);
        final ImageButton rewind = findViewById(R.id.rewind);
        final ImageButton play = findViewById(R.id.play_icon);
        final ImageButton stop = findViewById(R.id.stop);
        final ImageButton fastForward = findViewById(R.id.fast_forward);
        final ImageButton skipForward = findViewById(R.id.skip_forward);
        final Button home = findViewById(R.id.home);
        final Button allSongs = findViewById(R.id.songs);
        final Button allAlbums = findViewById(R.id.albums);


        //sets value to true or false depending on which activity the user navigated from
        isPlaying = identity != 8;
        isPaused = !isPlaying;
        //calls method to choose correct image resource for play or pause button
        setButton();

        //set play/pause button to correct image
        play.setImageResource(playButtonImage);

        //set song information to views
        songImage.setImageResource(imageID);
        songName.setText(song);
        albumName.setText(album);

        //creates functionality to allow user to skip backwards through all songs in the array list
        skipBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position > 0) {
                    position -= 1;
                } else {
                    position = NowPlayingActivity.this.songs.size() - 1;
                }

                //resets song information to the current song based on position in the array list
                imageID = NowPlayingActivity.this.songs.get(position).getImageId();
                song = NowPlayingActivity.this.songs.get(position).getMusicTitle();
                album = NowPlayingActivity.this.songs.get(position).getMusicDescription();

                //set the views to display the song information
                songImage.setImageResource(imageID);
                songName.setText(song);
                albumName.setText(album);
                Toast.makeText(NowPlayingActivity.this, getResources().getString(R.string.skip_back_pressed), Toast.LENGTH_SHORT).show();
            }
        });

        //displays a toast to indicate to the user that the button was clicked
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this, getResources().getString(R.string.rewind_pressed), Toast.LENGTH_SHORT).show();
                //this method would hold the logic to add a rewind feature to a media player
            }
        });

        //determines the current state of the button and displays play or pause based on the state
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    isPaused = true;
                    isPlaying = false;
                } else {
                    isPlaying = true;
                    isPaused = false;
                }
                //help method to determine image resource to use
                setButton();
                //set image resource to the button view
                play.setImageResource(playButtonImage);
                //display a toast to the user to indicate that the button was clicked
                Toast.makeText(NowPlayingActivity.this, getResources().getString(R.string.play_pressed), Toast.LENGTH_SHORT).show();
                //this button would hold the logic to play or pause a media item based on the current state of the media item
            }
        });

        //sets the state of the play button and display a message to the user to indicate the button was clicked
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlaying = false;
                isPaused = false;
                setButton();
                play.setImageResource(playButtonImage);

                Toast.makeText(NowPlayingActivity.this, getResources().getString(R.string.stop_pressed), Toast.LENGTH_SHORT).show();
                //this button would hold the logic to stop a media player item if playing
            }
        });

        //displays a toast to indicate to the user that the button was pressed
        fastForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this, getResources().getString(R.string.fast_forward_pressed), Toast.LENGTH_SHORT).show();
                //this would allow the user to move forward in the media item
            }
        });

        //allows user to skip forward through the array list of songs
        skipForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < NowPlayingActivity.this.songs.size() - 1) {
                    position += 1;
                } else {
                    position = 0;
                }

                //gets the song information for the current selection
                imageID = NowPlayingActivity.this.songs.get(position).getImageId();
                song = NowPlayingActivity.this.songs.get(position).getMusicTitle();
                album = NowPlayingActivity.this.songs.get(position).getMusicDescription();

                //sets the song information to the views
                songImage.setImageResource(imageID);
                songName.setText(song);
                albumName.setText(album);

                Toast.makeText(NowPlayingActivity.this, getResources().getString(R.string.skip_forward_pressed), Toast.LENGTH_SHORT).show();
            }
        });

        //this button allows the user to return the the main screen of the app
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlayingActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //allows the user to navigate to the song list
        allSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlayingActivity.this, SongActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra(IDENTITY, identity);
                startActivity(intent);
            }
        });

        //allows the user to navigate to the album list
        allAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlayingActivity.this, AlbumActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    //saves state of app data upon change
    @Override
     protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(POSITION, position);
        outState.putInt(IMAGE_ID,  imageID);
        outState.putString(SONG, song);
        outState.putString(ALBUM, album);
        outState.putInt(IDENTITY, identity);
        outState.putBoolean(IS_PLAYING, isPlaying);
        outState.putBoolean(IS_PAUSED, isPaused);
        outState.putInt(PLAY_BUTTON_IMAGE, playButtonImage);
    }

    //restores state of app data
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt(POSITION);
        imageID = savedInstanceState.getInt(IMAGE_ID);
        song = savedInstanceState.getString(SONG);
        album = savedInstanceState.getString(ALBUM);
        identity = savedInstanceState.getInt(IDENTITY);
        isPlaying = savedInstanceState.getBoolean(IS_PLAYING);
        isPaused = savedInstanceState.getBoolean(IS_PAUSED);
        playButtonImage = savedInstanceState.getInt(PLAY_BUTTON_IMAGE);
    }

    // Return to previous activity
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    //helper method to determine which image resource should be displayed for the play/pause button
    private void setButton() {
        if (isPlaying) {
            playButtonImage = R.drawable.ic_play_circle_filled_black_48dp;
        } else if(isPaused) {
            playButtonImage = R.drawable.ic_pause_circle_filled_black_48dp;
        }  else {
            playButtonImage = R.drawable.ic_play_circle_outline_black_48dp;
        }
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

    //helper method to create an array of music objects to represent all the songs on the album in the 6th position of the albums array list from the album activity.
    private void albumSix() {
        //creates the array with a loop since identical dummy data is being applied to each position of this array list
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_six,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_six), 6));
        }
    }

    //helper method to create an array of music objects to represent all the songs on the album in the 7th position of the albums array list from the album activity.
    private void albumSeven() {
        //creates the array with a loop since identical dummy data is being applied to each position of this array list
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            songs.add(new Music(R.drawable.generic_cover_seven,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_seven), 7));
        }
    }
}
