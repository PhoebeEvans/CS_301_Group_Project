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
        hoursInfo.setValue("Train rides are available during our regular Sundays operating season and also during all special events. Specific dates and times are listed below.\n" +
                "\n" +
                "A.M. Grove Store and Roller Mill open to all.\n" +
                "\n" +
                "Free guided tours of the village are available for purchasers of train tickets who wish to take them. Tickets: $10.00 adult, $7.00 child, under 3 free.\n" +
                "\n" +
                "Capacity is limited and advance ticket purchase online is recommended. Please arrive 15 minutes prior to your train's departure.\n" +
                "\n" +
                "Train Rides & Tours\n" +
                "All Sundays June 2 - Sep. 1, 1-5 pm\n" +
                "» Motorcar train rides on all open days. The last train departs 45 minutes before closing.\n" +
                "\n" +
                "» Tickets available online\n" +
                "\n");
    }
}
