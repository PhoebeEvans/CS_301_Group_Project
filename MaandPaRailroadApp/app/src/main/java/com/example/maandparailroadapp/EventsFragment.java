package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class EventsFragment extends Fragment {
    private EventsViewModel eventsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_events, container, false);
        TextView events_text = root.findViewById(R.id.events_text);

        eventsViewModel = new ViewModelProvider(this).get(EventsViewModel.class);
        eventsViewModel.getEventsInfo().observe(getViewLifecycleOwner(), events -> {
            events_text.setText(events.toString());
        });

        return root;
    }
}
