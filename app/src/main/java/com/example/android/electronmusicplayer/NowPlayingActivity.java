package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class NowPlayingActivity extends AppCompatActivity {

    private final String POS = "pos";
    private final String IMAGE = "imageId";
    private final String SONG = "song";
    private final String ALBUM = "album";
    private final String ID = "id";

    boolean playing;
    boolean paused;
    int playButtonImage;
    int pauseButtonImage;

    int position;
    int imageID;
    String song;
    String album;
    int identity;

    private static final int ALBUM_LENGTH = 8;

    final ArrayList<Music> music = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        Intent intent = getIntent();
        position = intent.getIntExtra(POS, 0);
        imageID = intent.getIntExtra(IMAGE, 0);
        song = intent.getStringExtra(SONG);
        album = intent.getStringExtra(ALBUM);
        identity = intent.getIntExtra(ID, 0);

        switch (identity){
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

        final ImageView songImage = findViewById(R.id.albumImage);
        final TextView songName = findViewById(R.id.song);
        final TextView albumName = findViewById(R.id.album);
        ImageButton skipBack = findViewById(R.id.skipback);
        ImageButton rewind = findViewById(R.id.rewind);
        final ImageButton play = findViewById(R.id.play);
        final ImageButton pause = findViewById(R.id.pause);
        ImageButton stop = findViewById(R.id.stop);
        ImageButton fastForward = findViewById(R.id.fastforward);
        ImageButton skipForward = findViewById(R.id.skipforward);

        songImage.setImageResource(imageID);
        songName.setText(song);
        albumName.setText(album);

        playing = true;
        paused = false;

        skipBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Position: ", position + "");
                int next;
                if(position > 0) {
                    position -= 1;
                } else {
                    position = music.size() - 1;
                }

                imageID = music.get(position).getImageId();
                song = music.get(position).getMusicTitle();
                album = music.get(position).getMusicDescription();

                songImage.setImageResource(imageID);
                songName.setText(song);
                albumName.setText(album);
                Toast.makeText(NowPlayingActivity.this, "Skip Back", Toast.LENGTH_SHORT).show();
            }
        });

        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this, "Rewind", Toast.LENGTH_SHORT).show();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playing = true;
                paused = false;
                setButton();
                play.setImageResource(playButtonImage);
                pause.setImageResource(pauseButtonImage);
                Toast.makeText(NowPlayingActivity.this, "Play", Toast.LENGTH_SHORT).show();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    paused = true;
                    playing = false;
                    setButton();
                    play.setImageResource(playButtonImage);
                    pause.setImageResource(pauseButtonImage);
                    Toast.makeText(NowPlayingActivity.this, "Pause", Toast.LENGTH_SHORT).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playing = false;
                paused = false;
                setButton();
                play.setImageResource(playButtonImage);
                pause.setImageResource(pauseButtonImage);
                Toast.makeText(NowPlayingActivity.this, "Stop", Toast.LENGTH_SHORT).show();
            }
        });

        fastForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this, "Fast Forward", Toast.LENGTH_SHORT).show();
            }
        });

        skipForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Position: ", position + "");
                if(position < music.size() - 1) {
                    position += 1;
                } else {
                    position = 0;
                }
                imageID = music.get(position).getImageId();
                song = music.get(position).getMusicTitle();
                album = music.get(position).getMusicDescription();

                songImage.setImageResource(imageID);
                songName.setText(song);
                albumName.setText(album);

                Toast.makeText(NowPlayingActivity.this, "Skip Forward", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setButton() {
        if (playing) {
            playButtonImage = R.drawable.ic_play_circle_filled_black_48dp;
            pauseButtonImage = R.drawable.ic_pause_circle_outline_black_48dp;
        } else if(paused) {
            playButtonImage = R.drawable.ic_play_circle_outline_black_48dp;
            pauseButtonImage = R.drawable.ic_pause_circle_filled_black_48dp;
        }  else {
            pauseButtonImage = R.drawable.ic_pause_circle_outline_black_48dp;
            playButtonImage = R.drawable.ic_play_circle_outline_black_48dp;
        }
    }

    private void albumZero() {
        music.add(new Music(R.drawable.a_new_beginning,
                getResources().getString(R.string.new_beginning),
                getResources().getString(R.string.bensound_sample_hits), 0));
        music.add(new Music(R.drawable.creative_mind,
                getResources().getString(R.string.creative_minds),
                getResources().getString(R.string.bensound_sample_hits), 0));
        music.add(new Music(R.drawable.cute,
                getResources().getString(R.string.cute),
                getResources().getString(R.string.bensound_sample_hits), 0));
        music.add(new Music(R.drawable.happy_rock,
                getResources().getString(R.string.happy_rock),
                getResources().getString(R.string.bensound_sample_hits), 0));
        music.add(new Music(R.drawable.jazzy_frenchy,
                getResources().getString(R.string.jazzy_frenchy),
                getResources().getString(R.string.bensound_sample_hits), 0));
        music.add(new Music(R.drawable.little_idea,
                getResources().getString(R.string.little_idea),
                getResources().getString(R.string.bensound_sample_hits), 0));
        music.add(new Music(R.drawable.summer,
                getResources().getString(R.string.summer),
                getResources().getString(R.string.bensound_sample_hits), 0));
        music.add(new Music(R.drawable.ukulele,
                getResources().getString(R.string.ukulele),
                getResources().getString(R.string.bensound_sample_hits), 0));
    }

    private void albumOne() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            music.add(new Music(R.drawable.generic_cover,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_one), 1));
        }
    }

    private void albumTwo() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            music.add(new Music(R.drawable.generic_cover_two,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_two), 2));
        }
    }

    private void albumThree() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            music.add(new Music(R.drawable.generic_cover_3,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_three), 3));
        }
    }

    private void albumFour() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            music.add(new Music(R.drawable.generic_cover_four,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_four), 4));
        }
    }

    private void albumFive() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            music.add(new Music(R.drawable.generic_cover_five,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_five), 5));
        }
    }

    private void albumSix() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            music.add(new Music(R.drawable.generic_cover_six,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_six), 6));
        }
    }

    private void albumSeven() {
        for (int i = 0; i < ALBUM_LENGTH; i++) {
            music.add(new Music(R.drawable.generic_cover_seven,
                    getResources().getString(R.string.generic_song),
                    getResources().getString(R.string.generic_seven), 7));
        }
    }
}
