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
 * @description Fragment for the train ride page
 */
public class TrainRideFragment extends Fragment {

    //The ViewModel for this fragment, which handles UI-related data for the village information.
    private TrainRideViewModel trainRideViewModel;

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
        View root = inflater.inflate(R.layout.fragment_train_ride, container, false);

        //Instantiate the TextView in the layout.
        TextView trainRideText = root.findViewById(R.id.train_ride_text);

        // Initialize the ViewModel for this fragment
        trainRideViewModel = new ViewModelProvider(this).get(TrainRideViewModel.class);

        //This observes live data and will update the TextView with new information.
        trainRideViewModel.getTrainRideInfo().observe(getViewLifecycleOwner(), info -> {
            trainRideText.setText(info);
        });

        //Returns the actual view of the fragment.
        return root;
    }
}