package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description ViewModel for the train ride page
 */
public class TrainRideViewModel extends ViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> trainRideInfo;

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<String> getTrainRideInfo() {
        if (trainRideInfo == null) {
            trainRideInfo = new MutableLiveData<>();
            loadTrainRideInfo();
        }
        return trainRideInfo;
    }

    //Loads the train ride information with the .setValue method.
    private void loadTrainRideInfo() {
        trainRideInfo.setValue("Train rides are available every 30 minutes from 10 AM to 4 PM.");
    }
}
