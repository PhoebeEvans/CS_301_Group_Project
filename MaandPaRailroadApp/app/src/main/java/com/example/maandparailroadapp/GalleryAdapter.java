package com.example.maandparailroadapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private final List<Integer> imageResources;
    private final Context context;

    // Constructor to initialize the list of resource IDs and the context
    public GalleryAdapter(Context context, List<Integer> imageResources) {
        this.context = context;
        this.imageResources = imageResources;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gallery_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the image resource ID at the given position
        int imageResId = imageResources.get(position);

        // Set the image to the ImageView using the resource ID
        holder.imageView.setImageResource(imageResId);

        // Set a click listener to open the image in fullscreen
        holder.imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FullScreenImage.class);
            intent.putExtra("image_res_id", imageResId);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return imageResources.size();
    }

    // ViewHolder class to hold the ImageView
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gallery_image_view);
        }
    }
}
