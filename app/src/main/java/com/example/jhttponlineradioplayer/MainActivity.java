package com.example.jhttponlineradioplayer;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button play;
    private String string;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        play = findViewById(R.id.play);
        play.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        buttonAnimation(play);
        if (mp == null){
        string = editText.getText().toString();
        if(string.equals("")){
            Toast.makeText(this, "Empty link", Toast.LENGTH_SHORT).show();
        }else {
        mp = MediaPlayer.create(MainActivity.this, Uri.parse(string));
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer p) {
                p.start();
            }
        });
            Toast.makeText(this, "starting...", Toast.LENGTH_SHORT).show();
        }
        } else{

            Toast.makeText(this, "Already playing!", Toast.LENGTH_SHORT).show();
        }


    }

    public void buttonAnimation(Button button){
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animate);
        animator.setTarget(button);
        animator.start();
    }
}

