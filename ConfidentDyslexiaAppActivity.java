package com.blakeanneberg.confidentdyslexicapp;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.view.View.OnClickListener;


import java.util.HashMap;

//import java.util.Random;

public class ConfidentDyslexiaAppActivity extends Activity implements TextToSpeech.OnInitListener, TextToSpeech.OnUtteranceCompletedListener {

    TextToSpeech tts;

    public static final String TAG = ConfidentDyslexiaAppActivity.class.getSimpleName();

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confident_dyslexic_app);

        //declare our view variables and assign the views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        final TextView tv = (TextView) findViewById(R.id.factTextView);
        final Button speak = (Button) findViewById(R.id.readAloud);
        tts = new TextToSpeech(ConfidentDyslexiaAppActivity.this, ConfidentDyslexiaAppActivity.this);




        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fact = mFactBook.getFact();
                // Update the label with our dynamic fact
                factLabel.setText(fact);

                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
                speak.setTextColor(color);

            }
        };
        showFactButton.setOnClickListener (listener);

        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!tts.isSpeaking()) {
                    HashMap<String, String> params = new HashMap<String, String>();
                    params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
                    tts.speak(tv.getText().toString(), TextToSpeech.QUEUE_ADD, params);
                    speak.setVisibility(Button.GONE);
                } else {
                    tts.stop();
                }

            }

        });
    }


    @Override
    public void onUtteranceCompleted(String UTTERANCE_ID) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(ConfidentDyslexiaAppActivity.this, "Speaking Completed", Toast.LENGTH_SHORT).show();
                    Button btn = (Button) findViewById(R.id.readAloud);
                    btn.setVisibility(Button.VISIBLE);


                }
            });

        }




    @Override
    public void onInit(int status){
        tts.setOnUtteranceCompletedListener(this);
    }

    @Override
    public void onDestroy() {
        if (tts!=null) {
            tts.stop();
            tts.shutdown();
            tts=null;
        }
        super.onDestroy();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_confident_dyslexic_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
