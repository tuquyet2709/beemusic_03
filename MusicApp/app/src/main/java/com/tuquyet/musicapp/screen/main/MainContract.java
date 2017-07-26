package com.tuquyet.musicapp.screen.main;

import com.tuquyet.musicapp.screen.BasePresenter;
import com.tuquyet.musicapp.screen.BaseViewModel;

/**
 * Created by tuquyet on 25/07/2017.
 */
public interface MainContract {
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}