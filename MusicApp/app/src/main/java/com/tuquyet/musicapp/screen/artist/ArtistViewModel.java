package com.tuquyet.musicapp.screen.artist;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;

import com.example.tuquyet.musicapp.R;
import com.tuquyet.musicapp.data.model.Artist;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;

import java.util.List;

/**
 * Created by tuquyet on 08/08/2017.
 */
public class ArtistViewModel extends BaseObservable implements BaseRecyclerViewAdapter
    .OnRecyclerViewItemClickListener<Artist>, ArtistContract.ViewModel {
    private ArtistContract.Presenter mPresenter;
    private Context mContext;
    private ArtistAdapter mAdapter;

    public ArtistViewModel(Context context,
                           ArtistAdapter adapter) {
        mAdapter = adapter;
        mAdapter.setItemClickListener(this);
        mAdapter.setArtistViewModel(this);
        mContext = context;
    }

    @Bindable
    public ArtistAdapter getAdapter() {
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
    public void setPresenter(ArtistContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onGetArtistByIdSuccess(Song song) {
    }

    @Override
    public void onGetArtistByIdFail(String msg) {
    }

    @Override
    public void onGetListSuccess(List<Artist> list) {
        mAdapter.setArtistList(list);
    }

    @Override
    public void onGetListFailed() {
        Toast.makeText(mContext, R.string.cant_get_your_data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemRecyclerViewClick(Artist item) {
    }
}
