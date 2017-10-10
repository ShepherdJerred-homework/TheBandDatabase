package com.shepherdjerred.thebanddatabase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class DetailsActivity extends AppCompatActivity implements RatingFragment.OnRatingSelected {

    public static String EXTRA_BAND_ID = "bandId";
    private Band band;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Terminate if two panes are displaying since ListActivity should be displaying both panes
        boolean isTwoPanes = getResources().getBoolean(R.bool.twoPanes);
        if (isTwoPanes) {
            finish();
            return;
        }

        setContentView(R.layout.activity_details);

        int bandId = getIntent().getIntExtra(EXTRA_BAND_ID, 1);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.details_fragment_container);

        if (fragment == null) {
            // Use band ID from ListFragment to instantiate DetailsFragment
            fragment = DetailsFragment.newInstance(bandId);
            fragmentManager.beginTransaction()
                    .add(R.id.details_fragment_container, fragment)
                    .commit();
        }


        BandDatabase bandDatabase = BandDatabase.get(getApplicationContext());
        band = bandDatabase.getBand(bandId);

        Log.d("RATING", "IT IS: " + bandDatabase.getBand(bandId).getRating());
        if (bandDatabase.getBand(bandId).getRating() == -1) {
            Fragment rating = fragmentManager.findFragmentById(R.id.rating_fragment_container);

            if (rating == null) {
                rating = new RatingFragment();
                fragmentManager.beginTransaction()
                        .add(R.id.rating_fragment_container, rating)
                        .commit();
            }

        } else {
            // TODO show rating
        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onRatingSelected(int i) {
        Log.d("RATING", "Selected");
        band.setRating(i);
        // TODO show rating
    }
}
