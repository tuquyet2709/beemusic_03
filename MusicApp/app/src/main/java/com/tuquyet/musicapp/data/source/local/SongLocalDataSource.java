package com.tuquyet.musicapp.data.source.local;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.data.source.SongDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by tuquyet on 31/07/2017.
 */
public class SongLocalDataSource implements SongDataSource {
    private Context mContext;
    private ContentResolver mContentResolver;

    public SongLocalDataSource(Context context, ContentResolver contentResolver) {
        mContext = context;
        mContentResolver = contentResolver;
    }

    @Override
    public void getSongById(int id) {
    }

    @Override
    public Observable<List<Song>> getAllSong() {
        return Observable.create(new ObservableOnSubscribe<List<Song>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Song>> e) throws Exception {
                List<Song> songList = new ArrayList<>();
                Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                Cursor songCursor = mContentResolver.query(songUri, null, null, null, null);
                if (songCursor != null && songCursor.moveToFirst()) {
                    int songAlbumID = songCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
                    int songId = songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
                    int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
                    int songArtist = songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
                    do {
                        String currentAlbumID = songCursor.getString(songAlbumID);
                        long currentId = songCursor.getLong(songId);
                        String currentTitle = songCursor.getString(songTitle);
                        String currentArtist = songCursor.getString(songArtist);
                        String currentAlbumArtPath =
                            createSongAlbumArtPathFromAlbumID(currentAlbumID);
                        songList
                            .add(new Song(currentId, currentAlbumArtPath,
                                currentTitle,
                                currentArtist));
                    } while (songCursor.moveToNext());
                    e.onNext(songList);
                } else {
                    e.onError(new NullPointerException());
                }
                e.onComplete();
            }
        });
    }

    @Override
    public Observable<List<Song>> getSongsByAlbumId(final int id) {
        return Observable.create(new ObservableOnSubscribe<List<Song>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Song>> e) throws Exception {
                List<Song> songList = new ArrayList<>();
                Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                Cursor songCursor = mContentResolver.query(songUri,
                    new String[]{MediaStore.Audio.Media.ALBUM_ID, MediaStore.Audio.Media._ID,
                        MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST},
                    MediaStore.Audio.Media.ALBUM_ID + "=?", new String[]{String.valueOf(id)}, null);
                if (songCursor != null && songCursor.moveToFirst()){
                    int songId = songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
                    int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
                    int songArtist = songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
                    do{
                        long currentId = songCursor.getLong(songId);
                        String currentTitle = songCursor.getString(songTitle);
                        String currentArtist = songCursor.getString(songArtist);
                        String currentAlbumArtPath =
                            createSongAlbumArtPathFromAlbumID(String.valueOf(id));
                        songList
                            .add(new Song(currentId, currentAlbumArtPath,
                                currentTitle,
                                currentArtist));
                    }while (songCursor.moveToNext());
                    e.onNext(songList);
                } else {
                    e.onError(new NullPointerException());
                }
                e.onComplete();
            }
        }) ;
    }

    @Override
    public void deleteSong(Song song) {
    }

    private String createSongAlbumArtPathFromAlbumID(String songAlbumID) {
        String result = null;
        Uri songUri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
        Cursor cursor = mContentResolver.query(MediaStore.Audio.Albums
                .EXTERNAL_CONTENT_URI,
            new String[]{MediaStore.Audio.Albums._ID, MediaStore.Audio.Albums.ALBUM_ART},
            MediaStore.Audio.Albums._ID + "=?",
            new String[]{String.valueOf(songAlbumID)},
            null);
        if (cursor.moveToFirst()) {
            result = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums
                .ALBUM_ART));
        }
        return result;
    }
}
