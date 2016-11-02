package com.michenko.recycleradapters.holders;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.michenko.recycleradapters.R;
import com.michenko.simpleadapter.OnCardClickListener;
import com.michenko.simpleadapter.RecyclerVH;


public class PersonVH extends RecyclerVH<PersonDH> {

    private TextView tvNamePerson;


    public PersonVH(View itemView, @Nullable final OnCardClickListener listener, final int viewType) {
        super(itemView, listener, viewType);

        tvNamePerson = findView(R.id.tvNamePerson);

        tvNamePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(view, getAdapterPosition(), viewType);
                }
            }
        });
    }

    @Override
    public void bindData(PersonDH data) {
        tvNamePerson.setText(data.name);
    }

}
