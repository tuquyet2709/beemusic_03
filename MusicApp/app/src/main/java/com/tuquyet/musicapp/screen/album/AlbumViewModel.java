package com.tuquyet.musicapp.screen.album;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;

import com.example.tuquyet.musicapp.R;
import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;
import com.tuquyet.musicapp.screen.song.SongAdapter;
import com.tuquyet.musicapp.screen.song.SongContract;

import java.util.List;

/**
 * Created by tuquyet on 07/08/2017.
 */
public class AlbumViewModel extends BaseObservable implements BaseRecyclerViewAdapter
    .OnRecyclerViewItemClickListener<Album>, AlbumContract.ViewModel {
    private AlbumContract.Presenter mPresenter;
    private Context mContext;
    private AlbumAdapter mAdapter;

    public AlbumViewModel(Context context, AlbumAdapter adapter) {
        mAdapter = adapter;
        mAdapter.setItemClickListener(this);
        mAdapter.setAlbumViewModel(this);
        mContext = context;
    }

    @Bindable
    public AlbumAdapter getAdapter() {
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
    public void setPresenter(AlbumContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onGetAlbumByIdSuccess(Song song) {
    }

    @Override
    public void onGetAlbumByIdFail(String msg) {
    }

    @Override
    public void onGetListSuccess(List<Album> list) {
        mAdapter.setAlbumList(list);
    }

    @Override
    public void onGetListFailed() {
        Toast.makeText(mContext, R.string.cant_get_your_data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemRecyclerViewClick(Album item) {
        //Intent to....
    }
}
