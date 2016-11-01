package com.michenko.simpleadapter;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Base class-implementation of {@link RecyclerView.ViewHolder}
 *
 * @param <DH> type of {@link RecyclerDH} that hold data of item
 */
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

    /**
     * Simple method of initialization of view. Finds a view that was identified by the id attribute from the XML that
     * was processed in constructor.
     *
     * @param <T> The type of desired view
     * @return The typed view if find or null
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T findView(@IdRes int viewId) {
        return (T) parentView.findViewById(viewId);
    }

    /**
     * Called from {@link RecyclerView.Adapter#onBindViewHolder(RecyclerView.ViewHolder, int)}
     *
     * @param data The data of item
     */
    public abstract void bindData(DH data);

}
