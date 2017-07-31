package com.tuquyet.musicapp.screen.library;

import com.tuquyet.musicapp.screen.BasePresenter;
import com.tuquyet.musicapp.screen.BaseViewModel;
import com.tuquyet.musicapp.screen.main.MainContract;

/**
 * Created by tuquyet on 30/07/2017.
 */
public interface LibraryContract {
    interface ViewModel extends BaseViewModel<MainContract.Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
