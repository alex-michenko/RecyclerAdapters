package com.michenko.recycleradapters.adapters;

import com.michenko.recycleradapters.R;
import com.michenko.recycleradapters.holders.ContactDH;
import com.michenko.recycleradapters.holders.FavouriteVH;
import com.michenko.recycleradapters.holders.HeaderVH;
import com.michenko.recycleradapters.holders.PersonDH;
import com.michenko.recycleradapters.holders.PersonVH;
import com.michenko.recycleradapters.holders.ContactVH;
import com.michenko.simpleadapter.TypedRecyclerAdapter;


public class PersonAdapter extends TypedRecyclerAdapter<PersonDH> {

    private static final int HEADER = 1;
    private static final int PERSON = 11;
    private static final int FAVOURITE = 0;

    @Override
    protected void initViewTypes() {
        addType(PERSON, R.layout.item_person, PersonVH.class);
        addType(HEADER, R.layout.item_header, HeaderVH.class);
        addType(FAVOURITE, R.layout.item_favourite, FavouriteVH.class);
    }

    @Override
    protected int getViewType(int position) {
        PersonDH dh = getItem(position);
        if (dh.headerName != null) {
            return HEADER;
        } else {
            return dh.isFavourite ? FAVOURITE : PERSON;
        }
    }
}
