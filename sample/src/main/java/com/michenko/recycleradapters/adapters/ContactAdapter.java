package com.michenko.recycleradapters.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import com.michenko.recycleradapters.R;
import com.michenko.recycleradapters.holders.ContactDH;
import com.michenko.recycleradapters.holders.ContactVH;
import com.michenko.simpleadapter.RecyclerAdapter;
import com.michenko.simpleadapter.RecyclerVH;

import org.androidannotations.annotations.EBean;

@EBean
public class ContactAdapter extends RecyclerAdapter<ContactDH> {

    @NonNull
    @Override
    protected RecyclerVH<ContactDH> createVH(View view, int viewType) {
        return new ContactVH(view);
    }

    @Override
    protected int getLayoutRes(int viewType) {
        return R.layout.item_contact;
    }
}
