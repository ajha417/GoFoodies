package com.example.gofoodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AboutUsActivity extends AppCompatActivity {

    ImageView phone,gmail,web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setTitle("About Us");

        phone = findViewById(R.id.aboutus_imageview_phone);
        gmail = findViewById(R.id.aboutus_imageview_gmail);
        web = findViewById(R.id.aboutus_imageview_web);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent =new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:+91786308495"));
                startActivity(callIntent);
            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{"pradip.chaurel0427@gmail.com"});
                mail.setType("text/plain");

                if (getIntent().resolveActivity(getPackageManager()) != null){
                    startActivity(mail);
                }
                else{
                    Toast.makeText(AboutUsActivity.this, "There is no application to support that action", Toast.LENGTH_SHORT).show();
                }
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.rku.ac.in";
                Intent i =new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}