package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;

import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {
    private ContactViewModel contactViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        TextView contactText = root.findViewById(R.id.contact_text);

        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        contactViewModel.getContactInfo().observe(getViewLifecycleOwner(), contact -> {
            contactText.setText(contact);
        });
        return root;
    }
}
