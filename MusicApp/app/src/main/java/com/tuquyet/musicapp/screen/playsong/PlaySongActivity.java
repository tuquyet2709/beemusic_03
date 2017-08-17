package com.tuquyet.musicapp.screen.playsong;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ActivityPlaySongBinding;
import com.tuquyet.musicapp.data.model.Song;

public class PlaySongActivity extends AppCompatActivity {
    public static Song mSong;
    private PlaySongContract.ViewModel mViewModel;
    public static final String EXTRA_SONG = "EXTRA_SONG";
    public static final String BUNDLE_SONG_INFO = "BUNDLE_SONG_INFO";

    public static Intent getPlaySongIntent(Context context, Song song) {
        Intent intent = new Intent(context, PlaySongActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_SONG, song);
        intent.putExtra(BUNDLE_SONG_INFO, bundle);
        mSong = song;
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeTittleBar();
        ActivityPlaySongBinding binding =
            DataBindingUtil.setContentView(this, R.layout.activity_play_song);
        mViewModel = new PlaySongViewModel(this, mSong);
        binding.setViewModel((PlaySongViewModel) mViewModel);
    }

    public void removeTittleBar() {
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
