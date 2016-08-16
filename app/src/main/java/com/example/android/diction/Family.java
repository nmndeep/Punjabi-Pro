package com.example.android.diction;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.*;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SINGH on 13-08-2016.
 */
public class Family  extends android.support.v7.app.AppCompatActivity {


     private  MediaPlayer mMediaplayer;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months);
      final  ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Black","Kaala",R.mipmap.color_black,R.raw.black));
        words.add(new Word("Gray","Saleti",R.mipmap.color_gray,R.raw.gray));
        words.add(new Word("White","Chitta",R.mipmap.color_white,R.raw.white));
        words.add(new Word("Blue","Neela",R.color.category_vocabulary,R.raw.blue));
        words.add(new Word("Green","Hara",R.mipmap.color_green,R.raw.green));
        words.add(new Word("Yellow","Pilla",R.mipmap.color_mustard_yellow,R.raw.yellow));
        words.add(new Word("Red","Laal",R.mipmap.color_red,R.raw.red));
        words.add(new Word("Brown","Bhoora",R.mipmap.color_brown,R.raw.brown));


        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_family);


        ListView listView = (ListView)findViewById(R.id.list);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);

                mMediaplayer = MediaPlayer.create(Family.this, word.getmAudioResourceId());

                mMediaplayer.start();

                mMediaplayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer() {
        if (mMediaplayer != null) {
            mMediaplayer.release();

            mMediaplayer = null;
        }

    }
}
