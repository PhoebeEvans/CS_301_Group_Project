package com.example.maandparailroadapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Phoebe
 * @date 12/9/2024
 * @description EventsAdapter for the events page
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private List<Event> events;
    private OnEventSaveListener onEventSaveListener;

    public EventsAdapter(OnEventSaveListener onEventSaveListener) {
        this.onEventSaveListener = onEventSaveListener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = events.get(position);
        holder.title.setText(event.getTitle());
        holder.description.setText(event.getDescription());
        holder.date.setText(event.getDate());
        holder.time.setText(event.getTime());

        holder.saveButton.setOnClickListener(v -> {
            onEventSaveListener.onSave(event.getId());
            holder.saveButton.setBackgroundColor(Color.RED); // Change button color
        });
    }

    @Override
    public int getItemCount() {
        return (events != null) ? events.size() : 0;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    public interface OnEventSaveListener {
        void onSave(int eventId);
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, date, time;
        Button saveButton;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.event_title);
            description = itemView.findViewById(R.id.event_description);
            date = itemView.findViewById(R.id.event_date);
            time = itemView.findViewById(R.id.event_time);
            saveButton = itemView.findViewById(R.id.save_button); // Reference to the save button
        }
    }
}

