package com.example.jobscompare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewOffer extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_offer);

        Button mButton = (Button)findViewById(R.id.buttonValider);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //getting user input using the id of the text input
                EditText mEdit = (EditText) findViewById(R.id.entreprise_input);
                String entreprise_name = mEdit.getText().toString();

                //Sending the message
                Intent sendMessage = new Intent(NewOffer.this,  JobOffer.class);
                sendMessage.putExtra("User_entreprise_Input", entreprise_name);
                startActivity(sendMessage);
                //Nb : the message is not persistent. if we go back to input screen
                // it replaces the message with blank
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.candidature_spontanee:
                if (checked)
                    // Candidature spontanee
                    displayToast(getString(R.string.candidature_spontanee));
                break;
            case R.id.offre_d_emploi:
                if (checked)
                    // offre d emploi
                    displayToast(getString(R.string.offre_d_emploi));
                break;
            case R.id.approche_reseau:
                if (checked)
                    // approche_reseau
                    displayToast(getString(R.string.approche_reseau));
                break;
            case R.id.autre:
                if (checked)
                    // autre
                    displayToast(getString(R.string.autre));
                break;
            default:
                // Do nothing.
                break;
        }

    }
}