package com.tuquyet.musicapp.screen.artist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tuquyet.musicapp.R;
import com.example.tuquyet.musicapp.databinding.ItemArtistBinding;
import com.tuquyet.musicapp.data.model.Artist;
import com.tuquyet.musicapp.screen.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 08/08/2017.
 */
public class ArtistAdapter extends BaseRecyclerViewAdapter<ArtistAdapter.ViewHolder> {
    List<Artist> mArtistList = new ArrayList<>();
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Artist> mItemClickListener;
    private ArtistViewModel mArtistViewModel;

    protected ArtistAdapter(@NonNull Context context, List<Artist> list) {
        super(context);
        mArtistList = list;
    }

    public void setArtistViewModel(ArtistViewModel artistViewModel) {
        mArtistViewModel = artistViewModel;
    }

    @Override
    public ArtistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemArtistBinding binding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout
                .item_artist, parent, false);
        return new ArtistAdapter.ViewHolder(binding, mItemClickListener, mArtistViewModel);
    }

    public void setItemClickListener(
        BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Artist> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setArtistList(List<Artist> list) {
        mArtistList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ArtistAdapter.ViewHolder holder, int position) {
        holder.bindata(mArtistList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArtistList != null ? mArtistList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemArtistBinding mItemArtistBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Artist> mItemClickListener;
        private ArtistViewModel mArtistViewModel;

        public ViewHolder(ItemArtistBinding itemArtistBinding,
                          BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Artist>
                              itemClickListener,
                          ArtistViewModel artistViewModel) {
            super(itemArtistBinding.getRoot());
            mItemArtistBinding = itemArtistBinding;
            mItemClickListener = itemClickListener;
            mArtistViewModel = artistViewModel;
        }

        public void bindata(Artist artist) {
            if (artist != null)
                mItemArtistBinding.setViewModel(
                    new ItemArtistViewModel(artist, mItemClickListener, mArtistViewModel));
        }
    }
}
