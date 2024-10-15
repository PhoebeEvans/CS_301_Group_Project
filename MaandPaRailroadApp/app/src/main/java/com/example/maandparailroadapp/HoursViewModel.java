package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HoursViewModel extends ViewModel {
    private MutableLiveData<String> hoursInfo;

    public LiveData<String> getHoursInfo() {
        if (hoursInfo == null) {
            hoursInfo = new MutableLiveData<>();
            loadHoursInfo();
        }
        return hoursInfo;
    }

    private void loadHoursInfo() {
        hoursInfo.setValue("Open daily from 9:00am to 6:00pm.");
    }
}
