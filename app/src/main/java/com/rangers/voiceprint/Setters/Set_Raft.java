package com.rangers.voiceprint.Setters;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rangers.voiceprint.MainActivity;
import com.rangers.voiceprint.R;
import com.rangers.voiceprint.Recognizer;

public class Set_Raft extends AppCompatActivity {

    Recognizer voice = Recognizer.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_raft_view);

        voice.initializeSpeech(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        voice.kill();
        Intent ret = new Intent(Set_Raft.this, Set_Infill.class);
        startActivity(ret);
    }
}
