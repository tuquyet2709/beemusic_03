package com.tuquyet.musicapp.screen.artist;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.tuquyet.musicapp.data.model.Artist;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;

/**
 * Created by tuquyet on 08/08/2017.
 */
public class ItemArtistViewModel extends BaseObservable {
    private Artist mArtist;
    private ArtistContract.ViewModel mViewModel;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Artist> mItemClickListener;

    public ItemArtistViewModel(Artist artist, BaseRecyclerViewAdapter
        .OnRecyclerViewItemClickListener<Artist>
        itemClickListener, ArtistContract.ViewModel viewModel) {
        mArtist = artist;
        mItemClickListener = itemClickListener;
        mViewModel = viewModel;
    }

    @Bindable
    public long getArtistID() {
        return mArtist.getArtistID();
    }

    @Bindable
    public String getArtistName() {
        return mArtist.getArtistName();
    }

    @Bindable
    public int getArtistSongCount() {
        return mArtist.getArtistSongCount();
    }
    public void onItemClicked(View view) {
        if (mItemClickListener != null)
            mItemClickListener.onItemRecyclerViewClick(mArtist);
    }

}
