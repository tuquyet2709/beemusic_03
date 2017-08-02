package com.tuquyet.musicapp.screen.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.tuquyet.musicapp.R;
import com.tuquyet.musicapp.screen.library.LibraryActivity;

/**
 * Created by tuquyet on 25/07/2017.
 */
public class MainViewModel extends BaseObservable implements MainContract.ViewModel {
    private AppCompatActivity mActivity;
    private Context mContext;
    private LibraryActivity mLibraryActivity;

    public MainViewModel(LibraryActivity libraryActivity) {
        mLibraryActivity = libraryActivity;
    }

    public MainViewModel(AppCompatActivity activity, Context context) {
        mActivity = activity;
        mContext = context;
    }

    public void onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_gallery:
                Intent intent = mLibraryActivity.getLibraryIntent(mContext);
                mContext.startActivity(intent);
                break;
            case R.id.nav_song:
                break;
            case R.id.nav_favorite:
                break;
            case R.id.nav_feedback:
                break;
            default:
                break;
        }
    }

    @Bindable
    public AppCompatActivity getActivity() {
        return mActivity;
    }

    public void setActivity(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
    }

}
