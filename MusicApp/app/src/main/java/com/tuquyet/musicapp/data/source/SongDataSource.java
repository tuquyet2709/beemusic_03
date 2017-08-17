package com.tuquyet.musicapp.data.source;

import com.tuquyet.musicapp.data.model.Song;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tuquyet on 31/07/2017.
 */
public interface SongDataSource {
    void getSongById(int id);
    Observable<List<Song>> getAllSong();
    Observable<List<Song>> getSongsByAlbumId(int id);
    void deleteSong(Song song);
}