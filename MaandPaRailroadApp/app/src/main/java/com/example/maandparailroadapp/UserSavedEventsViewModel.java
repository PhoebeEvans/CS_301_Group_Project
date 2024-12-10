package com.example.maandparailroadapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class UserSavedEventsViewModel extends AndroidViewModel {

    private MutableLiveData<List<SavedEvent>> savedEvents;
    private EventDAO eventDAO;

    public UserSavedEventsViewModel(Application application) {
        super(application);
        eventDAO = new EventDAO(application);
    }

    public LiveData<List<SavedEvent>> getSavedEventsForUser(int userId) {
        if (savedEvents == null) {
            savedEvents = new MutableLiveData<>();
            loadSavedEventsForUser(userId);
        }
        return savedEvents;
    }

    private void loadSavedEventsForUser(int userId) {
        new Thread(() -> {
            List<SavedEvent> eventsList = eventDAO.getSavedEventsForUser(userId);
            savedEvents.postValue(eventsList);
        }).start();
    }
}
