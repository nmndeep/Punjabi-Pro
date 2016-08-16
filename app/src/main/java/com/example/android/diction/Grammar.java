package com.example.android.diction;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.ListView;
import java.util.ArrayList;
import com.example.android.diction.R;

/**
 * Created by SINGH on 13-08-2016.
 */
public class Grammar extends AppCompatActivity {
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
        setContentView(R.layout.activity_colors);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("And","ate",R.raw.and));
        words.add(new Word("Above","ute",R.raw.up));
        words.add(new Word("Under","heth",R.raw.below));
        words.add(new Word("Before","pahalan",R.raw.before));
        words.add(new Word("Where","Kithe",R.raw.after));
        words.add(new Word("Near","nerre",R.raw.near));
        words.add(new Word("In","andar",R.raw.in));
        words.add(new Word("With","naale",R.raw.with));
        words.add(new Word("Without","baigaraa",R.raw.without));
        words.add(new Word("Between","darmaiana",R.raw.between));
        words.add(new Word("But","par",R.raw.but));
        words.add(new Word("From","vallon",R.raw.from));
        words.add(new Word("To","nu",R.raw.to));

        WordAdapter adapter =new WordAdapter(this,words,R.color.category_grammar);


        ListView listView = (ListView)findViewById(R.id.list);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);

                mMediaplayer = MediaPlayer.create(Grammar.this, word.getmAudioResourceId());

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
