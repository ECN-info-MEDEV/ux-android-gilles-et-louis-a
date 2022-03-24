package com.example.jobscompare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class JobOffer extends AppCompatActivity {
    private static final String TAG = "Activity-JobOffer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer);

        //retrieving user input from NewOffer Activity
        Intent Extra = getIntent();
        String user_entreprise_input = Extra.getStringExtra("User_entreprise_Input");
        Log.i(TAG, "user_entreprise_input : "+user_entreprise_input);
        TextView mText = (TextView) findViewById(R.id.OfferCompagnyName);
        mText.setText(user_entreprise_input);

        //retrieving user input from NewOffer Activity
        String text_poste = Extra.getStringExtra("User_poste_input");
        Log.i(TAG, "text_poste : "+text_poste);
        TextView mText2 = (TextView) findViewById(R.id.text_poste);
        mText2.setText(text_poste);

        //retrieving user input from NewOffer Activity
        String link_input = Extra.getStringExtra("User_link_input");
        Log.i(TAG, "link_input : "+link_input);
        TextView mText3 = (TextView) findViewById(R.id.link_input);
        mText3.setText(link_input);


    }

    public void onRadioButtonClicked(View view) {
    }
}