package com.tuquyet.musicapp.data.model;

/**
 * Created by tuquyet on 07/08/2017.
 */
public class Album {
    private long mAlbumID;
    private String mAlbumTitle;
    private String mAlbumAvatarPath;
    private String mAlbumArtist;

    public Album(long albumID, String albumTitle, String albumAvatarPath, String albumArtist) {
        mAlbumID = albumID;
        mAlbumTitle = albumTitle;
        mAlbumAvatarPath = albumAvatarPath;
        mAlbumArtist = albumArtist;
    }

    public long getAlbumID() {
        return mAlbumID;
    }

    public void setAlbumID(long albumID) {
        mAlbumID = albumID;
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        mAlbumTitle = albumTitle;
    }

    public String getAlbumAvatarPath() {
        return mAlbumAvatarPath;
    }

    public void setAlbumAvatarPath(String albumAvatarPath) {
        mAlbumAvatarPath = albumAvatarPath;
    }

    public String getAlbumArtist() {
        return mAlbumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        mAlbumArtist = albumArtist;
    }
}
