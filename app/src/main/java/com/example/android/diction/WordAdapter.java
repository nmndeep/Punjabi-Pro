package com.example.android.diction;

import android.content.Context;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.diction.R;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorId;

    public WordAdapter(Context context, ArrayList<Word> words,int ColorId) {
        super(context, 0, words);
        mColorId=ColorId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
          View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        Word currentWord = getItem(position);

        TextView punjabiTextView = (TextView) listItemView.findViewById(R.id.punj_text);

        punjabiTextView.setText(currentWord.getPunjabiTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text);

        defaultTextView.setText(currentWord.getDefaultTranslation());
        ImageView imageView=(ImageView)listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getimageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        View textcontainer=listItemView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),mColorId);
        textcontainer.setBackgroundColor(color);



        return listItemView;

    }
}
