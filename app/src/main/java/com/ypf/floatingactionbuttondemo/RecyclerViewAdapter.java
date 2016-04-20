package com.ypf.floatingactionbuttondemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/20.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    public interface OnitemClickListener {
        void OnitemClick(View view, int position);

        void OnitemLongClick(View view, int position);
    }

    public OnitemClickListener onitemClickListener;

    public void setOnitemClickListener(OnitemClickListener listener) {
        this.onitemClickListener = listener;
    }

    public Context mContext;
    public LayoutInflater mLayoutInflate;
    public List<String> mData;

    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflate = LayoutInflater.from(mContext);
        mData = new ArrayList<>();//静态假数据
        for (int i = 0; i < 100; i++) {
            mData.add("我是CardView" + i);
        }
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflate.inflate(R.layout.item_layout, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        if (onitemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onitemClickListener.OnitemClick(v, position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onitemClickListener.OnitemLongClick(v, position);
                    return true;
                }
            });
//            holder.mImageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(mContext, "holder.mImageView", Toast.LENGTH_SHORT).show();
//                }
//            });
//            holder.mTextView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(mContext, "holder.mTextView", Toast.LENGTH_SHORT).show();
//                }
//            });
        }
        holder.mTextView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
