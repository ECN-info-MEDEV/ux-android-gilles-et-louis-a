package com.example.jobscompare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton actionButtonNewOffer = findViewById(R.id.newOffer);
        actionButtonNewOffer.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,
                    NewOffer.class);
            startActivity(intent);
        });
    }

    public void onRadioButtonClicked(View view) {
    }
}