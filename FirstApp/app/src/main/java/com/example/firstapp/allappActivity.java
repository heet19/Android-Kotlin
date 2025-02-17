package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class allappActivity {

    ImageButton amazonbtn,flipkatebtn,shoppersstopbtn,lakmebtn,sugarbtn,nykaabtn;

    String[] urls=new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allapp);

        amazonbtn = findViewById(R.id.amazonBtn);
        flipkatebtn = findViewById(R.id.flipkartBtn);
        shoppersstopbtn = findViewById(R.id.shoppersstopBtn);
        lakmebtn = findViewById(R.id.lakmeBtn);
        sugarbtn = findViewById(R.id.sugarBtn);
        nykaabtn = findViewById(R.id.nykaaBtn);

        urls[0]="https://www.amazon.in/";
        urls[1]="https://www.flipkart.com/";
        urls[2]="https://www.shoppersstop.com/";
        urls[3]="https://www.lakmeindia.com/";
        urls[4]="https://www.nykaa.com/";
        urls[5]="https://in.sugarcosmetics.com/";

        amazonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(allappActivity.this,webaActivity.class);
                intent.putExtra("link",urls[0]);
                startActivity(intent);
            }
        });

        flipkatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(allappActivity.this,webaActivity.class);
                intent.putExtra("link",urls[1]);
                startActivity(intent);
            }
        });

        shoppersstopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(allappActivity.this, webaActivity.class);
                intent.putExtra("link",urls[2]);
                startActivity(intent);
            }
        });

        lakmebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(allappActivity.this,webaActivity.class);
                intent.putExtra("link",urls[3]);
                startActivity(intent);
            }
        });

        sugarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(allappActivity.this,webaActivity.class);
                intent.putExtra("link",urls[4]);
                startActivity(intent);
            }
        });

        nykaabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(allappActivity.this,webaActivity.class);
                intent.putExtra("link",urls[5]);
                startActivity(intent);
            }
        });

    }
}