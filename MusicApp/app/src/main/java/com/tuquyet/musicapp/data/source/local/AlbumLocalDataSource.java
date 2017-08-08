package com.tuquyet.musicapp.data.source.local;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.source.AlbumDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by tuquyet on 08/08/2017.
 */
public class AlbumLocalDataSource implements AlbumDataSource {
    private Context mContext;
    private ContentResolver mContentResolver;

    public AlbumLocalDataSource(Context context, ContentResolver contentResolver) {
        mContext = context;
        mContentResolver = contentResolver;
    }

    @Override
    public void getAlbumById(int id) {
    }

    @Override
    public Observable<List<Album>> getAllAlbum() {
        return Observable.create(new ObservableOnSubscribe<List<Album>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Album>> e) throws Exception {
                List<Album> albumList = new ArrayList<>();
                Uri albumUri = MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
                Cursor albumCursor = mContentResolver.query(albumUri, null, null, null, null);
                if (albumCursor != null && albumCursor.moveToFirst()) {
                    int albumID = albumCursor.getColumnIndex(MediaStore.Audio.Albums._ID);
                    int albumTitle = albumCursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM);
                    int albumArtist = albumCursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST);
                    int albumArtPath = albumCursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART);
                    do {
                        long currentID = albumCursor.getLong(albumID);
                        String currentTitle = albumCursor.getString(albumTitle);
                        String currentArtist = albumCursor.getString(albumArtist);
                        String currentAlbumArtPath = albumCursor.getString(albumArtPath);
                        albumList
                            .add(new Album(currentID, currentTitle, currentAlbumArtPath,
                                currentArtist));
                    } while (albumCursor.moveToNext());
                    e.onNext(albumList);
                } else {
                    e.onError(new NullPointerException());
                }
                e.onComplete();
            }
        });
    }
}
