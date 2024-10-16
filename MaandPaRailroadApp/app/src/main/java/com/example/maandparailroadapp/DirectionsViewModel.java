package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description ViewModel for the directions page
 */
public class DirectionsViewModel extends ViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> directions;

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<String> getDirectionsInfo() {
        if (directions == null) {
            directions = new MutableLiveData<>();
            loadDirections();
        }
        return directions;
    }

    //Loads the village information with the .setValue method.
    private void loadDirections() {
        directions.setValue("Turn left from I-62 at exit 45.");
    }
}
