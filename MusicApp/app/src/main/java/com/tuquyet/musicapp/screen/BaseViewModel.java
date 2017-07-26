package com.tuquyet.musicapp.screen;

/**
 * Created by tuquyet on 26/07/2017.
 */
public interface BaseViewModel<T extends BasePresenter> {

    void onStart();

    void onStop();

    void setPresenter(T presenter);
}