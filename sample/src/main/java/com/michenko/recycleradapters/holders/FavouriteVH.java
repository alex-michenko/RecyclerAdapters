package com.michenko.recycleradapters.holders;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.michenko.recycleradapters.R;
import com.michenko.simpleadapter.OnCardClickListener;
import com.michenko.simpleadapter.RecyclerVH;


public class FavouriteVH extends RecyclerVH<PersonDH> {

    private TextView tvFavourite;
    private RatingBar ratingBar;

    public FavouriteVH(View itemView, @Nullable final OnCardClickListener listener, final int viewType) {
        super(itemView, listener, viewType);

        tvFavourite = findView(R.id.tvNameFavourite);
        ratingBar = findView(R.id.rating);

        if (listener != null) {
            tvFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(tvFavourite, getAdapterPosition(), viewType);
                }
            });
            ratingBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(ratingBar, getAdapterPosition(), viewType);
                }
            });
        }
    }

    @Override
    public void bindData(PersonDH data) {
        tvFavourite.setText(data.name);
        ratingBar.setRating(data.countStars);
    }
}
