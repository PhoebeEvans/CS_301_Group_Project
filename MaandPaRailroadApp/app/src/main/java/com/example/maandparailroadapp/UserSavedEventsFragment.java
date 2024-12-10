package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maandparailroadapp.database.DBHelper; // Add this import statement

public class UserSavedEventsFragment extends Fragment {

    private UserSavedEventsViewModel userSavedEventsViewModel;
    private SavedEventsAdapter savedEventsAdapter;
    private UserSessionManager userSessionManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_saved_events, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.user_saved_events_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        userSavedEventsViewModel = new ViewModelProvider(this).get(UserSavedEventsViewModel.class);
        savedEventsAdapter = new SavedEventsAdapter();
        recyclerView.setAdapter(savedEventsAdapter);

        userSessionManager = new UserSessionManager(getContext());
        String username = userSessionManager.getUsername();

        if (username != null) {
            DBHelper dbHelper = DBHelper.getInstance(getContext());
            int userId = dbHelper.getUserIdByUsername(username);

            if (userId != -1) {
                userSavedEventsViewModel.getSavedEventsForUser(userId).observe(getViewLifecycleOwner(), savedEvents -> {
                    savedEventsAdapter.setSavedEvents(savedEvents);
                });
            } else {
                // Handle case where userId is not found
            }
        } else {
            // Handle case where no user is logged in
        }

        return rootView;
    }
}
