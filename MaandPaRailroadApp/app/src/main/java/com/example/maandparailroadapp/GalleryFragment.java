package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description Fragment for the gallery page
 */
public class GalleryFragment extends Fragment {

    private GalleryAdapter galleryAdapter;
    private List<Integer> imageResources = new ArrayList<>(); // Store resource IDs

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Set up RecyclerView with a Grid Layout Manager (3 columns)
        RecyclerView recyclerView = view.findViewById(R.id.gallery_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        // Initialize the adapter and set it to the RecyclerView
        galleryAdapter = new GalleryAdapter(getContext(), imageResources);
        recyclerView.setAdapter(galleryAdapter);

        // Load image resources
        loadImageResources();

        return view;
    }

    /**
     * Loads image resource IDs from the res/raw folder.
     */
    private void loadImageResources() {
        imageResources.add(R.raw.image_1);
        imageResources.add(R.raw.image_2);
        imageResources.add(R.raw.image_3);
        imageResources.add(R.raw.image_4);

        galleryAdapter.notifyDataSetChanged(); // Notify the adapter that data has changed
    }
}
