package com.example.eduardopalacios.buscadoryoutube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Main3Activity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,YouTubePlayer.PlaybackEventListener {

    YouTubePlayerView youTubePlayerView;
    String claveVideo;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        youTubePlayerView=findViewById(R.id.vistaYoutube);
        youTubePlayerView.initialize("AIzaSyAE2a0ti4DL-Ss3z66UgqAqAxYjhLe_XAk",this);
        Bundle bundle=getIntent().getExtras();
        claveVideo=bundle.getString("id_video");

    }

    @Override
    public void onInitializationSuccess (YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean restaurado) {

        if (! restaurado)
        {
            youTubePlayer.cueVideo(claveVideo);
        }
        else {
            Toast.makeText(getApplicationContext(),"RESTAURADO",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onInitializationFailure (YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    public void onPlaying () {

    }

    @Override
    public void onPaused () {

    }

    @Override
    public void onStopped () {

    }

    @Override
    public void onBuffering (boolean b) {

    }

    @Override
    public void onSeekTo (int i) {

    }
}
