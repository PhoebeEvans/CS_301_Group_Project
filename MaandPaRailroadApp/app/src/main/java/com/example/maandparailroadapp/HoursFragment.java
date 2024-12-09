package com.example.maandparailroadapp;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description Fragment for the hours page
 */
public class HoursFragment extends Fragment {

    //The ViewModel for this fragment, which handles UI-related data for the village information.
    private HoursViewModel hoursViewModel;

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return Return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_hours, container, false);

        //Instantiate the TextView in the layout.
        TextView hours_text = root.findViewById(R.id.hours_text);
        TextView buyTickets = root.findViewById(R.id.buy_tickets);
        // Initialize the ViewModel for this fragment
        hoursViewModel = new ViewModelProvider(this).get(HoursViewModel.class);
        buyTickets.setPaintFlags(buyTickets.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        buyTickets.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra("url", "https://www.dynamicticketsolutions.com/mapa");
            startActivity(intent);
        });
        //This observes live data and will update the TextView with new information.
        hoursViewModel.getHoursInfo().observe(getViewLifecycleOwner(), info -> {
            hours_text.setText(info);
        });

        //Returns the actual view of the fragment.
        return root;
    }
}
