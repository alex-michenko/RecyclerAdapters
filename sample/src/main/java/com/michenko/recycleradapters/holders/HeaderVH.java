package com.michenko.recycleradapters.holders;

import android.view.View;
import android.widget.TextView;

import com.michenko.recycleradapters.R;
import com.michenko.simpleadapter.OnCardClickListener;
import com.michenko.simpleadapter.RecyclerVH;


public class HeaderVH extends RecyclerVH<PersonDH> {

    private TextView tvHeader;

    public HeaderVH(View itemView) {
        super(itemView);

        tvHeader = findView(R.id.tvHeader);

    }

    @Override
    public void setListeners(final OnCardClickListener listener) {
        tvHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(tvHeader, getAdapterPosition(), getItemViewType());
                }
        });
    }

    @Override
    public void bindData(PersonDH data) {
        tvHeader.setText(data.headerName);
    }
}
