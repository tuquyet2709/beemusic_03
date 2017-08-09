package com.tuquyet.musicapp.data.source;

import com.tuquyet.musicapp.data.model.Artist;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tuquyet on 08/08/2017.
 */
public class ArtistRepository implements ArtistDataSource {
    private ArtistDataSource mArtistRepository;

    public ArtistRepository(ArtistDataSource artistRepository) {
        mArtistRepository = artistRepository;
    }

    @Override
    public void getArtistById(int id) {
        mArtistRepository.getArtistById(id);
    }

    @Override
    public Observable<List<Artist>> getAllArtist() {
        return mArtistRepository.getAllArtist();
    }
}
