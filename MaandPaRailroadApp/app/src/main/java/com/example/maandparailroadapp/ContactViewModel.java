package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {
    private MutableLiveData<String> contactInfo;

    public LiveData<String> getContactInfo() {
        if (contactInfo == null) {
            contactInfo = new MutableLiveData<>();
            loadContactInfo();
        }
        return contactInfo;
    }

    private void loadContactInfo() {
        contactInfo.setValue("Contact Information: 555-555-5555, admin@maandparailroad.com");

    }
}
