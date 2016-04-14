package com.binarysatan.library.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.binarysatan.library.adapter.holder.BaseHolder;

import java.util.List;

/**
 *
 *
 */
public abstract class MultiLayoutAdapter<T> extends BaseAdapter<T> {
    public MultiLayoutAdapter(Context context, List<T> data) {
        super(context, -1, data);
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseHolder holder = BaseHolder.get(mLayoutInflater.inflate(viewType, parent, false));
        setListener(holder,mData);
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return multiLayout(position);
    }


    public abstract int multiLayout(int position);

    @Override
    public void updateUI(BaseHolder holder, int position, T data) {
        updateMuiltUI(holder, position, mData);
    }


    public abstract void updateMuiltUI(BaseHolder holder, int position, List<T> data);
}
