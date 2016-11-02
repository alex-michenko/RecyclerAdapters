package com.michenko.recycleradapters.holders;

import com.michenko.simpleadapter.RecyclerDH;

import java.util.Random;

public class PersonDH extends RecyclerDH {

    public boolean isFavourite;
    public int countStars;
    public String name;

    public String headerName;

    public PersonDH(String name, boolean isFavourite) {
        this.name = name;
        this.isFavourite = isFavourite;

        if (isFavourite)
            countStars = new Random().nextInt(4) + 1;
    }

    public PersonDH(String headerName) {
        this.headerName = headerName;
    }
}
