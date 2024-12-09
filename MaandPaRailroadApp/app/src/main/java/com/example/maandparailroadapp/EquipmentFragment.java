package com.example.maandparailroadapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
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

public class EquipmentFragment  extends Fragment {
    private EquipmentViewModel equipmentViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_equipment, container, false);

        //Instantiate the TextViews in the layout.
        TextView credit = root.findViewById(R.id.credit);
        TextView textView_firstHeader = root.findViewById(R.id.textview_firstHeader);
        TextView web_link = root.findViewById(R.id.web_link);

        // Initialize the ViewModel for this fragment
        equipmentViewModel = new ViewModelProvider(this).get(EquipmentViewModel.class);

        //This observes live data and will update the TextView with new information.
        equipmentViewModel.getCreditInfo().observe(getViewLifecycleOwner(), info -> {
            credit.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        equipmentViewModel.getHeaderInfo().observe(getViewLifecycleOwner(), info -> {
            textView_firstHeader.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        equipmentViewModel.getWebLinkInfo().observe(getViewLifecycleOwner(), info -> {
            web_link.setText(info);
        });


        web_link.setPaintFlags(web_link.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        web_link.setMovementMethod(LinkMovementMethod.getInstance());
        web_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", "https://maandparailroad.com/equipment.php");
                    startActivity(intent);
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
            Log.d("EquipmentFragment", "Opening browser");
            startActivity(intent);
        } else {
            Log.d("EquipmentFragment", "No browser found");
        }
    }


}
