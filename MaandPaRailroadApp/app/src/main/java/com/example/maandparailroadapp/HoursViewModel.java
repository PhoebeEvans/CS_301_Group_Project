package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description ViewModel for the hours page
 */
public class HoursViewModel extends ViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> hoursInfo;

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<String> getHoursInfo() {
        if (hoursInfo == null) {
            hoursInfo = new MutableLiveData<>();
            loadHoursInfo();
        }
        return hoursInfo;
    }

    //Loads the village information with the .setValue method.
    private void loadHoursInfo() {
        hoursInfo.setValue("Open daily from 9:00am to 6:00pm.");
    }
}
