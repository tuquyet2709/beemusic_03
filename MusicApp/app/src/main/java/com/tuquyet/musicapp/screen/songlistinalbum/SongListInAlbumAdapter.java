package com.tuquyet.musicapp.screen.songlistinalbum;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ItemSongInAlbumBinding;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;
import com.tuquyet.musicapp.screen.song.ItemSongViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 17/08/2017.
 */
public class SongListInAlbumAdapter
    extends BaseRecyclerViewAdapter<SongListInAlbumAdapter.ViewHolder> {
    List<Song> mSongList = new ArrayList<>();
    private OnRecyclerViewItemClickListener<Song> mItemClickListener;
    private SongListInAlbumViewModel mSongViewModel;

    protected SongListInAlbumAdapter(@NonNull Context context, List<Song> list) {
        super(context);
        mSongList = list;
    }
    public void setSongViewModel(SongListInAlbumViewModel songViewModel) {
        mSongViewModel = songViewModel;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSongInAlbumBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
            R.layout.item_song_in_album, parent, false);
        return new SongListInAlbumAdapter.ViewHolder(binding, mItemClickListener,mSongViewModel);
    }
    public void setItemClickListener(
        OnRecyclerViewItemClickListener<Song> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setSongList(List<Song> list) {
        mSongList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindata(mSongList.get(position));
    }

    @Override
    public int getItemCount() {
        return mSongList != null ? mSongList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemSongInAlbumBinding mItemSongInAlbumBinding;
        private OnRecyclerViewItemClickListener<Song> mItemClickListener;
        private SongListInAlbumViewModel mSongViewModel;

        public ViewHolder(ItemSongInAlbumBinding itemSongBinding,
                          OnRecyclerViewItemClickListener<Song> itemClickListener,
                          SongListInAlbumViewModel songViewModel) {
            super(itemSongBinding.getRoot());
            mItemSongInAlbumBinding = itemSongBinding;
            mItemClickListener = itemClickListener;
            mSongViewModel = songViewModel;
        }

        public void bindata(Song song) {
            if (song != null)
                mItemSongInAlbumBinding.setViewModel(
                    new ItemSongInAlbumViewModel(song, mItemClickListener, mSongViewModel));
        }
    }
}
