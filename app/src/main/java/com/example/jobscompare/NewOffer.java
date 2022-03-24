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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

public class NewOffer extends AppCompatActivity {

    private static final String TAG = "Activity-NewOffer";
    String selectedOfferType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_offer);

        setTitle("Ajouter une nouvelle offre");

        //Sending radio buttons values to the job offer screen
        RadioGroup radioGroup = findViewById(R.id.typeCandidatureRadio);

        RadioButton candidature_spontanee = findViewById(R.id.candidature_spontanee);
        RadioButton offre_d_emploi = findViewById(R.id.offre_d_emploi);
        RadioButton approche_reseau = findViewById(R.id.approche_reseau);
        RadioButton autre = findViewById(R.id.autre);

        offre_d_emploi.setSelected(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.candidature_spontanee){
                    selectedOfferType = candidature_spontanee.getText().toString();
                }else if(i==R.id.offre_d_emploi){
                    selectedOfferType = offre_d_emploi.getText().toString();
                }else if(i==R.id.approche_reseau) {
                    selectedOfferType = approche_reseau.getText().toString();
                }else{
                    selectedOfferType = autre.getText().toString();
                }
            }
        });

        Button mButton = (Button)findViewById(R.id.buttonValider);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //Sending the message of radio buttons input
                //Preparing the sendMessage to pass data to the JobOffer Activity
                Intent sendMessage = new Intent(NewOffer.this,  JobOffer.class);
                sendMessage.putExtra("type_canditature", selectedOfferType);

                //the following block iterate through ids rather than copy-pasting
                //lines of code
                //it could be improved by defining more simple functions
                //for sending messages and making fields required
                Resources r = getResources();
                String name = getPackageName();
                List<String> ids_name = Arrays.asList("entreprise_input", "poste_input", "link_input", "address_input");
                String name_placeholder;
                for (String id_name : ids_name) {
                    //getting user input using the id of the text input
                    EditText mEdit2 = (EditText) findViewById(r.getIdentifier(id_name, "id", name));
                    Log.i(TAG, "id_name : "+id_name);
                    Log.i(TAG, "id : "+r.getIdentifier(id_name, "id", name));
                    name_placeholder = mEdit2.getText().toString();

                    //making the field required for the job title
                    if (name_placeholder.length() == 0 && id_name == "entreprise_input"){
                        mEdit2.setError("Merci d'entrer un nom d'entreprise'");
                        return;
                    }else if (name_placeholder.length() == 0 && id_name == "poste_input") {
                        mEdit2.setError("Merci d'entrer un nom de poste");
                        return;
                    }else {
                        //do something
                    }

                    //Sending the message
                    sendMessage.putExtra("User_"+id_name, name_placeholder);
                    Log.i(TAG, "name_placeholder : "+name_placeholder);

                }
                //this sends all messages to the defined activity
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