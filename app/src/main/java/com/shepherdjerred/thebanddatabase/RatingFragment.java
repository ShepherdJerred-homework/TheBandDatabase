package com.shepherdjerred.thebanddatabase;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        View view =  inflater.inflate(R.layout.fragment_rating, container, false);

        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                onRatingSelected.onRatingSelected(Math.round(v));
            }
        });

        return view;
    }

    public interface OnRatingSelected {
        void onRatingSelected(int i);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onRatingSelected = (OnRatingSelected) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onRatingSelected = null;
    }

}
