package com.michenko.recycleradapters.holders;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.michenko.recycleradapters.R;
import com.michenko.simpleadapter.OnCardClickListener;
import com.michenko.simpleadapter.RecyclerVH;


public class FavouriteVH extends RecyclerVH<PersonDH> {

    private TextView tvFavourite;
    private RatingBar ratingBar;

    public FavouriteVH(View itemView) {
        super(itemView);

        tvFavourite = findView(R.id.tvNameFavourite);
        ratingBar = findView(R.id.rating);
    }

    @Override
    public void setListeners(final OnCardClickListener listener) {
        tvFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(tvFavourite, getAdapterPosition(), getItemViewType());
            }
        });
        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(ratingBar, getAdapterPosition(), getItemViewType());
            }
        });
    }

    @Override
    public void bindData(PersonDH data) {
        tvFavourite.setText(data.name);
        ratingBar.setRating(data.countStars);
    }
}
