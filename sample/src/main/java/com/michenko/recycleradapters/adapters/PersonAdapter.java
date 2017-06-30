package com.michenko.recycleradapters.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import com.michenko.recycleradapters.R;
import com.michenko.recycleradapters.holders.FavouriteVH;
import com.michenko.recycleradapters.holders.HeaderVH;
import com.michenko.recycleradapters.holders.PersonDH;
import com.michenko.recycleradapters.holders.PersonVH;
import com.michenko.simpleadapter.RecyclerAdapter;
import com.michenko.simpleadapter.RecyclerVH;


public class PersonAdapter extends RecyclerAdapter<PersonDH> {

    private static final int HEADER = 1;
    private static final int PERSON = 11;
    private static final int FAVOURITE = 0;

    @NonNull
    @Override
    protected RecyclerVH<PersonDH> createVH(View view, int viewType) {
        switch (viewType) {
            case PERSON:
                return new PersonVH(view);
            case HEADER:
                return new HeaderVH(view);
            default:
                return new FavouriteVH(view);
        }
    }

    @Override
    protected int getLayoutRes(int viewType) {
        switch (viewType) {
            case PERSON:
                return R.layout.item_person;
            case HEADER:
                return R.layout.item_header;
            default:
                return R.layout.item_favourite;
        }
    }

    @Override
    public int getItemViewType(int position) {
        PersonDH dh = getItem(position);
        if (dh.headerName != null) {
            return HEADER;
        } else {
            return dh.isFavourite ? FAVOURITE : PERSON;
        }
    }
}
