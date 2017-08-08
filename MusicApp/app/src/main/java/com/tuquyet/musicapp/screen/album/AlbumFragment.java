package com.tuquyet.musicapp.screen.album;

import android.content.ContentResolver;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.FragmentAlbumBinding;
import com.example.tuquyet.musicapp.databinding.FragmentSongBinding;
import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.data.source.AlbumRepository;
import com.tuquyet.musicapp.data.source.local.AlbumLocalDataSource;
import com.tuquyet.musicapp.screen.song.SongViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 29/07/2017.
 */
public class AlbumFragment extends Fragment {
    private AlbumContract.ViewModel mViewModel;
    private static final String TAG = "TAG";
    private ContentResolver mContentResolver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getActivity();
        List<Album> albumList = new ArrayList<>();
        AlbumAdapter albumAdapter = new AlbumAdapter(context, albumList);
        mViewModel = new AlbumViewModel(context, albumAdapter);
        mContentResolver = context.getContentResolver();
        AlbumContract.Presenter presenter =
            new AlbumPresenter((AlbumViewModel) mViewModel,
                new AlbumRepository(new AlbumLocalDataSource
                    (context, mContentResolver)));
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentAlbumBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album,
            container, false, null);
        binding.setViewModel((AlbumViewModel) mViewModel);
        return binding.getRoot();
    }
    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
