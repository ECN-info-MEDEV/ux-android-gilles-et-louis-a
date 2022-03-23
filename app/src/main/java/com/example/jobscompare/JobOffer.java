package com.example.jobscompare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JobOffer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer);

        //retrieving user input from NewOffer Activity
        Intent Extra = getIntent();
        String user_entreprise_input = Extra.getStringExtra("User_entreprise_Input");

        TextView mText = (TextView) findViewById(R.id.OfferCompagnyName);
        mText.setText(user_entreprise_input);


    }

    public void onRadioButtonClicked(View view) {
    }
}