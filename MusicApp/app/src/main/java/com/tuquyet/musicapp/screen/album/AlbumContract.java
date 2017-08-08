package com.tuquyet.musicapp.screen.album;

import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BasePresenter;
import com.tuquyet.musicapp.screen.BaseViewModel;

import java.util.List;

/**
 * Created by tuquyet on 07/08/2017.
 */
public interface AlbumContract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetAlbumByIdSuccess(Song song);
        void onGetAlbumByIdFail(String msg);
        void onGetListSuccess(List<Album> list);
        void onGetListFailed();
    }

    interface Presenter extends BasePresenter {
        void getAlbumById(int id);
        void getSongListByAlbum(int albumId);
    }
}
