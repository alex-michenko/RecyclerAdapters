package com.michenko.simpleadapter;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class RecyclerVH<DH extends RecyclerDH> extends RecyclerView.ViewHolder {

    private View parentView;

    public RecyclerVH(View itemView, @Nullable final OnCardClickListener listener, final int viewType) {
        super(itemView);
        this.parentView = itemView;

        parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null && getAdapterPosition() != -1) {
                    listener.onClick(parentView, getAdapterPosition(), viewType);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T findView(@IdRes int viewId) {
        return (T) parentView.findViewById(viewId);
    }

    public abstract void bindData(DH data);

}
