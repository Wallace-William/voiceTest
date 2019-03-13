package com.rangers.voiceprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Activity that allows user to check set settings and options to change them
public class Confirm extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_view);

        Intent intent = getIntent();
        Instance object = intent.getParcelableExtra("Instance");

        TextView precision = findViewById(R.id.precision);
        TextView infill = findViewById(R.id.infill);
        TextView support = findViewById(R.id.support);
        TextView raft = findViewById(R.id.raft);

        Button confirm = findViewById(R.id.confirm_btn);

        precision.setText(String.format("PRECISION: %s", object.getPrecision()));
        infill.setText(String.format("INFILL: %s", object.getInfill()));
        support.setText(String.format("SUPPORT: %s", object.getSupport()));
        raft.setText(String.format("RAFT: %s", object.getRaft()));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirm = new Intent(Confirm.this, Printing.class);
                startActivity(confirm);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent ret = new Intent(Confirm.this, MainActivity.class);
        startActivity(ret);
    }
}
