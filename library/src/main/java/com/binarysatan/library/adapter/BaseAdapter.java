package com.binarysatan.library.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.binarysatan.library.adapter.holder.BaseHolder;

import java.util.List;

/**
 * Created by chenshuai1 on 2016/4/12.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseHolder> {

    private Context mContext;
    protected List<T> mData;
    protected LayoutInflater mLayoutInflater;
    private int mLayoutId;
    private static BaseAdapter mAdapter;


    public BaseAdapter(Context context, int layoutId, List<T> data) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mData = data;
        mLayoutId = layoutId;
        mAdapter = this;
    }

    public static BaseAdapter getAdapter() {
        return mAdapter;
    }


    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseHolder viewHolder = BaseHolder.get(mLayoutInflater.inflate(mLayoutId, parent, false));
        setListener(viewHolder, mData);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        updateUI(holder, position, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public abstract void updateUI(BaseHolder holder, int position, T data);


    public void setListener(BaseHolder holder, List<T> data) {
        // set Listener...
    }
}
