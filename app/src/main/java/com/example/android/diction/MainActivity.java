package com.example.android.diction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.example.android.diction.Numbers;
import com.example.android.diction.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
    }


    public void openNumbers(View view){
        Intent i=new Intent(this,Numbers.class);
        startActivity(i);

    }
    public void openColors(View view) {
        Intent i = new Intent(this, Colors.class);
        startActivity(i);

    }
    public void openMonths(View view) {
        Intent i = new Intent(this, Months.class);
        startActivity(i);

    }
    public void openPhrases(View view) {
        Intent i = new Intent(this, Phrases.class);
        startActivity(i);

    }

    public void openFamily(View view){
        Intent i=new Intent(this,Family.class);
        startActivity(i);


    }
    public void openGrammar(View view){
        Intent i=new Intent(this,Grammar.class);
        startActivity(i);


    }
    public void openVocabulary(View view){
        Intent i=new Intent(this,Grammar.class);
        startActivity(i);


    }
 }
