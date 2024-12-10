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
import android.util.Log;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description Fragment for the events page
 */

public class EventsFragment extends Fragment implements EventsAdapter.OnEventSaveListener {
    private EventsViewModel eventsViewModel;
    private EventsAdapter eventsAdapter;
    private UserSessionManager userSessionManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentEventsCalendarBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_events_calendar, container, false);

        RecyclerView recyclerView = binding.eventsRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        eventsViewModel = new ViewModelProvider(this).get(EventsViewModel.class);
        eventsAdapter = new EventsAdapter(this);
        recyclerView.setAdapter(eventsAdapter);

        userSessionManager = new UserSessionManager(getContext());

        binding.calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(year, month, dayOfMonth);
            String date = DateFormat.format("yyyy-MM-dd", selectedDate).toString();
            eventsViewModel.getEventsByDate(date).observe(getViewLifecycleOwner(), filteredEvents -> {
                eventsAdapter.setEvents(filteredEvents);
            });
        });

        binding.resetButton.setOnClickListener(v -> {
            eventsViewModel.getEventsInfo().observe(getViewLifecycleOwner(), events -> {
                eventsAdapter.setEvents(events);
            });
        });

        // Set the calendar to start on the current date
        binding.calendarView.setDate(System.currentTimeMillis(), false, true);

        // Load all events initially
        eventsViewModel.getEventsInfo().observe(getViewLifecycleOwner(), events -> {
            eventsAdapter.setEvents(events);
        });

        return binding.getRoot();
    }

    @Override
    public void onSave(int eventId) {
        int userId = userSessionManager.getUserId(); // Get the currently logged-in user ID

        if (userId != -1) {
            // Log the event saving action
            Log.d("EventsFragment", "Attempting to save event with eventId: " + eventId + " for userId: " + userId);

            eventsViewModel.saveEventForUser(userId, eventId);
        } else {
            Log.e("EventsFragment", "No user is currently logged in.");
        }
    }
}
