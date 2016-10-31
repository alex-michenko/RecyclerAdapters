package com.michenko.recycleradapters.holders;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.michenko.recycleradapters.R;
import com.michenko.simpleadapter.OnCardClickListener;
import com.michenko.simpleadapter.RecyclerVH;

/**
 * Created by samson on 26.10.16.
 */

public class ContactTwoVH extends RecyclerVH<ContactDH> {

    private TextView tvNameContact;
    private ImageView ivCopy;
    private ImageView ivEdit;
    private ImageView ivDelete;


    public ContactTwoVH(View itemView, @Nullable final OnCardClickListener listener, final int viewType) {
        super(itemView, listener, viewType);

        tvNameContact = findView(R.id.tvNameContact);
        ivCopy = findView(R.id.ivCopy);
        ivEdit = findView(R.id.ivEdit);
        ivDelete = findView(R.id.ivDelete);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(view, getAdapterPosition(), viewType);
                }
            }
        };

        ivCopy.setOnClickListener(clickListener);
        ivEdit.setOnClickListener(clickListener);
        ivDelete.setOnClickListener(clickListener);
    }

    @Override
    public void bindData(ContactDH data) {
        tvNameContact.setText(data.getName());
    }
}
