package com.example.maandparailroadapp;

public class SavedEvent {
    private User user;
    private Event event;

    public SavedEvent(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }
}
