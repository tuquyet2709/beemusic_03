package com.tuquyet.musicapp.screen.song;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ItemSongBinding;
import com.tuquyet.musicapp.data.model.Song;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 31/07/2017.
 */
public class SongAdapter extends BaseRecyclerViewAdapter<SongAdapter.ViewHolder> {
    List<Song> mSongList = new ArrayList<>();
    private OnRecyclerViewItemClickListener<Song> mItemClickListener;
    private SongViewModel mSongViewModel;

    protected SongAdapter(@NonNull Context context, List<Song> list) {
        super(context);
        mSongList = list;
    }

    public void setSongViewModel(SongViewModel songViewModel) {
        mSongViewModel = songViewModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSongBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
            R.layout.item_song, parent, false);
        return new ViewHolder(binding, mItemClickListener,mSongViewModel);
    }

    public void setItemClickListener(
        OnRecyclerViewItemClickListener<Song> itemClickListener) {
        mItemClickListener = itemClickListener;
    }
    public void deleteSong(Song song) {
        mSongList.remove(song);
        notifyDataSetChanged();
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
        private ItemSongBinding mItemSongBinding;
        private OnRecyclerViewItemClickListener<Song> mItemClickListener;
        private SongViewModel mSongViewModel;

        public ViewHolder(ItemSongBinding itemSongBinding,
                          OnRecyclerViewItemClickListener<Song> itemClickListener,
                          SongViewModel songViewModel) {
            super(itemSongBinding.getRoot());
            mItemSongBinding = itemSongBinding;
            mItemClickListener = itemClickListener;
            mSongViewModel = songViewModel;
        }

        public void bindata(Song song) {
            if (song != null)
                mItemSongBinding.setViewModel(
                    new ItemSongViewModel(song, mItemClickListener, mSongViewModel));
        }
    }
}
