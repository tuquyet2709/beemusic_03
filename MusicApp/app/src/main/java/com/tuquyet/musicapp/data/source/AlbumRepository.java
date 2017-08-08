package com.tuquyet.musicapp.data.source;

import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.source.local.AlbumLocalDataSource;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tuquyet on 08/08/2017.
 */
public class AlbumRepository implements AlbumDataSource {
    private AlbumDataSource mAlbumLocalDataSource;

    public AlbumRepository(
        AlbumDataSource albumDataSource) {
        mAlbumLocalDataSource = albumDataSource;
    }

    @Override
    public void getAlbumById(int id) {
        mAlbumLocalDataSource.getAlbumById(id);
    }

    @Override
    public Observable<List<Album>> getAllAlbum() {
        return mAlbumLocalDataSource.getAllAlbum();
    }
}
