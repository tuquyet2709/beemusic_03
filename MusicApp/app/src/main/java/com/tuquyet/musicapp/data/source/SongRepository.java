package com.tuquyet.musicapp.data.source;

import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.data.source.local.SongLocalDataSource;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tuquyet on 31/07/2017.
 */
public class SongRepository implements SongDataSource {
    private SongLocalDataSource mSongLocalDataSource;

    public SongRepository(
        SongLocalDataSource songLocalDataSource) {
        mSongLocalDataSource = songLocalDataSource;
    }

    @Override
    public void getSongById(int id) {
        mSongLocalDataSource.getSongById(id);
    }

    @Override
    public void deleteSong(Song song) {
        mSongLocalDataSource.deleteSong(song);
    }

    @Override
    public Observable<List<Song>> getAllSong() {
        return mSongLocalDataSource.getAllSong();
    }
}
