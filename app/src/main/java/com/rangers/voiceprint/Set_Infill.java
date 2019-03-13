package com.rangers.voiceprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Set_Infill extends AppCompatActivity {

    Recognizer voice = Recognizer.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_infill_view);

        voice.initializeSpeech(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        voice.kill();
        Intent ret = new Intent(Set_Infill.this, Set_Precision.class);
        startActivity(ret);
    }
}
