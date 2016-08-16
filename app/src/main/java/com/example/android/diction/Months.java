package com.example.android.diction;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.diction.R;

import java.util.ArrayList;

public class Months extends AppCompatActivity {
        private MediaPlayer mMediaplayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
       final  ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Monday","somvaar",R.raw.monday));
        words.add(new Word("Tuesday","mangalvaar",R.raw.tuesday));
        words.add(new Word("Wednesday","budhvaar",R.raw.wednesday));
        words.add(new Word("Thursday","veervaar",R.raw.thursday));
        words.add(new Word("Friday","shukrvaar",R.raw.friday));
        words.add(new Word("Saturday", "shanivaar",R.raw.saturday));
        words.add(new Word("Sunday", "aitvaar",R.raw.sunday));

                WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_months);


        ListView listView = (ListView)findViewById(R.id.list);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaplayer = MediaPlayer.create(Months.this, word.getmAudioResourceId());

                // Start the audio file
                mMediaplayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaplayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaplayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaplayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaplayer = null;
        }

    }
}
