package com.example.maandparailroadapp;

import android.content.Intent;
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

public class JoinFragment  extends Fragment {
    private JoinViewModel joinViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_join, container, false);

        //Instantiate the TextViews in the layout.
        TextView invite = root.findViewById(R.id.invite);
        TextView textView_firstHeader = root.findViewById(R.id.textview_firstHeader);
        TextView web_link = root.findViewById(R.id.web_link);

        // Initialize the ViewModel for this fragment
        joinViewModel = new ViewModelProvider(this).get(JoinViewModel.class);

        //This observes live data and will update the TextView with new information.
        joinViewModel.getInviteInfo().observe(getViewLifecycleOwner(), info -> {
            invite.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        joinViewModel.getHeaderInfo().observe(getViewLifecycleOwner(), info -> {
            textView_firstHeader.setText(info);
        });

        //This observes live data and will update the TextView with new information.
        joinViewModel.getWebLinkInfo().observe(getViewLifecycleOwner(), info -> {
            web_link.setText(info);
        });


        web_link.setPaintFlags(web_link.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        web_link.setMovementMethod(LinkMovementMethod.getInstance());
        web_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", "https://maandparailroad.com/membership.php");
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
            Log.d("JoinFragment", "Opening browser");
            startActivity(intent);
        } else {
            Log.d("JoinFragment", "No browser found");
        }
    }
}
