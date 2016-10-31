package com.michenko.recycleradapters.adapters;

import com.michenko.recycleradapters.R;
import com.michenko.recycleradapters.holders.ContactDH;
import com.michenko.recycleradapters.holders.ContactTwoVH;
import com.michenko.recycleradapters.holders.ContactVH;
import com.michenko.simpleadapter.TypedRecyclerAdapter;


public class TAdapter extends TypedRecyclerAdapter<ContactDH> {

    private static final int CO = 15;
    private static final int CT = 11;

    @Override
    protected void initTypes() {
        addType(CO, R.layout.item_contact, ContactVH.class);
        addType(CT, R.layout.item_contact_two, ContactTwoVH.class);
    }

    @Override
    protected int getViewType(int position) {
        return position % 2 == 0 ? CO : CT;
    }
}
