package com.tuquyet.musicapp.data.source.local;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.model.Artist;
import com.tuquyet.musicapp.data.source.ArtistDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

/**
 * Created by tuquyet on 08/08/2017.
 */
public class ArtistLocalDataSource implements ArtistDataSource {
    private Context mContext;
    private ContentResolver mContentResolver;

    public ArtistLocalDataSource(Context context, ContentResolver contentResolver) {
        mContext = context;
        mContentResolver = contentResolver;
    }

    @Override
    public void getArtistById(int id) {
    }

    @Override
    public Observable<List<Artist>> getAllArtist() {
        return Observable.create(new ObservableOnSubscribe<List<Artist>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Artist>> e) throws Exception {
                List<Artist> artistList = new ArrayList<>();
                Uri artistUri = MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI;
                Cursor artistCursor = mContentResolver.query(artistUri, null, null, null, null);
                if (artistCursor != null && artistCursor.moveToFirst()) {
                    int artistID = artistCursor.getColumnIndex(MediaStore.Audio.Artists._ID);
                    int artistName = artistCursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST);
                    int artistSongCount = artistCursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_TRACKS);
                    do {
                        long currentID = artistCursor.getLong(artistID);
                        String currentName = artistCursor.getString(artistName);
                        int currentArtistSongCount = artistCursor.getInt(artistSongCount);
                        artistList
                            .add(new Artist(currentID, currentName, currentArtistSongCount));
                    } while (artistCursor.moveToNext());
                    e.onNext(artistList);
                } else {
                    e.onError(new NullPointerException());
                }
                e.onComplete();
            }
        });
    }
}
