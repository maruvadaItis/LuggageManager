package com.example.luggagemanager;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PreviousTripDetails extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> listnew;
    ArrayAdapter<String> adapter;
    trip Trip;
    String text2QR;
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_trip_details);
        Trip=new trip();
        tx = findViewById(R.id.tx);

        database=FirebaseDatabase.getInstance();
        ref=database.getReference("trip");

       // listnew=new ArrayList<>();
        //adapter=new ArrayAdapter<String>(this,R.layout.activity_previous_trip_details,R.id.kuchbhi,listnew);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    Trip=ds.getValue(trip.class);
                    text2QR =
                            "***Trip Name : "+Trip.getTRIPNAME()+"***\n"+
                            "Airline Name : "+Trip.getAIRLINENAME()+"\n"+
                            "Source Address : "+Trip.getSOURCEADDRESS()+"\n"+
                            "Destination Address : "+Trip.getDESTINATIONADDRESS()+"\n"+
                            "Departure Date: "+Trip.getDEPARTUREDATE()+"\n"+
                            "Arrival Date: "+Trip.getARRIVALDATE()+"\n"+
                            "Bag Count: "+Trip.getBAGCOUNT()+"\n"+
                            "Mobile Number : "+Trip.getMOBILE()+"\n"+
                            "Insurance: "+Trip.getINSURANCE()+"\n";
                break;
                }
                tx.setText(text2QR);
               // listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

