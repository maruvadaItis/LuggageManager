package com.example.luggagemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddBaggageDetails extends AppCompatActivity {
    EditText BagType;
    EditText BagInfo;
    Button Send;
    FirebaseDatabase database;
    DatabaseReference ref;
    bag Bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_baggage_details);
        BagType=findViewById(R.id.bagtype);
        BagInfo=findViewById(R.id.Baginfo);
        Send=findViewById(R.id.NEXXT);
        database = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference().child("bag");
        Bag= new bag();

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bag.setBAGTYPE(BagType.getText().toString().trim());
                Bag.setBAGINFO(BagInfo.getText().toString().trim());
                ref.push().setValue(Bag);
                Toast.makeText(AddBaggageDetails.this,"Submitted Successfully",Toast.LENGTH_LONG);
            }
        });
    }
}
