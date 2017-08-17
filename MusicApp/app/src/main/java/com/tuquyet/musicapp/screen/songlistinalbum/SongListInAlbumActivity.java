package com.tuquyet.musicapp.screen.songlistinalbum;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ActivitySongListInAlbumBinding;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.data.source.SongRepository;
import com.tuquyet.musicapp.data.source.local.SongLocalDataSource;
import com.tuquyet.musicapp.screen.playsong.PlaySongActivity;
import com.tuquyet.musicapp.screen.song.SongContract;

import java.util.ArrayList;
import java.util.List;

public class SongListInAlbumActivity extends AppCompatActivity {
    private static final String EXTRA_ALBUM_ID = "EXTRA_ALBUM_ID";
    private SongListInAlbumContract.ViewModel mViewModel;
    private ContentResolver mContentResolver;
    private Context mContext;
    private SongListInAlbumContract.Presenter mPresenter;
    private static int mAlbumID;
    public static Intent getSongListInAlbumIntent(Context context, int albumId) {
        Intent intent = new Intent(context, SongListInAlbumActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_ALBUM_ID, albumId);
        mAlbumID = albumId;
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySongListInAlbumBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_song_list_in_album);
        List<Song> songList = new ArrayList<>();
        mContext = getApplicationContext();
        SongListInAlbumAdapter adapter = new SongListInAlbumAdapter(mContext, songList);
        mViewModel = new SongListInAlbumViewModel(mContext, adapter);
        mContentResolver = mContext.getContentResolver();
        mPresenter = new SongListInAlbumPresenter((SongListInAlbumViewModel) mViewModel,
            new SongRepository(new SongLocalDataSource(mContext,mContentResolver)), mAlbumID);
        mViewModel.setPresenter(mPresenter);
        binding.setViewModel((SongListInAlbumViewModel) mViewModel);
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
