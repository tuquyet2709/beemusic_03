package com.tuquyet.musicapp.screen.album;

import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.source.AlbumDataSource;
import com.tuquyet.musicapp.data.source.AlbumRepository;
import com.tuquyet.musicapp.data.source.SongRepository;
import com.tuquyet.musicapp.screen.song.SongViewModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tuquyet on 07/08/2017.
 */
public final class AlbumPresenter implements AlbumContract.Presenter {
    private AlbumContract.ViewModel mAlbumViewModel;
    private AlbumDataSource mAlbumRepository;

    public AlbumPresenter(AlbumViewModel albumViewModel,
                          AlbumRepository albumRepository) {
        mAlbumViewModel = albumViewModel;
        mAlbumRepository = albumRepository;
    }

    @Override
    public void onStart() {
        mAlbumRepository.getAllAlbum().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new Observer<List<Album>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                }

                @Override
                public void onNext(@NonNull List<Album> albums) {
                    mAlbumViewModel.onGetListSuccess(albums);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    mAlbumViewModel.onGetListFailed();
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
    public void getAlbumById(int id) {
    }

    @Override
    public void getSongListByAlbum(int albumId) {
    }
}
