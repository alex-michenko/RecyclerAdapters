package com.michenko.recycleradapters.holders;

import android.view.View;
import android.widget.TextView;

import com.michenko.recycleradapters.R;
import com.michenko.simpleadapter.OnCardClickListener;
import com.michenko.simpleadapter.RecyclerVH;


public class PersonVH extends RecyclerVH<PersonDH> {

    private TextView tvNamePerson;

    public PersonVH(View itemView) {
        super(itemView);

        tvNamePerson = findView(R.id.tvNamePerson);
    }

    @Override
    public void setListeners(final OnCardClickListener listener) {
        tvNamePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition(), getItemViewType());
            }
        });
    }

    @Override
    public void bindData(PersonDH data) {
        tvNamePerson.setText(data.name);
    }

}
