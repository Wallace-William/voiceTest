package com.william.voice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);

        Button connect_btn = findViewById(R.id.connect_btn);
        Button print_btn = findViewById(R.id.print_btn);
        Button settings_btn = findViewById(R.id.settings_btn);

        ImageButton mVoiceBtn = findViewById(R.id.voiceBtn);

        connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            }
        });

        print_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Welcome.this, Print.class);
                startActivity(intent);

            }
        });

        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Welcome.this, Settings.class);
                startActivity(intent);

            }
        });

        mVoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Welcome.this, Voice.class);
                startActivity(intent);
            }
        });





    }

}
