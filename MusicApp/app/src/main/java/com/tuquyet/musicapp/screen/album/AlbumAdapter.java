package com.tuquyet.musicapp.screen.album;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ItemAlbumBinding;
import com.tuquyet.musicapp.data.model.Album;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 08/08/2017.
 */
public class AlbumAdapter extends BaseRecyclerViewAdapter<AlbumAdapter.ViewHolder> {
    List<Album> mAlbumList = new ArrayList<>();
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Album> mItemClickListener;
    private AlbumViewModel mAlbumViewModel;

    protected AlbumAdapter(@NonNull Context context, List<Album> list) {
        super(context);
        mAlbumList = list;
    }

    public void setAlbumViewModel(AlbumViewModel albumViewModel) {
        mAlbumViewModel = albumViewModel;
    }

    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAlbumBinding binding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_album,
                parent, false);
        return new AlbumAdapter.ViewHolder(binding, mItemClickListener, mAlbumViewModel);
    }

    public void setItemClickListener(
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Album> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setAlbumList(List<Album> list) {
        mAlbumList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(AlbumAdapter.ViewHolder holder, int position) {
        holder.bindata(mAlbumList.get(position));
    }

    @Override
    public int getItemCount() {
        return mAlbumList != null ? mAlbumList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemAlbumBinding mItemAlbumBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Album> mItemClickListener;
        private AlbumViewModel mAlbumViewModel;

        public ViewHolder(ItemAlbumBinding itemAlbumBinding,
                          BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Album>
                              itemClickListener,
                          AlbumViewModel albumViewModel) {
            super(itemAlbumBinding.getRoot());
            mItemAlbumBinding = itemAlbumBinding;
            mItemClickListener = itemClickListener;
            mAlbumViewModel = albumViewModel;
        }

        public void bindata(Album album) {
            if (album != null)
                mItemAlbumBinding.setViewModel(
                    new ItemAlbumViewModel(album, mItemClickListener, mAlbumViewModel));
        }
    }
}
