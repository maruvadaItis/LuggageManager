package com.example.luggagemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ItemDetailsActivity extends AppCompatActivity {
    EditText ItemName;
    EditText ItemQty;
    EditText ItemCost;
    EditText BagType;
    EditText BagInfo;
    Button AddItem;
    Button AddBag;
    Button Continue;
    FirebaseDatabase database;
    DatabaseReference ref,ref1;
    items Items;
    bag Bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        BagType=findViewById(R.id.bagtype);
        BagInfo=findViewById(R.id.baginfo);
        ItemName= findViewById(R.id.itemname);
        ItemQty = findViewById(R.id.itemqty);
        ItemCost= findViewById(R.id.itemprice);
        AddItem= findViewById(R.id.additem);
        AddBag= findViewById(R.id.addbag);
        Continue = findViewById(R.id.continueto);
        database = FirebaseDatabase.getInstance();
        ref = FirebaseDatabase.getInstance().getReference().child("items");
        
        Items= new items();
        ref1 = FirebaseDatabase.getInstance().getReference().child("bag");
        Bag= new bag();
        AddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Items.setBAGTYPE(BagType.getText().toString().trim());
                Items.setBAGINFO(BagInfo.getText().toString().trim());
                Items.setITEMNAME(ItemName.getText().toString().trim());
                Items.setITEMQTY(ItemQty.getText().toString().trim());
                Items.setITEMPRICE(ItemCost.getText().toString().trim());
                ref.push().setValue(Items);
                Toast.makeText(ItemDetailsActivity.this,"Item added to bag Successfully",Toast.LENGTH_LONG).show();

                ItemName.setText("");
                ItemQty.setText("");
                ItemCost.setText("");

            }
        });
        AddBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bag.setBAGTYPE(BagType.getText().toString().trim());
                Bag.setBAGINFO(BagInfo.getText().toString().trim());
                ref1.push().setValue(Bag);


                Toast.makeText(ItemDetailsActivity.this,"Bag Information Submitted Successfully",Toast.LENGTH_LONG).show();


            }
        });

        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(ItemDetailsActivity.this, GenerateQRActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });



    }
}
