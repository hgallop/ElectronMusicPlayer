package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class NowPlayingActivity extends AppCompatActivity {

    private final String POS = "pos";
    private final String IMAGE = "imageId";
    private final String SONG = "song";
    private final String ALBUM = "album";

    boolean playing;
    boolean paused;
    int playButtonImage;
    int pauseButtonImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        Intent intent = getIntent();
        int position = intent.getIntExtra(POS, 0);
        int imageID = intent.getIntExtra(IMAGE, 0);
        String song = intent.getStringExtra(SONG);
        String album = intent.getStringExtra(ALBUM);

        ImageView songImage = findViewById(R.id.albumImage);
        TextView songName = findViewById(R.id.song);
        TextView albumName = findViewById(R.id.album);
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
}
