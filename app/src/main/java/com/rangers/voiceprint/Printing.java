package com.rangers.voiceprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Printing extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.printing_view);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent ret = new Intent(Printing.this, MainActivity.class);
        startActivity(ret);
    }
}
