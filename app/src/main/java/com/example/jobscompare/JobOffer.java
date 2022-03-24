package com.example.jobscompare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        if (!link_input.startsWith("http://") && !link_input.startsWith("https://"))
            link_input = "http://" + link_input;
        SpannableString clicable_link = new SpannableString("lien de l’offre");
        clicable_link.setSpan(new URLSpan(link_input), 0, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Log.i(TAG, "link_input : "+link_input);
        TextView mText3 = (TextView) findViewById(R.id.link_input);
        mText3.setText(clicable_link);

        ClickableSpan cs = new ClickableSpan() {
            @Override
            public void onClick(View activity_job_offer) {
                Toast.makeText(getApplicationContext(), "this was clicked", Toast.LENGTH_LONG).show();
            }
        };

        mText3.setMovementMethod(LinkMovementMethod.getInstance());


        /*//retrieving user input from NewOffer Activity
        String address_input = Extra.getStringExtra("User_address_input");
        Log.i(TAG, "address_input : "+address_input);
        TextView mText4 = (TextView) findViewById(R.id.address_input);
        mText4.setText(address_input);*/


    }

    public void onRadioButtonClicked(View view) {
    }
}