package com.michenko.recycleradapters.adapters;

import com.michenko.recycleradapters.R;
import com.michenko.recycleradapters.holders.ContactDH;
import com.michenko.recycleradapters.holders.ContactVH;
import com.michenko.simpleadapter.SimpleRecyclerAdapter;


public class ContactAdapter extends SimpleRecyclerAdapter<ContactDH, ContactVH> {

    @Override
    protected int getItemLayout() {
        return R.layout.item_contact;
    }
}
