package com.parsveda.texttospeechtest;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnTest;
    TextToSpeech textToSpeech;

    EditText edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTest = (Button) findViewById(R.id.btnTest);
        edtContent = (EditText) findViewById(R.id.edtContent);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textToSpeech.speak(edtContent.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);


            }
        });


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });


    }
}
