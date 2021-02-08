package com.example.luggagemanager;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GenerateQRActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    Button gen_btn;
    ImageView image;
    Button en_btn;
    Button save_btn;
    Button print_btn;
    Button Home;

    TextView name;
    FirebaseDatabase database;
    DatabaseReference ref, ref1;
    items Items;
    trip Trip;

    String text2QR, textQR, extQR = "", xtQR = "";
    private static void scanFile(Context context, Uri imageUri){
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        scanIntent.setData(imageUri);
        context.sendBroadcast(scanIntent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Trip = new trip();
        name = findViewById(R.id.nm);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("trip");
        ref1 = database.getReference("items");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);
        gen_btn = findViewById(R.id.gen_btn);
        image = findViewById(R.id.image);
        en_btn = findViewById(R.id.en_btn);
        save_btn = findViewById(R.id.save_btn);
        print_btn = findViewById(R.id.print_btn);
        Home= findViewById(R.id.home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(GenerateQRActivity.this, HomePageActivity.class);

                startActivity(mainIntent);
            }
        });

        print_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(GenerateQRActivity.this, "Please connect Printer to print", Toast.LENGTH_LONG).show();

            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd_HHmmss");
                String name = sdf.format(new Date());

                image.buildDrawingCache();
                Bitmap bmp = image.getDrawingCache();
                File storageLoc = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File file = new File(storageLoc,"QR_Code_"+name+".jpg");
                try{
                    FileOutputStream fos = new FileOutputStream(file);
                    bmp.compress(Bitmap.CompressFormat.JPEG,100,fos);
                    fos.close();
                    scanFile(image.getContext(),Uri.fromFile(file));
                    Toast.makeText(GenerateQRActivity.this, "Image saved into Gallery as : QR_Code_"+name+".jpg", Toast.LENGTH_LONG).show();
                }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }
                catch(IOException e){
                    e.printStackTrace();
                }


            }
        });





        ref.addValueEventListener(new ValueEventListener() {

            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    Trip=ds.getValue(trip.class);
                   text2QR = "***Trip Details***\n"+
                           "Trip Name : "+Trip.getTRIPNAME()+"\n"+
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


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }});

        ref1.addValueEventListener(new ValueEventListener() {

            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                textQR="***Bag detail***\n";
                String bagInfo="",bagType="",itemName="",itemCost="",itemQyt="";
                int count=0;
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    Items=ds.getValue(items.class);
                    if(count==0)
                    {
                        bagInfo="Bag Information : "+Items.getBAGINFO();
                        bagType="Bag Type : "+Items.getBAGTYPE();
                        count++;
                    }
                    xtQR= " Item Name : "+Items.getITEMNAME() +"\n  Item cost : "+Items.getITEMPRICE() +"\n"+" Item Quantity : "+Items.getITEMQTY();
                    extQR = extQR+""+xtQR+"\n \n";
                }

                textQR=textQR+" "+bagInfo+"\n "+bagType+"\n "+extQR;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }});




        gen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(text2QR, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);

                }catch (WriterException e){
                    e.printStackTrace();

                }
            }
        });


        en_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(textQR, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);

                }catch (WriterException e){
                    e.printStackTrace();

                }
            }
        });




            }









     }