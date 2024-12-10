package com.example.maandparailroadapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

/**
 * ViewModel for the events page.
 * Provides data to the UI and handles data-related logic.
 */
public class EventsViewModel extends AndroidViewModel {

    private MutableLiveData<List<Event>> events;
    private MutableLiveData<List<SavedEvent>> savedEvents;
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
     * Returns the LiveData object for saved events by the current user.
     *
     * @param userId The ID of the user.
     * @return LiveData object containing the list of saved events for the user.
     */
    public LiveData<List<SavedEvent>> getSavedEventsForUser(int userId) {
        if (savedEvents == null) {
            savedEvents = new MutableLiveData<>();
            loadSavedEventsForUser(userId);
        }
        return savedEvents;
    }

    /**
     * Loads saved events for a user from the database.
     *
     * @param userId The ID of the user.
     */
    private void loadSavedEventsForUser(int userId) {
        new Thread(() -> {
            List<SavedEvent> eventsList = eventDAO.getSavedEventsForUser(userId);
            savedEvents.postValue(eventsList);
        }).start();
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
}
