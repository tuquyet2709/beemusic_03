package com.tuquyet.musicapp.screen.artist;

import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.model.Artist;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BasePresenter;
import com.tuquyet.musicapp.screen.BaseViewModel;
import com.tuquyet.musicapp.screen.album.AlbumContract;

import java.util.List;

/**
 * Created by tuquyet on 08/08/2017.
 */
public interface ArtistContract {
    interface ViewModel extends BaseViewModel<ArtistContract.Presenter> {
        void onGetArtistByIdSuccess(Song song);
        void onGetArtistByIdFail(String msg);
        void onGetListSuccess(List<Artist> list);
        void onGetListFailed();
    }

    interface Presenter extends BasePresenter {
        void getArtistById(int id);
        void getSongListByArtist(int artistId);
    }
}
