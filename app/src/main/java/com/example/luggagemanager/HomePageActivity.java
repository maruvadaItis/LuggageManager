package com.example.luggagemanager;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class HomePageActivity extends AppCompatActivity {



    ImageView bgapp,clover;
    ImageButton myImageButton;
    ImageButton myImageButton1,myImageButton2,myImageButton3;
    Button logout;

    LinearLayout textsplash, texthome, menus;

    Animation frombottom;



    @SuppressLint("WrongViewCast")
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_page);




        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);





        bgapp = findViewById(R.id.bgapp);

        clover = findViewById(R.id.clover);

        textsplash = findViewById(R.id.textsplash);

        texthome = findViewById(R.id.texthome);

        menus = findViewById(R.id.menus);



        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);

        clover.animate().alpha(0).setDuration(800).setStartDelay(600);

        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);



        texthome.startAnimation(frombottom);

        menus.startAnimation(frombottom);
        logout=findViewById(R.id.logout);
        myImageButton1=findViewById(R.id.my_image_button2);
        myImageButton2=findViewById(R.id.my_image_button3);
        myImageButton3=findViewById(R.id.my_image_button4);


        myImageButton = (ImageButton) findViewById(R.id.my_image_button1);
        myImageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               Intent intentLoadNewActivity = new Intent(HomePageActivity.this, AddTripActivity.class);
                startActivity(intentLoadNewActivity);

            }
        });
        myImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(HomePageActivity.this, PreviousTripDetails.class);
                startActivity(intentLoadNewActivity);

            }
        });

        myImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(HomePageActivity.this, GenerateQRActivity.class);
                startActivity(intentLoadNewActivity);

            }
        });

        myImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(HomePageActivity.this, ScanQRActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });










    }

}
