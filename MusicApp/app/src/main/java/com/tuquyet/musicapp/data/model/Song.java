package com.tuquyet.musicapp.data.model;

import android.graphics.drawable.Drawable;

/**
 * Created by tuquyet on 31/07/2017.
 */
public class Song {
    private long mSongID;
    private String mSongTitle;
    private Drawable mSongAvatar;
    private String mSongArtist;

    public Song(long songID, Drawable songAvatar, String songTitle, String songArtist) {
        mSongID = songID;
        mSongAvatar = songAvatar;
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

    public Drawable getSongAvatar() {
        return mSongAvatar;
    }

    public void setSongAvatar(Drawable songAvatar) {
        mSongAvatar = songAvatar;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public void setSongArtist(String songArtist) {
        mSongArtist = songArtist;
    }
}
