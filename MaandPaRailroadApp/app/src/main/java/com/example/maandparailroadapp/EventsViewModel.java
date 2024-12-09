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

    private MutableLiveData<List<Event>> events;
    private EventDAO eventDAO;

    public EventsViewModel(Application application) {
        super(application);
        eventDAO = new EventDAO(application);
    }

    /**
     * Returns the LiveData object for all events.
     *
     * @return LiveData object containing the list of all events.
     */
    public LiveData<List<Event>> getEventsInfo() {
        if (events == null) {
            events = new MutableLiveData<>();
            loadEvents();
        }
        return events;
    }

    /**
     * Loads all events from the database.
     */
    private void loadEvents() {
        new Thread(() -> {
            List<Event> eventsList = eventDAO.getAllEvents();
            events.postValue(eventsList);
        }).start();
    }

    /**
     * Returns the LiveData object for events on a specific date.
     *
     * @param date The date of the events to be retrieved.
     * @return LiveData object containing the list of events for the specified date.
     */
    public LiveData<List<Event>> getEventsByDate(String date) {
        MutableLiveData<List<Event>> filteredEvents = new MutableLiveData<>();
        new Thread(() -> {
            List<Event> eventsList = eventDAO.getEventsByDate(date);
            filteredEvents.postValue(eventsList);
        }).start();
        return filteredEvents;
    }

    /**
     * Saves an event for a user.
     *
     * @param userId The ID of the user.
     * @param eventId The ID of the event to be saved.
     */
    public void saveEventForUser(int userId, int eventId) {
        new Thread(() -> eventDAO.saveEventForUser(userId, eventId)).start();
    }

    /**
     * Returns the LiveData object for events saved by a user.
     *
     * @param userId The ID of the user.
     * @return LiveData object containing the list of events saved by the user.
     */
    public LiveData<List<Event>> getSavedEventsForUser(int userId) {
        MutableLiveData<List<Event>> savedEvents = new MutableLiveData<>();
        new Thread(() -> {
            List<Event> eventsList = eventDAO.getSavedEventsForUser(userId);
            savedEvents.postValue(eventsList);
        }).start();
        return savedEvents;
    }
}
