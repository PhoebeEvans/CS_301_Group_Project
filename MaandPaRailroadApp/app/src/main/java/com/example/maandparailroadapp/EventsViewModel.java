package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description ViewModel for the events page
 */
public class EventsViewModel extends ViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<List<String>> events;

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<List<String>> getEventsInfo() {
        if (events == null) {
            events = new MutableLiveData<>();
            loadEvents();
        }
        return events;
    }

    //Loads the village information with the .setValue method.
    private void loadEvents() {
        List<String> eventsList = Arrays.asList("Spring Festival", "Summer Festival", "Winter Festival");
        events.setValue(eventsList);
    }
}
