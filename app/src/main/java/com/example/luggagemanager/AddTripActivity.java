package com.example.luggagemanager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Boolean.parseBoolean;

public class AddTripActivity extends AppCompatActivity {
    EditText Airlinename;
    EditText TripName;
    EditText TripFrom;
    EditText TripTo;
    EditText Departuredate;
    EditText Arrivaldate;
    EditText BagCount;
    EditText Phone;
    ToggleButton Insurance;
    public Button Send;
    FirebaseDatabase database;
    DatabaseReference ref;
    trip Trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        Airlinename= findViewById(R.id.AirlineName);
        TripName = findViewById(R.id.Tripname);
        TripFrom = findViewById(R.id.Tripfrom);
        TripTo = findViewById(R.id.Tripto);
        Departuredate= findViewById(R.id.Departuredate);
        Arrivaldate=findViewById(R.id.Arrivaldate);
        BagCount = findViewById(R.id.bags);
        Insurance = findViewById(R.id.Insurance);
        Send = findViewById(R.id.next);
        Phone=findViewById(R.id.phone);
        database = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference().child("trip");
        Trip= new trip();


        Send.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {

                if(TripName.getText().toString().isEmpty())
                {
                    Toast.makeText(AddTripActivity.this, "Error: TripName is mandatory", Toast.LENGTH_LONG).show();
                }
                else {
                    Trip.setBAGCOUNT(BagCount.getText().toString().trim());
                    Trip.setAIRLINENAME(Airlinename.getText().toString().trim());
                    Trip.setTRIPNAME(TripName.getText().toString().trim());
                    Trip.setSOURCEADDRESS(TripFrom.getText().toString().trim());
                    Trip.setDESTINATIONADDRESS(TripTo.getText().toString().trim());
                    Trip.setDEPARTUREDATE(Departuredate.getText().toString().trim());
                    Trip.setARRIVALDATE(Arrivaldate.getText().toString().trim());
                    Boolean INSURANCE = parseBoolean(Insurance.getText().toString().trim());
                    Trip.setMOBILE(Phone.getText().toString().trim());
                    Trip.setINSURANCE(INSURANCE);
                    ref.push().setValue(Trip);
                    Toast.makeText(AddTripActivity.this, "Submitted Successfully", Toast.LENGTH_LONG).show();
                    Intent intentLoadNewActivity = new Intent(AddTripActivity.this, ItemDetailsActivity.class);
                    startActivity(intentLoadNewActivity);

                }

            }
        });



    }
}
