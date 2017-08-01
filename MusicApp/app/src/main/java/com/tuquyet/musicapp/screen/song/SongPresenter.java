package com.tuquyet.musicapp.screen.song;

import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.data.source.SongRepository;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tuquyet on 31/07/2017.
 */
public final class SongPresenter implements SongContract.Presenter {
    private SongViewModel mSongViewModel;
    private SongRepository mSongRepository;

    public SongPresenter(SongViewModel songViewModel,
                         SongRepository songRepository) {
        mSongViewModel = songViewModel;
        mSongRepository = songRepository;
    }

    @Override
    public void onStart() {
        mSongRepository.getAllSong().subscribeOn(Schedulers.io())
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
    public void deleteSong(Song song) {
    }

    @Override
    public void getSongById(int id) {
    }
}
