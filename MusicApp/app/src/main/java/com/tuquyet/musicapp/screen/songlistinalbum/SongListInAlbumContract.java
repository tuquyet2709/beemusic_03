package com.tuquyet.musicapp.screen.songlistinalbum;

import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BasePresenter;
import com.tuquyet.musicapp.screen.BaseViewModel;

import java.util.List;

/**
 * Created by tuquyet on 17/08/2017.
 */
public interface SongListInAlbumContract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetListSuccess(List<Song> list);
        void onGetListFailed();
    }

    interface Presenter extends BasePresenter {
        void getSongById(int id);
    }
}
