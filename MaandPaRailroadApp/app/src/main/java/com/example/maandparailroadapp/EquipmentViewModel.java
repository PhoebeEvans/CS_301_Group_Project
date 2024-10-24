package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Phoebe
 * @date 10/23/2024
 * @description ViewModel for the equipment page
 */
public class EquipmentViewModel  extends ViewModel {
    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> credit;
    private MutableLiveData<String> textview_firstHeader;
    private MutableLiveData<String> web_link;

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<String> getHeaderInfo() {
        if (textview_firstHeader == null) {
            textview_firstHeader = new MutableLiveData<>();
            loadHeaderInfo();
        }
        return textview_firstHeader;
    }

    public LiveData<String> getCreditInfo() {
        if (credit == null) {
            credit = new MutableLiveData<>();
            loadCreditInfo();
        }
        return credit;
    }

    public LiveData<String> getWebLinkInfo() {
        if (web_link == null) {
            web_link = new MutableLiveData<>();
            loadWebLinkInfo();
        }
        return web_link;
    }

    //Loads the village information with the .setValue method.
    private void loadHeaderInfo() {
        textview_firstHeader.setValue("Welcome to the Ma and Pa Railroad Heritage Village");
    }

    //Loads the village information with the .setValue method.
    private void loadCreditInfo() {
        credit.setValue("#84 Photo by Marlin Markle (Summer 1997)");
    }

    //Loads the village information with the .setValue method.
    private void loadWebLinkInfo() {
        web_link.setValue("See the rest of the equipment.");
    }


}
