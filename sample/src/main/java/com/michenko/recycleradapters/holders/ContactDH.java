package com.michenko.recycleradapters.holders;

import com.michenko.simpleadapter.RecyclerDH;


public class ContactDH implements RecyclerDH {

    private String name;

    public ContactDH(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
