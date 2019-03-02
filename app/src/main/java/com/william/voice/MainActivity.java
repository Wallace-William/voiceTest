package com.william.voice;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    TextView mTextTv;
    ImageButton mVoiceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speak();

        mTextTv = findViewById(R.id.output_textView);
//        mVoiceBtn = findViewById(R.id.voiceBtn);
//
//        mVoiceBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                speak();
//            }
//        });


    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "SAY SOMETHING");
        
        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
            
        } catch (Exception e) {
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null!=data) {
                    ArrayList<String> result;
                    result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    switch (result.get(0)) {
                        case "print":
                            Intent print = new Intent(MainActivity.this, Print.class);

                            startActivity(print);
                            break;
                        case "settings":
                            Intent settings = new Intent(MainActivity.this, Settings.class);

                            startActivity(settings);
                            break;
                        default:
                            mTextTv.setText(result.get(0));
                            break;
                    }

                }
                break;
            }
        }
    }


}
