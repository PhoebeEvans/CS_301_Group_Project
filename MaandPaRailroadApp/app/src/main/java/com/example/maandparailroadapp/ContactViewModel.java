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
        contactInfo.setValue("Contact Information: 555-555-5555, admin@maandparailroad.com");

    }
}
