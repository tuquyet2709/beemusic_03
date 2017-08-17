package com.tuquyet.musicapp.screen.playsong;

import android.content.Context;

import com.tuquyet.musicapp.data.model.Song;

/**
 * Created by tuquyet on 17/08/2017.
 */
public final class PlaySongPresenter implements PlaySongContract.Presenter {
    private PlaySongContract.ViewModel mPlaySongViewModel;
    private Context mContext;

    public PlaySongPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void setFavorite(Song song) {
    }
}

