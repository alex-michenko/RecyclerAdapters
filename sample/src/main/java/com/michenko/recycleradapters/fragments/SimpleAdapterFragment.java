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
import com.michenko.recycleradapters.adapters.ContactAdapter;
import com.michenko.recycleradapters.holders.ContactDH;
import com.michenko.simpleadapter.OnCardClickListener;

import java.util.ArrayList;

public class SimpleAdapterFragment extends Fragment {

    private RecyclerView rvSimpleList;
    private ContactAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_adapter, container, false);
        findUI(view);
        setAdapter();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setData();
    }

    private void findUI(View v) {
        rvSimpleList = (RecyclerView) v.findViewById(R.id.rvSimpleList);
    }

    private void setAdapter() {
        adapter = new ContactAdapter();
        adapter.setOnCardClickListener(new OnCardClickListener() {
            @Override
            public void onClick(View view, int position, int viewType) {
                switch (view.getId()) {
                    case R.id.ivCopy:
                        copyItem(position);
                        break;
                    case R.id.ivEdit:
                        editItem(position);
                        break;
                    case R.id.ivDelete:
                        deleteItem(position);
                        break;
                    default:
                        Toast.makeText(getContext(), view.getClass().getName() + " " + position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        rvSimpleList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSimpleList.setAdapter(adapter);
    }

    private void setData() {
        ArrayList<ContactDH> contacts = new ArrayList<>();
        contacts.add(new ContactDH("Mom"));
        contacts.add(new ContactDH("Dad"));
        contacts.add(new ContactDH("Sister"));
        contacts.add(new ContactDH("Brother"));
        contacts.add(new ContactDH("Friend"));
        contacts.add(new ContactDH("best friend"));
        contacts.add(new ContactDH("Girlfriend"));
        contacts.add(new ContactDH("Boss"));
        adapter.setListDH(contacts);
    }

    private void copyItem(int position) {
        ContactDH item = adapter.getItem(position);
        adapter.insertItem(item, position + 1);
    }

    private void editItem(int position) {
        ContactDH item = adapter.getItem(position);
        item.setName(item.getName() + ".edited");
        adapter.changeItem(item, position);
    }

    private void deleteItem(int position) {
        adapter.removeItem(position);
    }
}
