package com.ypf.floatingactionbuttondemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/20.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;
    public TextView mTextView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        mTextView = (TextView) itemView.findViewById(R.id.textView);
    }
}
