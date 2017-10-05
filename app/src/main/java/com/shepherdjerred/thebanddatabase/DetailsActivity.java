package com.shepherdjerred.thebanddatabase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zybooks.thebanddatabase.R;

public class DetailsActivity extends AppCompatActivity implements RatingFragment.OnRatingSelected {

    public static String EXTRA_BAND_ID = "bandId";

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

        if (bandDatabase.getBand(bandId).getRating() == -1) {
            Fragment rating = fragmentManager.findFragmentById(R.id.rating_fragment_container);

            if (rating == null) {
                rating = new RatingFragment();
                fragmentManager.beginTransaction()
                        .add(R.id.rating_fragment_container, rating)
                        .commit();
            }
        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onRatingSelected(int i) {

    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDetach() {

    }
}
