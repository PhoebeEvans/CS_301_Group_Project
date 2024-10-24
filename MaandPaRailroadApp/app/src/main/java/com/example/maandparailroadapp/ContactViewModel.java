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

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<String> getContactInfo() {
        if (contactInfo == null) {
            contactInfo = new MutableLiveData<>();
            loadContactInfo();
        }
        return contactInfo;
    }

    //Loads the village information with the .setValue method.
    private void loadContactInfo() {
        contactInfo.setValue("address1258 Muddy Creek Forks Rd, Airville, PA 17302\n" +
                "\n" +
                "phone(717) 927-9565 (voice mail)\n" +
                "\n" +
                "email info@MaAndPaRailroad.com\n" +
                "\n" +
                "mailing addressSubscribe to our Special Events mailing list.\n" +
                "\n" +
                "mailing address P.O. Box 2262, York, PA 17405-2262\n" +
                "\n" +
                "coordinates Latitude 39°48'27\", Longitude 76°28'34\"");

    }
}
