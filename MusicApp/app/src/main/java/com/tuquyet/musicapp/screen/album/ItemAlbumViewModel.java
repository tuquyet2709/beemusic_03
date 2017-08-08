package com.tuquyet.musicapp.screen.album;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;
import com.tuquyet.musicapp.screen.song.SongContract;

/**
 * Created by tuquyet on 07/08/2017.
 */
public class ItemAlbumViewModel extends BaseObservable {
    private Album mAlbum;
    private AlbumContract.ViewModel mViewModel;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Album> mItemClickListener;

    public ItemAlbumViewModel(Album album, BaseRecyclerViewAdapter
        .OnRecyclerViewItemClickListener<Album>
        itemClickListener, AlbumContract.ViewModel viewModel) {
        mAlbum = album;
        mItemClickListener = itemClickListener;
        mViewModel = viewModel;
    }

    @Bindable
    public long getAlbumID() {
        return mAlbum.getAlbumID();
    }

    @Bindable
    public String getAlbumTitle() {
        return mAlbum.getAlbumTitle();
    }

    @Bindable
    public String getAlbumAvatarPath() {
        return mAlbum.getAlbumAvatarPath();
    }

    @Bindable
    public String getAlbumArtist() {
        return mAlbum.getAlbumArtist();
    }

    public void onItemClicked(View view) {
        if (mItemClickListener != null)
            mItemClickListener.onItemRecyclerViewClick(mAlbum);
    }

}
