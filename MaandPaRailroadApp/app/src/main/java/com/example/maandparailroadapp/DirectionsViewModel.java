package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DirectionsViewModel extends ViewModel {

    private MutableLiveData<String> directions;

    public LiveData<String> getDirectionsInfo() {
        if (directions == null) {
            directions = new MutableLiveData<>();
            loadDirections();
        }
        return directions;
    }

    private void loadDirections() {
        directions.setValue("Turn left from I-62 at exit 45.");
    }
}
