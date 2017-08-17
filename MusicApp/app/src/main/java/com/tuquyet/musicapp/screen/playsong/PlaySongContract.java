package com.tuquyet.musicapp.screen.playsong;

import android.view.View;

import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BasePresenter;
import com.tuquyet.musicapp.screen.BaseViewModel;

/**
 * Created by tuquyet on 17/08/2017.
 */
public interface PlaySongContract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void onFavoriteButtonClicked(View view);
        void onFavoriteSuccess();
        void onFavoriteFailed();
    }

    interface Presenter extends BasePresenter {
        void setFavorite(Song song);
    }
}
