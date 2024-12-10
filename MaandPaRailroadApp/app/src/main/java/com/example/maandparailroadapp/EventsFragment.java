package com.example.maandparailroadapp;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maandparailroadapp.database.DBHelper;
import com.example.maandparailroadapp.databinding.FragmentEventsCalendarBinding;
import com.example.maandparailroadapp.UserSessionManager;


import java.util.Calendar;
import android.util.Log;

/**
 * Fragment for the events page.
 * Handles UI-related logic and displays events in a calendar view and list.
 */
public class EventsFragment extends Fragment implements EventsAdapter.OnEventSaveListener {
    private EventsViewModel eventsViewModel;
    private EventsAdapter eventsAdapter;
    private UserSessionManager userSessionManager;
    private DBHelper dbHelper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentEventsCalendarBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_events_calendar, container, false);

        RecyclerView recyclerView = binding.eventsRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        eventsViewModel = new ViewModelProvider(this).get(EventsViewModel.class);
        eventsAdapter = new EventsAdapter(this);
        recyclerView.setAdapter(eventsAdapter);

        userSessionManager = new UserSessionManager(getContext());
        dbHelper = DBHelper.getInstance(getContext());

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
        String username = userSessionManager.getUsername(); // Get the currently logged-in username

        Log.d("EventsFragment", "Retrieved Username: " + username); // Debug log

        if (username != null) {
            int userId = dbHelper.getUserIdByUsername(username); // Get user ID using username

            Log.d("EventsFragment", "Retrieved User ID: " + userId); // Debug log

            if (userId != -1) {
                // Log the event saving action
                Log.d("EventsFragment", "Attempting to save event with eventId: " + eventId + " for userId: " + userId);

                eventsViewModel.saveEventForUser(userId, eventId);

                // Show a pop-up message
                Toast.makeText(getContext(), "Event saved successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("EventsFragment", "User ID not found for username: " + username);

                // Show error message
                Toast.makeText(getContext(), "User not found.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e("EventsFragment", "No user is currently logged in.");

            // Show error message
            Toast.makeText(getContext(), "No user is currently logged in.", Toast.LENGTH_SHORT).show();
        }
    }
}
