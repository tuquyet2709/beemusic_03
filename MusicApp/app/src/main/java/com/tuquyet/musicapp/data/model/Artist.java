package com.tuquyet.musicapp.data.model;

/**
 * Created by tuquyet on 09/08/2017.
 */
public class Artist {
    private long mArtistID;
    private String mArtistName;
    private int mArtistSongCount;

    public Artist(long artistID, String artistName, int artistSongCount) {
        mArtistID = artistID;
        mArtistName = artistName;
        mArtistSongCount = artistSongCount;
    }

    public long getArtistID() {
        return mArtistID;
    }

    public void setArtistID(long artistID) {
        mArtistID = artistID;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public void setArtistName(String artistName) {
        mArtistName = artistName;
    }

    public int getArtistSongCount() {
        return mArtistSongCount;
    }

    public void setArtistSongCount(int artistSongCount) {
        mArtistSongCount = artistSongCount;
    }
}
