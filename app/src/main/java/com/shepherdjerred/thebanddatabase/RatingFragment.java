package com.shepherdjerred.thebanddatabase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class RatingFragment extends Fragment {

    private OnRatingSelected onRatingSelected;

    public RatingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false);
    }

    public interface OnRatingSelected {
        void onRatingSelected(int i);
    }

    @Override
    public void onAttach() {
        Log.d("RATING", "Attached");

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Log.d("RATING", "Changed");
                onRatingSelected(Math.round(v));
            } 
        });
    }

    @Override
    public void onDetach() {
        Log.d("RATING", "Detached");

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(null);
    }

}
