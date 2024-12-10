package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maandparailroadapp.databinding.FragmentAdminSavedEventsBinding;

import java.util.List;

/**
 * Fragment for displaying saved events for admins.
 */
public class AdminSavedEventsFragment extends Fragment {

    private AdminSavedEventsViewModel adminSavedEventsViewModel;
    private SavedEventsAdapter savedEventsAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentAdminSavedEventsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admin_saved_events, container, false);

        RecyclerView recyclerView = binding.adminSavedEventsRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adminSavedEventsViewModel = new ViewModelProvider(this).get(AdminSavedEventsViewModel.class);
        savedEventsAdapter = new SavedEventsAdapter();
        recyclerView.setAdapter(savedEventsAdapter);

        adminSavedEventsViewModel.getSavedEventsForAllUsers().observe(getViewLifecycleOwner(), savedEvents -> {
            savedEventsAdapter.setSavedEvents(savedEvents);
        });

        return binding.getRoot();
    }
}
