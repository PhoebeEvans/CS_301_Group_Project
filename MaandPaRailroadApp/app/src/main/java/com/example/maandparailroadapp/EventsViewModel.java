package com.example.maandparailroadapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description ViewModel for the events page
 */
public class EventsViewModel extends AndroidViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<List<Event>> events;
    private EventDAO eventDAO;

    public EventsViewModel(Application application) {
        super(application);
        eventDAO = new EventDAO(application);
    }

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<List<Event>> getEventsInfo() {
        if (events == null) {
            events = new MutableLiveData<>();
            loadEvents();
        }
        return events;
    }

    //Loads the village information with the .setValue method.
    private void loadEvents() {
        List<Event> eventsList = eventDAO.getAllEvents();
        events.setValue(eventsList);
    }
}