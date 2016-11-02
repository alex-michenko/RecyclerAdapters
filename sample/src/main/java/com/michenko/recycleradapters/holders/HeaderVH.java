package com.michenko.recycleradapters.holders;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.michenko.recycleradapters.R;
import com.michenko.simpleadapter.OnCardClickListener;
import com.michenko.simpleadapter.RecyclerVH;


public class HeaderVH extends RecyclerVH<PersonDH> {

    private TextView tvHeader;

    public HeaderVH(View itemView, @Nullable final OnCardClickListener listener, final int viewType) {
        super(itemView, listener, viewType);

        tvHeader = findView(R.id.tvHeader);

        if (listener != null) {
            tvHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(tvHeader, getAdapterPosition(), viewType);
                }
            });
        }
    }

    @Override
    public void bindData(PersonDH data) {
        tvHeader.setText(data.headerName);
    }
}
