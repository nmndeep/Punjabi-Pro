
package com.example.android.diction;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
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
        setContentView(R.layout.word_list);

        // Create a list of words
      final  ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","Ikk",R.mipmap.number_1,R.raw.one));
        words.add(new Word("Two","Doo",R.mipmap.number_2,R.raw.two));
        words.add(new Word("Three","Tenn",R.mipmap.number_3,R.raw.three));
        words.add(new Word("Four","Chaar",R.mipmap.number_4,R.raw.chaar));
        words.add(new Word("Five","Panj",R.mipmap.number_5,R.raw.panj));
        words.add(new Word("Six","shhear",R.mipmap.number_6,R.raw.chche));
        words.add(new Word("Seven","Satth",R.mipmap.number_7,R.raw.satt));
        words.add(new Word("Eight","ath",R.mipmap.number_8,R.raw.ath));
        words.add(new Word("Nine","naou",R.mipmap.number_9,R.raw.naou));
        words.add(new Word("Ten","dass",R.mipmap.number_10,R.raw.dass));

        words.add(new Word("Twenty","vih ",R.mipmap.number_20,R.raw.veeh));


        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                               mMediaplayer = MediaPlayer.create(Numbers.this, word.getmAudioResourceId());

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

            mMediaplayer.release();


            mMediaplayer = null;
        }

    }
}
