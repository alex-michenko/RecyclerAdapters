package com.michenko.simpleadapter;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Base class-implementation of {@link RecyclerView.ViewHolder}
 *
 * @param <DH> type of {@link RecyclerDH} that hold data of item
 */
public abstract class RecyclerVH<DH extends RecyclerDH> extends RecyclerView.ViewHolder {

    public RecyclerVH(View itemView) {
        super(itemView);
    }

    /**
     * Simple method of initialization of view. Finds a view that was identified by the id attribute from the XML that
     * was processed in constructor.
     *
     * @param <T> The type of desired view.
     * @param viewId The id of view.
     * @return The typed view if find or null.
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T findView(@IdRes int viewId) {
        return (T) itemView.findViewById(viewId);
    }

    /**
     * Called from {@link RecyclerView.Adapter#onCreateViewHolder(ViewGroup parent, int viewType)}
     *
     * @param listener The callback for receiving of notification about click on views of item
     */
    public abstract void setListeners(final OnCardClickListener listener);

    /**
     * Called from {@link RecyclerView.Adapter#onBindViewHolder(RecyclerView.ViewHolder, int)}
     *
     * @param data The data of item
     */
    public abstract void bindData(DH data);

}
