package com.tuquyet.musicapp.data.model;

import android.graphics.drawable.Drawable;

/**
 * Created by tuquyet on 31/07/2017.
 */
public class Song {
    private long mSongID;
    private String mSongTitle;
    private String mSongAvatarPath;
    private String mSongArtist;

    public Song(long songID, String songAvatarPath, String songTitle, String songArtist) {
        mSongID = songID;
        mSongAvatarPath = songAvatarPath;
        mSongTitle = songTitle;
        mSongArtist = songArtist;
    }

    public long getSongID() {
        return mSongID;
    }

    public void setSongID(long songID) {
        mSongID = songID;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public void setSongTitle(String songTitle) {
        mSongTitle = songTitle;
    }

    public String getSongAvatarPath() {
        return mSongAvatarPath;
    }

    public void setSongAvatarPath(String songAvatarPath) {
        mSongAvatarPath = songAvatarPath;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public void setSongArtist(String songArtist) {
        mSongArtist = songArtist;
    }
}
