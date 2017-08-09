package com.tuquyet.musicapp.screen.artist;

import com.tuquyet.musicapp.data.model.Artist;
import com.tuquyet.musicapp.data.source.ArtistDataSource;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tuquyet on 08/08/2017.
 */
public class ArtistPresenter implements ArtistContract.Presenter {
    private ArtistContract.ViewModel mArtistViewModel;
    private ArtistDataSource mAlbumRepository;

    public ArtistPresenter(ArtistContract.ViewModel artistViewModel,
                           ArtistDataSource albumRepository) {
        mArtistViewModel = artistViewModel;
        mAlbumRepository = albumRepository;
    }

    @Override
    public void onStart() {
        mAlbumRepository.getAllArtist().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new Observer<List<Artist>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                }

                @Override
                public void onNext(@NonNull List<Artist> artists) {
                    mArtistViewModel.onGetListSuccess(artists);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    mArtistViewModel.onGetListFailed();
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
    public void getArtistById(int id) {
    }

    @Override
    public void getSongListByArtist(int artistId) {
    }
}
