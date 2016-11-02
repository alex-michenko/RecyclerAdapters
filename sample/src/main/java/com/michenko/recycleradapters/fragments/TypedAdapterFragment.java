package com.michenko.recycleradapters.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.michenko.recycleradapters.R;
import com.michenko.recycleradapters.adapters.PersonAdapter;
import com.michenko.recycleradapters.holders.ContactDH;
import com.michenko.recycleradapters.holders.PersonDH;
import com.michenko.simpleadapter.OnCardClickListener;

import java.util.ArrayList;


public class TypedAdapterFragment extends Fragment {

    private RecyclerView rvSimpleList;
    private PersonAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_typed_adapter, container, false);

        rvSimpleList = (RecyclerView) view.findViewById(R.id.rvTypedList);
        rvSimpleList.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new PersonAdapter();
        adapter.setOnCardClickListener(new OnCardClickListener() {
            @Override
            public void onClick(View view, int position, int viewType) {
                Toast.makeText(getContext(),
                        view.getClass().getName() + "\nposition = " + position + "\nviewType = " + viewType,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        rvSimpleList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setData();
    }

    private void setData() {
        ArrayList<PersonDH> contacts = new ArrayList<>();
        contacts.add(new PersonDH("#"));

        contacts.add(new PersonDH("Favourites"));
        contacts.add(new PersonDH("Mom", true));
        contacts.add(new PersonDH("Sister", true));
        contacts.add(new PersonDH("Brother", true));
        contacts.add(new PersonDH("best friend", true));
        contacts.add(new PersonDH("Girlfriend", true));

        contacts.add(new PersonDH("Persons"));
        contacts.add(new PersonDH("Dad", false));
        contacts.add(new PersonDH("Sister", false));
        contacts.add(new PersonDH("Friend", false));
        contacts.add(new PersonDH("Brother", false));
        contacts.add(new PersonDH("Boss", false));
        adapter.setListDH(contacts);
    }
}
