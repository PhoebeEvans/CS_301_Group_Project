package com.example.maandparailroadapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class HistoryFragment  extends Fragment {
    private HistoryViewModel historyViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        //Instantiate the TextViews in the layout.
        TextView credit = root.findViewById(R.id.credit);
        TextView textView_firstHeader = root.findViewById(R.id.textview_firstHeader);
        TextView brief = root.findViewById(R.id.brief);
        TextView detailed = root.findViewById(R.id.detailed);
        TextView village = root.findViewById(R.id.village);
        TextView society = root.findViewById(R.id.society);
        TextView wrecks = root.findViewById(R.id.wrecks);
        TextView abandoned_header = root.findViewById(R.id.abandoned_header);
        TextView route = root.findViewById(R.id.route);

        // Initialize the ViewModel for this fragment
        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);

        //This observes live data and will update the TextView with new information.
        historyViewModel.getCreditInfo().observe(getViewLifecycleOwner(), info -> {
            credit.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        historyViewModel.getHeaderInfo().observe(getViewLifecycleOwner(), info -> {
            textView_firstHeader.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        historyViewModel.getBriefInfo().observe(getViewLifecycleOwner(), info -> {
            brief.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        historyViewModel.getDetailedInfo().observe(getViewLifecycleOwner(), info -> {
            detailed.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        historyViewModel.getVillageInfo().observe(getViewLifecycleOwner(), info -> {
            village.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        historyViewModel.getSocietyInfo().observe(getViewLifecycleOwner(), info -> {
            society.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        historyViewModel.getWrecksInfo().observe(getViewLifecycleOwner(), info -> {
            wrecks.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        historyViewModel.getAbandonedLineInfo().observe(getViewLifecycleOwner(), info -> {
            abandoned_header.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        historyViewModel.getRouteInfo().observe(getViewLifecycleOwner(), info -> {
            route.setText(info);
        });


        //brief history
        brief.setMovementMethod(LinkMovementMethod.getInstance());
        brief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HistoryFragment", "link clicked");
                openWebPage("https://maandparailroad.com/mapabriefhistory.php");
            }
        });

        //brief history
        detailed.setMovementMethod(LinkMovementMethod.getInstance());
        detailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HistoryFragment", "link clicked");
                openWebPage("https://maandparailroad.com/mapahistory.php");
            }
        });

        //brief history
        village.setMovementMethod(LinkMovementMethod.getInstance());
        village.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HistoryFragment", "link clicked");
                openWebPage("https://maandparailroad.com/pdf/VillageHistory.pdf");
            }
        });

        //brief history
        society.setMovementMethod(LinkMovementMethod.getInstance());
        society.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HistoryFragment", "link clicked");
                openWebPage("https://maandparailroad.com/societyhistory.php");
            }
        });

        //brief history
        wrecks.setMovementMethod(LinkMovementMethod.getInstance());
        wrecks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HistoryFragment", "link clicked");
                openWebPage("https://maandparailroad.com/wrecks.php");
            }
        });

        //brief history
        route.setMovementMethod(LinkMovementMethod.getInstance());
        route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HistoryFragment", "link clicked");
                openWebPage("https://www.abandonedrails.com/maryland-and-pennsylvania-railroad");
            }
        });

        //Returns the actual view of the fragment.
        return root;
    }

    //openWebPage
    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            Log.d("HistoryFragment", "Opening browser");
            startActivity(intent);
        } else {
            Log.d("HistoryFragment", "No browser found");
        }
    }
}
