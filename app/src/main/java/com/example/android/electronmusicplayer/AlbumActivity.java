package com.example.android.electronmusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    //key for save/restore and retrieving intent extra
    private static final String IDENTITY = "identity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // Add a return to previous screen in top left corner
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //declare an array of albums
        final ArrayList<Music> albums = new ArrayList<>();

        //add music objects to the album array
        albums.add(new Music(R.drawable.bensound_album_cover,
                getResources().getString(R.string.bensound_sample_hits),
                getResources().getString(R.string.sample_description), 0));
        albums.add(new Music(R.drawable.generic_cover,
                getResources().getString(R.string.generic_one),
                getResources().getString(R.string.generic_description), 1));
        albums.add(new Music(R.drawable.generic_cover_two,
                getResources().getString(R.string.generic_two),
                getResources().getString(R.string.generic_description), 2));
        albums.add(new Music(R.drawable.generic_cover_3,
                getResources().getString(R.string.generic_three),
                getResources().getString(R.string.generic_description), 3));
        albums.add(new Music(R.drawable.generic_cover_four,
                getResources().getString(R.string.generic_four),
                getResources().getString(R.string.generic_description), 4));
        albums.add(new Music(R.drawable.generic_cover_five,
                getResources().getString(R.string.generic_five),
                getResources().getString(R.string.generic_description), 5));
        albums.add(new Music(R.drawable.generic_cover_six,
                getResources().getString(R.string.generic_six),
                getResources().getString(R.string.generic_description), 6));
        albums.add(new Music(R.drawable.generic_cover_seven,
                getResources().getString(R.string.generic_seven),
                getResources().getString(R.string.generic_description), 7));

        //access the list layout
        ListView albumList = findViewById(R.id.list);

        //create custom adapter object to handle displaying the array list to the layout
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);

        //connect adapter to the list layout
        albumList.setAdapter(albumAdapter);

        //set a click listener on each array list item displayed
        albumList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //store the value of the list item identity
                int identity = albums.get(position).getIdentity();

                //create an intent to start the song activity, send along identity of item clicked, flag activity to recall song activity to the top if it already exists
                Intent intent = new Intent(AlbumActivity.this, SongActivity.class);
                intent.putExtra(IDENTITY, identity);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
}
