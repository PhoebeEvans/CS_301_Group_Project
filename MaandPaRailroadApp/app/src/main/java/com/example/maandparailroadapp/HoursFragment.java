package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class HoursFragment extends Fragment {
    private HoursViewModel hoursViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hours, container, false);
        TextView hours_text = root.findViewById(R.id.hours_text);
        hoursViewModel = new ViewModelProvider(this).get(HoursViewModel.class);
        hoursViewModel.getHoursInfo().observe(getViewLifecycleOwner(), info -> {
            hours_text.setText(info);
        });
        return root;
    }
}
