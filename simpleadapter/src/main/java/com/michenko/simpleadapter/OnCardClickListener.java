package com.michenko.simpleadapter;

import android.view.View;

/**
 * Interface definition for a callback to be invoked when a view of {@link RecyclerVH} is clicked.
 */
public interface OnCardClickListener {
    /**
     *  Called when a view has been clicked.
     *
     * @param view The view that was clicked
     * @param position The position of item in adapter
     * @param viewType The viewType of clicked item
     */
    void onClick(View view, int position, int viewType);
}
