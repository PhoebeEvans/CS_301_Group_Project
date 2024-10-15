package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class GalleryFragment extends Fragment {
    private GalleryViewModel galleryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        TextView gallery_text = root.findViewById(R.id.gallery_text);

        galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        galleryViewModel.getGalleryItems().observe(getViewLifecycleOwner(), items -> {
            gallery_text.setText(items.toString());
        });

        return root;
    }
}
