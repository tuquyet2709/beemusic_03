package com.tuquyet.musicapp.screen.songlistinalbum;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;

import com.example.tuquyet.musicapp.R;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;
import com.tuquyet.musicapp.screen.playsong.PlaySongActivity;
import com.tuquyet.musicapp.screen.song.SongAdapter;

import java.util.List;

/**
 * Created by tuquyet on 17/08/2017.
 */
public class SongListInAlbumViewModel extends BaseObservable implements BaseRecyclerViewAdapter
    .OnRecyclerViewItemClickListener<Song>, SongListInAlbumContract.ViewModel  {
    private SongListInAlbumContract.Presenter mPresenter;
    private Context mContext;
    private SongListInAlbumAdapter mAdapter;

    public SongListInAlbumViewModel(Context context, SongListInAlbumAdapter adapter) {
        mAdapter = adapter;
        mAdapter.setItemClickListener(this);
        mAdapter.setSongViewModel(this);
        mContext = context;
    }
    @Bindable
    public SongListInAlbumAdapter getAdapter() {
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
    public void setPresenter(SongListInAlbumContract.Presenter presenter) {
        mPresenter = presenter;
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
    public void onItemRecyclerViewClick(Song item) {
        Intent intent = PlaySongActivity.getPlaySongIntent(mContext, item);
        mContext.startActivity(intent);
    }
}
