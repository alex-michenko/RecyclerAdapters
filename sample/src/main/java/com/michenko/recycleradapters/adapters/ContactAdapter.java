package com.michenko.recycleradapters.adapters;

import com.michenko.recycleradapters.R;
import com.michenko.recycleradapters.holders.ContactDH;
import com.michenko.recycleradapters.holders.ContactVH;
import com.michenko.simpleadapter.SimpleRecyclerAdapter;

import org.androidannotations.annotations.EBean;

@EBean
public class ContactAdapter extends SimpleRecyclerAdapter<ContactDH, ContactVH> {

    @Override
    protected int getItemLayout() {
        return R.layout.item_contact;
    }
}
