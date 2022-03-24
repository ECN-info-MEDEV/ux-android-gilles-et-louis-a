package com.example.jobscompare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

public class NewOffer extends AppCompatActivity {

    private static final String TAG = "Activity-NewOffer";

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
                Log.i(TAG, "entreprise_name : "+entreprise_name);


                //TODO : create a function that gets the user input and sends the message

                //TODO : add the address field in the NewOffer Activity

                //the following block iterate through ids rather than copy-pasting the previous
                //lines of code
                Resources r = getResources();
                String name = getPackageName();
                List<String> ids_name = Arrays.asList("poste_input", "link_input");//, "address_input");
                String name_placeholder;
                for (String id_name : ids_name) {
                    //getting user input using the id of the text input
                    EditText mEdit2 = (EditText) findViewById(r.getIdentifier(id_name, "id", name));
                    Log.i(TAG, "id_name : "+id_name);
                    Log.i(TAG, "id : "+r.getIdentifier(id_name, "id", name));
                    name_placeholder = mEdit2.getText().toString();

                    //Sending the message
                    sendMessage.putExtra("User_"+id_name, name_placeholder);
                    Log.i(TAG, "name_placeholder : "+name_placeholder);

                }

                startActivity(sendMessage);
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