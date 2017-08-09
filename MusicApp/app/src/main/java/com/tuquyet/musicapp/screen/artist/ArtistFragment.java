package com.tuquyet.musicapp.screen.artist;

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
import com.example.tuquyet.musicapp.databinding.FragmentArtistBinding;
import com.tuquyet.musicapp.data.model.Artist;
import com.tuquyet.musicapp.data.source.ArtistRepository;
import com.tuquyet.musicapp.data.source.local.ArtistLocalDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 29/07/2017.
 */
public class ArtistFragment extends Fragment {
    private ArtistContract.ViewModel mViewModel;
    private ContentResolver mContentResolver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getActivity();
        List<Artist> artistList = new ArrayList<>();
        ArtistAdapter artistAdapter = new ArtistAdapter(context, artistList);
        mViewModel = new ArtistViewModel(context, artistAdapter);
        mContentResolver = context.getContentResolver();
        ArtistContract.Presenter presenter =
            new ArtistPresenter((ArtistViewModel) mViewModel,
                new ArtistRepository(new ArtistLocalDataSource(context, mContentResolver)));
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentArtistBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_artist,
            container, false, null);
        binding.setViewModel((ArtistViewModel) mViewModel);
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
