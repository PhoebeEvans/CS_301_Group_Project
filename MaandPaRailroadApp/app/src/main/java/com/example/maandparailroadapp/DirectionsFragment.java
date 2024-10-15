package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description Fragment for the directions page
 */
public class DirectionsFragment extends Fragment {

    //The ViewModel for this fragment, which handles UI-related data for the village information.
    private DirectionsViewModel directionsViewModel;

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return Return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_directions, container, false);

        //Instantiate the TextView in the layout.
        TextView directions_text = root.findViewById(R.id.directions_text);

        // Initialize the ViewModel for this fragment
        directionsViewModel = new ViewModelProvider(this).get(DirectionsViewModel.class);

        //This observes live data and will update the TextView with new information.
        directionsViewModel.getDirectionsInfo().observe(getViewLifecycleOwner(), directions -> {
            directions_text.setText(directions);
        });

        //Returns the actual view of the fragment.
        return root;
    }
}
