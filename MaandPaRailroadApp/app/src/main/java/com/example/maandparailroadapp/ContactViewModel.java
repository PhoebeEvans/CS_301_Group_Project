package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description ViewModel for the contact page
 */
public class ContactViewModel extends ViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> contactInfo;
    private MutableLiveData<String> contactInfo2;
    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<String> getContactInfo() {
        if (contactInfo == null) {
            contactInfo = new MutableLiveData<>();
            loadContactInfo();
        }
        return contactInfo;
    }
    public LiveData<String> getContactInfo2() {
        if (contactInfo2 == null) {
            contactInfo2 = new MutableLiveData<>();
            loadContactInfo2();
        }
        return contactInfo2;
    }

    //Loads the village information with the .setValue method.
    private void loadContactInfo() {
        contactInfo.setValue("Address:\n    1258 Muddy Creek Forks Rd, Airville, PA 17302\n" +
                "\n" +
                "Phone Number:\n    (717) 927-9565 (voice mail)\n" +
                "\n" +
                "Email Address:\n   info@MaAndPaRailroad.com\n");

    }

    private void loadContactInfo2() {
        contactInfo2.setValue("MailingAddress:\n    P.O. Box 2262, York, PA 17405-2262\n" +
                "\n" +
                        "Coordinates:\n Latitude 39°48'27\", Longitude 76°28'34\"");
    }
}
