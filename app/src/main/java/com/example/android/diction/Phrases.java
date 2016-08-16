package com.example.android.diction;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.diction.R;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
        private MediaPlayer mMediaplayer;



    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
       final  ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("I speak English","main angarēzī bōladā hān",R.raw.phrase1));
        words.add(new Word("he speaks German","ōha jaramana bōladā hai",R.raw.phrase2));
        words.add(new Word("they speak Chinese","ōha cīnī bōladē hana",R.raw.phrase3));
        words.add(new Word("I visited France","main pharānsa giā si",R.raw.phrase4));
        words.add(new Word("you visited Italy","tusīn iṭalī gaē sī",R.raw.phrase5));
        words.add(new Word("I will drink milk","maiṁ dudha pīvāṅgā",R.raw.phrase6));
        words.add(new Word("you will drink coffee","tusīn kauphī piogē",R.raw.phrase7));
        words.add(new Word("You will drink water","Tu paani pivengii ",R.raw.phrase8));
        words.add(new Word("Where is the airport? ","havāī aḍā kithē hai? ",R.raw.phrase9));




        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_phrases);


        ListView listView = (ListView) findViewById(R.id.list);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);

                mMediaplayer = MediaPlayer.create(Phrases.this, word.getmAudioResourceId());

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
