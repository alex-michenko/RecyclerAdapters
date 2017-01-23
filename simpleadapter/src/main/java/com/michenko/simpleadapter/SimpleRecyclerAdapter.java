package com.michenko.simpleadapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;


public abstract class SimpleRecyclerAdapter<DH extends RecyclerDH, VH extends RecyclerVH> extends RecyclerView.Adapter<VH> {

    private Class<VH> typeVH;
    private ArrayList<DH> listDH = new ArrayList<>();
    private OnCardClickListener onCardClickListener;

    {
        try {
            this.typeVH = (Class<VH>) findType(getClass());
        } catch (ClassCastException e) {
            throw new IllegalStateException("Type of ViewHolder not found");
        }
    }

    private Type findType(Class c) {
        if (c.getGenericSuperclass() instanceof ParameterizedType) {
            return ((ParameterizedType) c
                    .getGenericSuperclass())
                    .getActualTypeArguments()[1];
        } else {
            return findType(c.getSuperclass());
        }
    }

    /**
     * Called from {@link #onCreateViewHolder} for create ViewHolder
     *
     * @return The id of layout XML file
     */
    @LayoutRes
    protected abstract int getItemLayout();

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(LayoutInflater.from(parent.getContext()).inflate(getItemLayout(), parent, false), viewType);
    }

    private VH getViewHolder(View view, int viewType) {
        try {
            Constructor<VH> constructor = typeVH.getConstructor(View.class, OnCardClickListener.class, int.class);
            return constructor.newInstance(view, onCardClickListener, viewType);
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

    public ArrayList<DH> getListDH() {
        return listDH;
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
