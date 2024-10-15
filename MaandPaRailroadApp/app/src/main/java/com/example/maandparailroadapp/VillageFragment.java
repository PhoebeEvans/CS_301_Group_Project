package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;

import androidx.fragment.app.Fragment;

public class VillageFragment extends Fragment {
    private VillageViewModel villageViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_village, container, false);
        TextView village_text = root.findViewById(R.id.village_info_text);

        villageViewModel = new ViewModelProvider(this).get(VillageViewModel.class);
        villageViewModel.getVillageInfo().observe(getViewLifecycleOwner(), info -> {
            village_text.setText(info);
        });
        return root;
    }
}
