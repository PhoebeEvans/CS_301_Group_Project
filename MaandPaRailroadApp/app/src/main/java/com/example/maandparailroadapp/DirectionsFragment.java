package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class DirectionsFragment extends Fragment {
    private DirectionsViewModel directionsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_directions, container, false);
        TextView directions_text = root.findViewById(R.id.directions_text);

        directionsViewModel = new ViewModelProvider(this).get(DirectionsViewModel.class);
        directionsViewModel.getDirectionsInfo().observe(getViewLifecycleOwner(), directions -> {
            directions_text.setText(directions);
        });

        return root;
    }
}
