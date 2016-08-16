package com.example.android.diction;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by SINGH on 13-08-2016.
 */
public class Vocabulary extends AppCompatActivity {
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
        words.add(new Word("airport","havīaḍā",R.raw.airport));
        words.add(new Word("doctor","ḍākaṭara",R.raw.doctor));
        words.add(new Word("airplane","havāījahāza",R.raw.airplane));
        words.add(new Word("medicines","davaian",R.raw.medicine));
        words.add(new Word("train","rēlagaḍī",R.raw.train));
        words.add(new Word("hospital","hasapatāla",R.raw.hospital));
        words.add(new Word("poison","zahira",R.raw.poison));
        words.add(new Word("help me","mērī madada karō",R.raw.help));
        words.add(new Word("danger","khatarā",R.raw.danger));
        words.add(new Word("headache","siradarada",R.raw.headache));
        words.add(new Word("toilet","Pakhana",R.raw.toilet));
        words.add(new Word("student","vidyaarthi",R.raw.student));
        words.add(new Word("kitchen","rasoi",R.raw.kitchen));

        words.add(new Word("chair","Kursi",R.raw.chair));
        words.add(new Word("Room","Kamra",R.raw.room));
        words.add(new Word("question","savaal",R.raw.question));


        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_vocabulary);


        ListView listView = (ListView)findViewById(R.id.list);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);

                mMediaplayer = MediaPlayer.create(Vocabulary.this, word.getmAudioResourceId());

                // Start the audio file
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
