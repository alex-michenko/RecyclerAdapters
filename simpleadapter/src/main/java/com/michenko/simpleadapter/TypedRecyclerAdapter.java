package com.michenko.simpleadapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class TypedRecyclerAdapter<DH extends RecyclerDH> extends RecyclerView.Adapter<RecyclerVH> {

    private ArrayList<DH> listDH = new ArrayList<>();
    private OnCardClickListener onCardClickListener;
    private SparseArray<Pair<Integer, Class>> types = new SparseArray<>();

    {
        initViewTypes();
    }

    /**
     * The method that initialize all viewTypes.
     *
     * Use {@link #addType(int, int, Class)} for definition own viewTypes
     */
    protected abstract void initViewTypes();

    /**
     * Puts new viewType in set of viewTypes
     *
     * @param viewType The view type
     * @param layoutId The id of layout XML file
     * @param clazz The class {@link RecyclerVH} that complies {@param viewType}
     * @param <VH> The class of ViewHolder
     */
    protected <VH extends RecyclerVH<DH>> void addType(int viewType, @LayoutRes int layoutId, @NonNull Class<VH> clazz) {
        types.put(viewType, new Pair<Integer, Class>(layoutId, clazz));
    }

    @Override
    public RecyclerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        Pair<Integer, Class> viewData = types.get(viewType);
        if (viewData != null) {
            return createVH(viewData.second, LayoutInflater.from(parent.getContext()).inflate(viewData.first, parent, false), viewType);
        } else {
            throw new IllegalArgumentException("viewType not found");
        }
    }

    private <VH extends RecyclerVH<DH>> VH createVH(Class<VH> vh, View view, int viewType) {
        try {
            return vh.getConstructor(View.class, OnCardClickListener.class, int.class).newInstance(view, onCardClickListener, viewType);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerVH holder, int position) {
        Pair<Integer, Class> viewData = types.get(getItemViewType(position));
        if (viewData != null) {
            bindData(holder, viewData.second, listDH.get(position));
        } else {
            throw new IllegalArgumentException("viewType not found");
        }
    }

    private <VH extends RecyclerVH<DH>> void bindData(RecyclerView.ViewHolder holder, Class<VH> vh, DH item) {
        vh.cast(holder).bindData(item);
    }

    @Override
    public int getItemCount() {
        return listDH.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }

    /**
     * Similar {@link #getItemViewType(int)}
     */
    protected abstract int getViewType(int position);

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
