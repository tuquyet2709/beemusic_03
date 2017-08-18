package com.tuquyet.musicapp.screen.songlistinalbum;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;

/**
 * Created by tuquyet on 17/08/2017.
 */
public class ItemSongInAlbumViewModel extends BaseObservable{
    private Song mSong;
    private SongListInAlbumContract.ViewModel mViewModel;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Song> mItemClickListener;

    public ItemSongInAlbumViewModel(Song song, BaseRecyclerViewAdapter
        .OnRecyclerViewItemClickListener<Song>
        itemClickListener, SongListInAlbumContract.ViewModel viewModel) {
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
    public String getSongAvatarPath() {
        return mSong.getSongAvatarPath();
    }

    @Bindable
    public String getSongArtist() {
        return mSong.getSongArtist();
    }

    public void onItemClicked(View view) {
        if (mItemClickListener != null)
            mItemClickListener.onItemRecyclerViewClick(mSong);
    }
}
