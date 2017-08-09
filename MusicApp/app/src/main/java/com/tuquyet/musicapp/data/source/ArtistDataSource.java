package com.tuquyet.musicapp.data.source;

import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.model.Artist;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tuquyet on 08/08/2017.
 */
public interface ArtistDataSource {
    void getArtistById(int id);
    Observable<List<Artist>> getAllArtist();
}
