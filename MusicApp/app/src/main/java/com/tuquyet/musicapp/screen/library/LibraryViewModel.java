package com.tuquyet.musicapp.screen.library;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.tuquyet.musicapp.R;
import com.tuquyet.musicapp.screen.main.MainContract;

/**
 * Created by tuquyet on 29/07/2017.
 */
public class LibraryViewModel extends BaseObservable implements LibraryContract.ViewModel {
    private LibraryActivity mLibraryActivity;
    private LibraryAdapter mLibraryAdapter;

    public LibraryAdapter getLibraryAdapter() {
        return mLibraryAdapter;
    }

    public void setLibraryAdapter(LibraryAdapter adapter) {
        mLibraryAdapter = adapter;
    }

    public LibraryViewModel(LibraryActivity libraryActivity,
                            LibraryAdapter adapter) {
        adapter.addFragment(new PlaylistFragment(), libraryActivity.getString(R.string
            .playlists));
        adapter.addFragment(new SingerFragment(), libraryActivity.getString(R.string.singer));
        adapter.addFragment(new SongFragment(), libraryActivity.getString(R.string.title_song));
        adapter.addFragment(new AlbumFragment(), libraryActivity.getString(R.string.album));
        mLibraryActivity = libraryActivity;
        mLibraryAdapter = adapter;
    }

    @Bindable
    public LibraryActivity getLibraryActivity() {
        return mLibraryActivity;
    }

    public void setLibraryActivity(LibraryActivity libraryActivity) {
        mLibraryActivity = libraryActivity;
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
