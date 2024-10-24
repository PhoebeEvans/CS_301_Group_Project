package com.example.maandparailroadapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.github.chrisbanes.photoview.PhotoView;


public class FullScreenImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_image);

        // Get the PhotoView from the layout
        PhotoView photoView = findViewById(R.id.photo_view);

        // Get the image resource ID from the intent
        int imageResId = getIntent().getIntExtra("image_res_id", -1);

        // Display the image if the ID is valid
        if (imageResId != -1) {
            photoView.setImageResource(imageResId);
        }
    }
}
