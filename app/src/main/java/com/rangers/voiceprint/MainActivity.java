package com.rangers.voiceprint;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_btn = findViewById(R.id.start_btn);

        //Ask for user permission to record audio
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            doPermAudio();
        }

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start = new Intent(MainActivity.this, Set_Precision.class);
                startActivity(start);

            }
        });

    }

    //Method used to get permission
    void doPermAudio()
    {
        int MY_PERMISSIONS_RECORD_AUDIO = 1;
        MainActivity thisActivity = this;

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(thisActivity,
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    MY_PERMISSIONS_RECORD_AUDIO);
        }
    }
}
