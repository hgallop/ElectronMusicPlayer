package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Music> music = new ArrayList<>();

        music.add(new Music(R.drawable.bensound_album_cover,
                getResources().getString(R.string.bensound_sample_hits),
                getResources().getString(R.string.sample_description)));
        music.add(new Music(R.drawable.generic_cover,
                getResources().getString(R.string.generic_one),
                getResources().getString(R.string.generic_desc)));
        music.add(new Music(R.drawable.generic_cover_two,
                getResources().getString(R.string.generic_two),
                getResources().getString(R.string.generic_desc)));
        music.add(new Music(R.drawable.generic_cover_3,
                getResources().getString(R.string.generic_three),
                getResources().getString(R.string.generic_desc)));
        music.add(new Music(R.drawable.generic_cover_four,
                getResources().getString(R.string.generic_four),
                getResources().getString(R.string.generic_desc)));
        music.add(new Music(R.drawable.generic_cover_five,
                getResources().getString(R.string.generic_five),
                getResources().getString(R.string.generic_desc)));
        music.add(new Music(R.drawable.generic_cover_six,
                getResources().getString(R.string.generic_six),
                getResources().getString(R.string.generic_desc)));
        music.add(new Music(R.drawable.generic_cover_seven,
                getResources().getString(R.string.generic_seven),
                getResources().getString(R.string.generic_desc)));

        ListView musicList = findViewById(R.id.list);

        AlbumAdapter albumAdapter = new AlbumAdapter(this, music);

        musicList.setAdapter(albumAdapter);

        musicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(AlbumActivity.this, SongActivity.class);
                intent.putExtra("pos", position);
                startActivity(intent);
            }
        });
    }
}
