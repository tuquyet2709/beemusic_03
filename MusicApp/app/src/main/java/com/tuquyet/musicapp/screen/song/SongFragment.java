package com.tuquyet.musicapp.screen.song;

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
import com.example.tuquyet.musicapp.databinding.FragmentSongBinding;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.data.source.SongRepository;
import com.tuquyet.musicapp.data.source.local.SongLocalDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 29/07/2017.
 */
public class SongFragment extends Fragment {
    private SongContract.ViewModel mViewModel;
    private SongContract.Presenter mPresenter;
    private static final String TAG = "TAG";
    private Context mContext;
    private ContentResolver mContentResolver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        List<Song> songList = new ArrayList<>();
        SongAdapter songAdapter = new SongAdapter(mContext, songList);
        mViewModel = new SongViewModel(mContext, songAdapter);
        mContentResolver = mContext.getContentResolver();
        mPresenter =
            new SongPresenter((SongViewModel) mViewModel, new SongRepository(new SongLocalDataSource
                (mContext, mContentResolver)));
        mViewModel.setPresenter(mPresenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentSongBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_song,
            container, false, null);
        binding.setViewModel((SongViewModel) mViewModel);
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
