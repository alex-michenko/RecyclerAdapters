package com.michenko.simpleadapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;


public abstract class SimpleRecyclerAdapter<DH extends RecyclerDH, VH extends RecyclerVH> extends RecyclerView.Adapter<VH> {

    private Class<VH> typeVH;
    private ArrayList<DH> listDH;
    private OnCardClickListener onCardClickListener;

    @SuppressWarnings("unchecked")
    public SimpleRecyclerAdapter() {
        this.typeVH = (Class<VH>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[1];
        this.listDH = new ArrayList<>();
    }

    @LayoutRes
    protected abstract int getItemLayout();

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(LayoutInflater.from(parent.getContext()).inflate(getItemLayout(), parent, false));
    }

    private VH getViewHolder(View view) {
        try {
            return typeVH.getConstructor(View.class, OnCardClickListener.class, int.class).newInstance(view, onCardClickListener, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindData(listDH.get(position));
    }

    @Override
    public int getItemCount() {
        return listDH.size();
    }

    public void setOnCardClickListener(OnCardClickListener onCardClickListener) {
        this.onCardClickListener = onCardClickListener;
    }

    public void setListDH(ArrayList<DH> list) {
        listDH = new ArrayList<>();
        listDH.addAll(list);
        notifyDataSetChanged();
    }

    public void addListDH(ArrayList<DH> list) {
        int oldSize = listDH.size();
        listDH.addAll(list);
        notifyItemRangeInserted(oldSize, listDH.size());
    }

    public void updateList() {
        notifyDataSetChanged();
    }

    public DH getItem(int position) {
        if (0 <= position && position < listDH.size()) {
            return listDH.get(position);
        } else {
            return null;
        }
    }

    public void insertItem(DH item, int position) {
        if (0 <= position && position <= listDH.size()) {
            listDH.add(position, item);
            notifyItemInserted(position);
        }
    }

    public void removeItem(int position) {
        if (0 <= position && position < listDH.size()) {
            listDH.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void updateItem(int position) {
        if (0 <= position && position < listDH.size()) {
            notifyItemChanged(position);
        }
    }

    public void changeItem(DH item, int position) {
        if (0 <= position && position < listDH.size()) {
            listDH.set(position, item);
            notifyItemChanged(position);
        }
    }
}
