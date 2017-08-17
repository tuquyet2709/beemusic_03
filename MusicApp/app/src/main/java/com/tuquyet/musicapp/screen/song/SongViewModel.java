package com.tuquyet.musicapp.screen.song;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tuquyet.musicapp.R;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.playsong.PlaySongActivity;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tuquyet on 31/07/2017.
 */
public class SongViewModel extends BaseObservable implements BaseRecyclerViewAdapter
    .OnRecyclerViewItemClickListener<Song>, SongContract.ViewModel {
    private SongContract.Presenter mPresenter;
    private Context mContext;
    private SongAdapter mAdapter;

    public SongViewModel(Context context, SongAdapter adapter) {
        mAdapter = adapter;
        mAdapter.setItemClickListener(this);
        mAdapter.setSongViewModel(this);
        mContext = context;
    }

    @Bindable
    public SongAdapter getAdapter() {
        return mAdapter;
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
    public void setPresenter(SongContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onGetSongByIdSuccess(Song song) {
    }

    @Override
    public void onGetSongByIdFail(String msg) {
    }

    @Override
    public void onDeleteSuccess(Song song) {
        //Remove from Adapter
        mAdapter.deleteSong(song);
    }

    @Override
    public void onDeleteFail() {
        Toast.makeText(mContext, R.string.cant_delete_this_song, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetListSuccess(List<Song> list) {
        mAdapter.setSongList(list);
    }

    @Override
    public void onGetListFailed() {
        Toast.makeText(mContext, R.string.cant_get_your_data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteClicked(Song song) {
        mPresenter.deleteSong(song);
    }

    @Override
    public void onItemRecyclerViewClick(Song item) {
        Intent intent = PlaySongActivity.getPlaySongIntent(mContext, item);
        mContext.startActivity(intent);
    }
}
