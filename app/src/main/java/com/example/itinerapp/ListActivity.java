package com.example.itinerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();

        TextView fromCity = findViewById(R.id.from_field);
        TextView toCity = findViewById(R.id.to_field);
        TextView date = findViewById(R.id.date_field);
        LinearLayout listItems = findViewById(R.id.list_items);
        Button backBtn = findViewById(R.id.back_btn);

        fromCity.setText(intent.getStringExtra("from"));
        toCity.setText(intent.getStringExtra("to"));
        date.setText(intent.getStringExtra("date"));

        LinearLayout.LayoutParams cardLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                120
        );

        LinearLayout.LayoutParams viewsParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        LinearLayout.LayoutParams trainParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        trainParams.gravity = Gravity.CENTER_VERTICAL;
        trainParams.leftMargin = 400;

        viewsParams.gravity = Gravity.CENTER_VERTICAL;
        viewsParams.leftMargin = 20;


        cardLayoutParams.gravity = Gravity.CENTER;
        cardLayoutParams.leftMargin = 100;
        cardLayoutParams.rightMargin = 100;
        cardLayoutParams.bottomMargin = 50;



        for (int i = 0; i < 7; i++) {

            LinearLayout card = new LinearLayout(getApplicationContext());
            card.setMinimumHeight(40);
            card.setLayoutParams(cardLayoutParams);
            card.setBackgroundColor(0x1a808080);

            TextView startH = new TextView(getApplicationContext());
            TextView endH = new TextView(getApplicationContext());
            ImageView arrow = new ImageView(getApplicationContext());
            TextView train = new TextView(getApplicationContext());

            startH.setLayoutParams(viewsParams);
            endH.setLayoutParams(viewsParams);
            train.setLayoutParams(trainParams);
            arrow.setLayoutParams(viewsParams);
            arrow.setImageResource(R.drawable.ic_baseline_arrow_forward_24);

            train.setText(R.string.train);
            startH.setText("0" + Math.round(Math.random()*9) +":"+ Math.round(Math.random()*9) + Math.round(Math.random()*9));
            endH.setText("0" + Math.round(Math.random()*9) +":"+ Math.round(Math.random()*9) + Math.round(Math.random()*9));

            card.addView(startH);
            card.addView(arrow);
            card.addView(endH);
            card.addView(train);

            listItems.addView(card);

        }

        backBtn.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);

            startActivity(intent1);
        });










    }
}