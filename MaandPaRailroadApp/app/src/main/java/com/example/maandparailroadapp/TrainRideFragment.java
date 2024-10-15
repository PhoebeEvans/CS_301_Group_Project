package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class TrainRideFragment extends Fragment {
    private TrainRideViewModel trainRideViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_train_ride, container, false);
        TextView trainRideText = root.findViewById(R.id.train_ride_text);
        trainRideViewModel = new ViewModelProvider(this).get(TrainRideViewModel.class);
        trainRideViewModel.getTrainRideInfo().observe(getViewLifecycleOwner(), info -> {
            trainRideText.setText(info);
        });
        return root;
    }
}
