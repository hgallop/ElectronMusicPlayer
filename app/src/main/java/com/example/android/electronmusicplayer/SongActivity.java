package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    private final String POS = "pos";
    private final String IMAGE = "imageId";
    private final String SONG = "song";
    private final String ALBUM = "album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        Intent intent = getIntent();
        int position = intent.getIntExtra(POS, 0);

        final ArrayList<Music> music = new ArrayList<>();

        switch(position) {
            case 0:
                music.add(new Music(R.drawable.a_new_beginning,
                        getResources().getString(R.string.new_beginning),
                        getResources().getString(R.string.bensound_sample_hits)));
                music.add(new Music(R.drawable.creative_mind,
                        getResources().getString(R.string.creative_minds),
                        getResources().getString(R.string.bensound_sample_hits)));
                music.add(new Music(R.drawable.cute,
                        getResources().getString(R.string.cute),
                        getResources().getString(R.string.bensound_sample_hits)));
                music.add(new Music(R.drawable.happy_rock,
                        getResources().getString(R.string.happy_rock),
                        getResources().getString(R.string.bensound_sample_hits)));
                music.add(new Music(R.drawable.jazzy_frenchy,
                        getResources().getString(R.string.jazzy_frenchy),
                        getResources().getString(R.string.bensound_sample_hits)));
                music.add(new Music(R.drawable.little_idea,
                        getResources().getString(R.string.little_idea),
                        getResources().getString(R.string.bensound_sample_hits)));
                music.add(new Music(R.drawable.summer,
                        getResources().getString(R.string.summer),
                        getResources().getString(R.string.bensound_sample_hits)));
                music.add(new Music(R.drawable.ukulele,
                        getResources().getString(R.string.ukulele),
                        getResources().getString(R.string.bensound_sample_hits)));
                break;
            case 1:
                music.add(new Music(R.drawable.generic_cover,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_one)));
                music.add(new Music(R.drawable.generic_cover,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_one)));
                music.add(new Music(R.drawable.generic_cover,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_one)));
                music.add(new Music(R.drawable.generic_cover,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_one)));
                music.add(new Music(R.drawable.generic_cover,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_one)));
                music.add(new Music(R.drawable.generic_cover,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_one)));
                music.add(new Music(R.drawable.generic_cover,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_one)));
                music.add(new Music(R.drawable.generic_cover,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_one)));
                break;
            case 2:
                music.add(new Music(R.drawable.generic_cover_two,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_two)));
                music.add(new Music(R.drawable.generic_cover_two,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_two)));
                music.add(new Music(R.drawable.generic_cover_two,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_two)));
                music.add(new Music(R.drawable.generic_cover_two,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_two)));
                music.add(new Music(R.drawable.generic_cover_two,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_two)));
                music.add(new Music(R.drawable.generic_cover_two,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_two)));
                music.add(new Music(R.drawable.generic_cover_two,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_two)));
                music.add(new Music(R.drawable.generic_cover_two,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_two)));
                break;
            case 3:
                music.add(new Music(R.drawable.generic_cover_3,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_three)));
                music.add(new Music(R.drawable.generic_cover_3,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_three)));
                music.add(new Music(R.drawable.generic_cover_3,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_three)));
                music.add(new Music(R.drawable.generic_cover_3,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_three)));
                music.add(new Music(R.drawable.generic_cover_3,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_three)));
                music.add(new Music(R.drawable.generic_cover_3,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_three)));
                music.add(new Music(R.drawable.generic_cover_3,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_three)));
                music.add(new Music(R.drawable.generic_cover_3,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_three)));
                music.add(new Music(R.drawable.generic_cover_3,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_three)));
                break;
            case 4:
                music.add(new Music(R.drawable.generic_cover_four,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_four)));
                music.add(new Music(R.drawable.generic_cover_four,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_four)));
                music.add(new Music(R.drawable.generic_cover_four,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_four)));
                music.add(new Music(R.drawable.generic_cover_four,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_four)));
                music.add(new Music(R.drawable.generic_cover_four,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_four)));
                music.add(new Music(R.drawable.generic_cover_four,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_four)));
                music.add(new Music(R.drawable.generic_cover_four,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_four)));
                music.add(new Music(R.drawable.generic_cover_four,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_four)));
                break;
            case 5:
                music.add(new Music(R.drawable.generic_cover_five,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_five)));
                music.add(new Music(R.drawable.generic_cover_five,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_five)));
                music.add(new Music(R.drawable.generic_cover_five,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_five)));
                music.add(new Music(R.drawable.generic_cover_five,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_five)));
                music.add(new Music(R.drawable.generic_cover_five,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_five)));
                music.add(new Music(R.drawable.generic_cover_five,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_five)));
                music.add(new Music(R.drawable.generic_cover_five,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_five)));
                music.add(new Music(R.drawable.generic_cover_five,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_five)));
                break;
            case 6:
                music.add(new Music(R.drawable.generic_cover_six,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_six)));
                music.add(new Music(R.drawable.generic_cover_six,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_six)));
                music.add(new Music(R.drawable.generic_cover_six,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_six)));
                music.add(new Music(R.drawable.generic_cover_six,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_six)));
                music.add(new Music(R.drawable.generic_cover_six,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_six)));
                music.add(new Music(R.drawable.generic_cover_six,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_six)));
                music.add(new Music(R.drawable.generic_cover_six,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_six)));
                music.add(new Music(R.drawable.generic_cover_six,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_six)));
                break;
            case 7:
                music.add(new Music(R.drawable.generic_cover_seven,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_seven)));
                music.add(new Music(R.drawable.generic_cover_seven,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_seven)));
                music.add(new Music(R.drawable.generic_cover_seven,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_seven)));
                music.add(new Music(R.drawable.generic_cover_seven,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_seven)));
                music.add(new Music(R.drawable.generic_cover_seven,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_seven)));
                music.add(new Music(R.drawable.generic_cover_seven,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_seven)));
                music.add(new Music(R.drawable.generic_cover_seven,
                        getResources().getString(R.string.generic_song),
                        getResources().getString(R.string.generic_seven)));
                break;
        }

        ListView musicList = findViewById(R.id.list);

        SongAdapter songAdapter = new SongAdapter(this, music);

        musicList.setAdapter(songAdapter);

        musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int imageId = music.get(position).getImageId();
                String songTitle = music.get(position).getMusicTitle();
                String albumTitle = music.get(position).getMusicDescription();

                Intent intent = new Intent(SongActivity.this, NowPlayingActivity.class);
                intent.putExtra(POS, position);
                intent.putExtra(IMAGE, imageId);
                intent.putExtra(SONG, songTitle);
                intent.putExtra(ALBUM, albumTitle);
                startActivity(intent);
            }
        });
    }
}
