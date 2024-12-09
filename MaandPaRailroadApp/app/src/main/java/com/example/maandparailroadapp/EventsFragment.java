package com.example.maandparailroadapp;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maandparailroadapp.databinding.FragmentEventsCalendarBinding;

import java.util.Calendar;
import java.util.List;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description Fragment for the events page
 */
public class EventsFragment extends Fragment {

    private EventsViewModel eventsViewModel;
    private EventsAdapter eventsAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentEventsCalendarBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_events_calendar, container, false);

        CalendarView calendarView = binding.calendarView;
        RecyclerView recyclerView = binding.eventsRecyclerView;
        Button resetButton = binding.resetButton;

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        eventsViewModel = new ViewModelProvider(this).get(EventsViewModel.class);
        eventsAdapter = new EventsAdapter();
        recyclerView.setAdapter(eventsAdapter);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(year, month, dayOfMonth);
            String date = DateFormat.format("yyyy-MM-dd", selectedDate).toString();
            eventsViewModel.getEventsByDate(date).observe(getViewLifecycleOwner(), filteredEvents -> {
                eventsAdapter.setEvents(filteredEvents);
            });
        });

        resetButton.setOnClickListener(v -> {
            eventsViewModel.getEventsInfo().observe(getViewLifecycleOwner(), events -> {
                eventsAdapter.setEvents(events);
            });
        });

        // Set the calendar to start on the current date
        calendarView.setDate(System.currentTimeMillis(), false, true);

        // Load all events initially
        eventsViewModel.getEventsInfo().observe(getViewLifecycleOwner(), events -> {
            eventsAdapter.setEvents(events);
        });

        return binding.getRoot();
    }
}
