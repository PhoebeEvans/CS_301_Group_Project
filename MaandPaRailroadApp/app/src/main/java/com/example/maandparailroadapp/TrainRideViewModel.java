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
    private MutableLiveData<String> trainRideInfo2;

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<String> getTrainRideInfo() {
        if (trainRideInfo == null) {
            trainRideInfo = new MutableLiveData<>();
            loadTrainRideInfo();
        }
        return trainRideInfo;
    }

    public LiveData<String> getTrainRideInfo2() {
        if (trainRideInfo2 == null) {
            trainRideInfo2 = new MutableLiveData<>();
            loadTrainRideInfo2();
        }
        return trainRideInfo2;
    }

    //Loads the train ride information with the .setValue method.
    private void loadTrainRideInfo() {
        trainRideInfo.setValue("Ride the historic Ma & Pa Railroad!\n" +
                "\n" +
                "Sundays - June through Labor Day\n" +
                "Open 1:00 p.m. to 5:00 p.m. Last train leaves at 4:15 p.m.\n" +
                "\n" +
                "Special Event Days\n" +
                "View calendar for dates & times\n");
    }

    private void loadTrainRideInfo2() {
        trainRideInfo2.setValue("*Tickets purchased Online add $1 handling fee.\n" +
                "\n" +
                "\n" +
                "» View Full Events Calendar for specific operating dates and times");
    }
}
