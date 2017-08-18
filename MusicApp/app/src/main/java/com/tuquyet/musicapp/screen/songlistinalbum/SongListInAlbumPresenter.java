package com.tuquyet.musicapp.screen.songlistinalbum;

import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.data.source.SongRepository;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tuquyet on 17/08/2017.
 */
public class SongListInAlbumPresenter implements SongListInAlbumContract.Presenter {
    private SongListInAlbumViewModel mSongViewModel;
    private SongRepository mSongRepository;
    private int mAlbumID;

    public SongListInAlbumPresenter(SongListInAlbumViewModel songViewModel,
                                    SongRepository songRepository, int albumID) {
        mSongViewModel = songViewModel;
        mSongRepository = songRepository;
        mAlbumID = albumID;
    }

    @Override
    public void onStart() {
        mSongRepository.getListSongByAlbumId(mAlbumID).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new Observer<List<Song>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                }

                @Override
                public void onNext(@NonNull List<Song> songs) {
                    mSongViewModel.onGetListSuccess(songs);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    mSongViewModel.onGetListFailed();
                }

                @Override
                public void onComplete() {
                }
            });
    }

    @Override
    public void onStop() {
    }

    @Override
    public void getSongById(int id) {
    }
}
