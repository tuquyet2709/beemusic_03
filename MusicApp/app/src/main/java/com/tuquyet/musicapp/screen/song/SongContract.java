package com.tuquyet.musicapp.screen.song;

import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BasePresenter;
import com.tuquyet.musicapp.screen.BaseViewModel;

import java.util.List;

/**
 * Created by tuquyet on 31/07/2017.
 */
public interface SongContract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void onGetSongByIdSuccess(Song song);
        void onGetSongByIdFail(String msg);
        void onDeleteSuccess(Song song);
        void onDeleteFail();
        void onGetListSuccess(List<Song> list);
        void onGetListFailed();
        void onDeleteClicked(Song song);
    }

    interface Presenter extends BasePresenter {
        void deleteSong(Song song);
        void getSongById(int id);
    }

}
