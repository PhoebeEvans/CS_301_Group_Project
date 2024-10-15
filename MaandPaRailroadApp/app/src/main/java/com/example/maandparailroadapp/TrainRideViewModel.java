package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrainRideViewModel extends ViewModel {
    private MutableLiveData<String> trainRideInfo;

    public LiveData<String> getTrainRideInfo() {
        if (trainRideInfo == null) {
            trainRideInfo = new MutableLiveData<>();
            loadTrainRideInfo();
        }
        return trainRideInfo;
    }

    private void loadTrainRideInfo() {
        trainRideInfo.setValue("Train rides are available every 30 minutes from 10 AM to 4 PM.");
    }
}
