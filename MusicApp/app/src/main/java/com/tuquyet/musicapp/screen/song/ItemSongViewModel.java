package com.tuquyet.musicapp.screen.song;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;

/**
 * Created by tuquyet on 31/07/2017.
 */
public class ItemSongViewModel extends BaseObservable {
    private Song mSong;
    private SongFragment mSongFragment;
    private SongContract.ViewModel mViewModel;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Song> mItemClickListener;

    public ItemSongViewModel(Song song, BaseRecyclerViewAdapter
        .OnRecyclerViewItemClickListener<Song>
        itemClickListener, SongContract.ViewModel viewModel) {
        mSong = song;
        mItemClickListener = itemClickListener;
        mViewModel = viewModel;
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
    public Drawable getSongAvatar() {
        return mSong.getSongAvatar();
    }

    @Bindable
    public String getSongArtist() {
        return mSong.getSongArtist();
    }

    public void onItemClicked(View view) {
        if (mItemClickListener != null)
            mItemClickListener.onItemRecyclerViewClick(mSong);
    }
    public void onDeleteClicked(View view) {
        mViewModel.onDeleteClicked(mSong);
    }

}