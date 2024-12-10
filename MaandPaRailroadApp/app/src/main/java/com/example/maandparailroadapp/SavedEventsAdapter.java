package com.example.maandparailroadapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SavedEventsAdapter extends RecyclerView.Adapter<SavedEventsAdapter.SavedEventViewHolder> {

    private List<SavedEvent> savedEvents = new ArrayList<>();

    @NonNull
    @Override
    public SavedEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saved_event, parent, false);
        return new SavedEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedEventViewHolder holder, int position) {
        SavedEvent savedEvent = savedEvents.get(position);
        holder.username.setText(savedEvent.getUser().getUsername());
        holder.email.setText(savedEvent.getUser().getEmail());
        holder.title.setText(savedEvent.getEvent().getTitle());
        holder.description.setText(savedEvent.getEvent().getDescription());
        holder.date.setText(savedEvent.getEvent().getDate());
        holder.time.setText(savedEvent.getEvent().getTime());
    }

    @Override
    public int getItemCount() {
        return savedEvents.size();
    }

    public void setSavedEvents(List<SavedEvent> savedEvents) {
        this.savedEvents = savedEvents;
        notifyDataSetChanged();
    }

    public static class SavedEventViewHolder extends RecyclerView.ViewHolder {
        TextView username, email, title, description, date, time;

        public SavedEventViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.user_username);
            email = itemView.findViewById(R.id.user_email);
            title = itemView.findViewById(R.id.event_title);
            description = itemView.findViewById(R.id.event_description);
            date = itemView.findViewById(R.id.event_date);
            time = itemView.findViewById(R.id.event_time);
        }
    }
}
