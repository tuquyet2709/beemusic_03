package com.tuquyet.musicapp.screen.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.tuquyet.musicapp.R;

/**
 * Created by tuquyet on 25/07/2017.
 */
public class MainViewModel extends BaseObservable implements MainContract.ViewModel {
    private AppCompatActivity mActivity;
    private Context mContext;

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public MainViewModel(AppCompatActivity activity) {
        mActivity = activity;
    }

    public void onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_gallery:
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
