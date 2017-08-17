package com.tuquyet.musicapp.screen.playsong;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.tuquyet.musicapp.data.model.Song;

/**
 * Created by tuquyet on 17/08/2017.
 */
public class PlaySongViewModel extends BaseObservable implements PlaySongContract.ViewModel {
    private PlaySongContract.Presenter mPresenter;
    private Context mContext;
    private Song mSong;

    public PlaySongViewModel(Context context, Song song) {
        mContext = context;
        mSong = song;
    }

    public Song getSong() {
        return mSong;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(PlaySongContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void onGetSongSuccess(Song song) {
    }

    public void onGetSongFailed(Song song) {
    }

    public void onPlayButtonClicked(View view) {
    }

    public void playSong() {
    }

    public void pauseSong() {
    }

    public void onNextButtonClicked(View view) {
    }

    public void nextSong() {
    }

    public void onPreviousButtonClicked(View view) {
    }

    public void previousSong() {
    }

    @Override
    public void onFavoriteButtonClicked(View view) {
    }

    @Override
    public void onFavoriteSuccess() {
    }

    @Override
    public void onFavoriteFailed() {
    }

    @Bindable
    public long getSongID() {
        return mSong.getSongID();
    }

    @Bindable
    public String getSongTitle() {
        return mSong.getSongTitle();
    }

    @Bindable
    public String getSongAvatarPath() {
        return mSong.getSongAvatarPath();
    }

    @Bindable
    public String getSongArtist() {
        return mSong.getSongArtist();
    }
}
