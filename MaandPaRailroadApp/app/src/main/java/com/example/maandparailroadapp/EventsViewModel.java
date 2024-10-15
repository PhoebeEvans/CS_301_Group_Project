package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

public class EventsViewModel extends ViewModel {
    private MutableLiveData<List<String>> events;

    public LiveData<List<String>> getEventsInfo() {
        if (events == null) {
            events = new MutableLiveData<>();
            loadEvents();
        }
        return events;
    }

    private void loadEvents() {
        List<String> eventsList = Arrays.asList("Spring Festival", "Summer Festival", "Winter Festival");
        events.setValue(eventsList);
    }
}
