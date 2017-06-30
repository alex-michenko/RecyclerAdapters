package com.michenko.recycleradapters.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.michenko.recycleradapters.R;
import com.michenko.simpleadapter.OnCardClickListener;
import com.michenko.simpleadapter.RecyclerVH;


public class ContactVH extends RecyclerVH<ContactDH> {

    private TextView tvNameContact;
    private ImageView ivCopy;
    private ImageView ivEdit;
    private ImageView ivDelete;


    public ContactVH(View itemView) {
        super(itemView);

        tvNameContact = findView(R.id.tvNameContact);
        ivCopy = findView(R.id.ivCopy);
        ivEdit = findView(R.id.ivEdit);
        ivDelete = findView(R.id.ivDelete);
    }

    @Override
    public void setListeners( final OnCardClickListener listener) {
        ivCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, getAdapterPosition(), getItemViewType());
            }
        });
        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, getAdapterPosition(), getItemViewType());
            }
        });
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, getAdapterPosition(), getItemViewType());
            }
        });
    }

    @Override
    public void bindData(ContactDH data) {
        tvNameContact.setText(data.getName());
    }
}
