package com.example.maandparailroadapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

/**
 * ViewModel for the admin saved events page.
 * Provides data to the UI and handles data-related logic.
 */
public class AdminSavedEventsViewModel extends AndroidViewModel {

    private MutableLiveData<List<SavedEvent>> savedEvents;
    private EventDAO eventDAO;

    public AdminSavedEventsViewModel(Application application) {
        super(application);
        eventDAO = new EventDAO(application);
    }

    /**
     * Returns the LiveData object for all saved events for all users.
     *
     * @return LiveData object containing the list of saved events.
     */
    public LiveData<List<SavedEvent>> getSavedEventsForAllUsers() {
        if (savedEvents == null) {
            savedEvents = new MutableLiveData<>();
            loadSavedEvents();
        }
        return savedEvents;
    }

    /**
     * Loads all saved events from the database.
     */
    private void loadSavedEvents() {
        new Thread(() -> {
            List<SavedEvent> eventsList = eventDAO.getSavedEventsForAllUsers();
            savedEvents.postValue(eventsList);
        }).start();
    }
}
