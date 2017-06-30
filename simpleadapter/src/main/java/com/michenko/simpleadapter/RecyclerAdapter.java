package com.michenko.simpleadapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerAdapter<DH extends RecyclerDH> extends RecyclerView.Adapter<RecyclerVH<DH>> {

    private List<DH> listDH = new ArrayList<>();
    private OnCardClickListener onCardClickListener;

    @Override
    public RecyclerVH<DH> onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerVH<DH> holder = createVH(LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(viewType), parent, false), viewType);
        if (onCardClickListener != null) {
            holder.setListeners(onCardClickListener);
        }
        return holder;
    }

    @NonNull
    protected abstract RecyclerVH<DH> createVH(View view, int viewType);
    @LayoutRes
    protected abstract int getLayoutRes(int viewType);

    @Override
    public void onBindViewHolder(RecyclerVH<DH> holder, int position) {
        holder.bindData(listDH.get(position));
    }

    @Override
    public int getItemCount() {
        return listDH.size();
    }


    public void setOnCardClickListener(OnCardClickListener onCardClickListener) {
        this.onCardClickListener = onCardClickListener;
    }

    public void setListDH(@NonNull List<DH> list) {
        listDH.clear();
        listDH.addAll(list);
        notifyDataSetChanged();
    }

    public List<DH> getListDH() {
        return listDH;
    }


    public void addListDH(List<DH> list) {
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
