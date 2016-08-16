package com.example.android.diction;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.diction.R;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
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
        setContentView(R.layout.activity_colors);
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father","Pita",R.mipmap.family_male,R.raw.father));

        words.add(new Word("Mother","Mata",R.mipmap.family_women,R.raw.mother));

        words.add(new Word("Brother (spoken in a low tone)","Puraa",R.mipmap.bro,R.raw.brother));

        words.add(new Word("Sister (low tone)","Pehn",R.mipmap.sis,R.raw.sister));


        words.add(new Word("Grandpa(Paternal)","Babba or Dadaa",R.mipmap.family_old,R.raw.grandpa));
        words.add(new Word("Grandma (Paternal)","Bebbe or Dadi",R.mipmap.family_oldw,R.raw.grandma));

        words.add(new Word("Husband","Pati",R.mipmap.eld_bro,R.raw.husband));
        words.add(new Word("Wife)","Patni",R.mipmap.family_women,R.raw.wife));
        words.add(new Word("Son","Puttar",R.mipmap.bro,R.raw.son));
        words.add(new Word("Daughter","Puttari/Kuri",R.mipmap.sis,R.raw.daughter));


        WordAdapter adapter =
                new WordAdapter(this,words,R.color.category_colors);


        ListView listView = (ListView)findViewById(R.id.list);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);

                mMediaplayer = MediaPlayer.create(Colors.this, word.getmAudioResourceId());

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
