package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Phoebe
 * @date 10/24/2024
 * @description ViewModel for the history page
 */
public class HistoryViewModel  extends ViewModel {
    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> credit;
    private MutableLiveData<String> textview_firstHeader;
    private MutableLiveData<String> brief;
    private MutableLiveData<String> detailed;
    private MutableLiveData<String> village;
    private MutableLiveData<String> society;
    private MutableLiveData<String> wrecks;
    private MutableLiveData<String> abandoned_line;
    private MutableLiveData<String> route;

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

    public LiveData<String> getBriefInfo() {
        if (brief == null) {
            brief = new MutableLiveData<>();
            loadBriefInfo();
        }
        return brief;
    }

    public LiveData<String> getDetailedInfo() {
        if (detailed == null) {
            detailed = new MutableLiveData<>();
            loadDetailedInfo();
        }
        return detailed;
    }

    public LiveData<String> getVillageInfo() {
        if (village == null) {
            village = new MutableLiveData<>();
            loadVillageInfo();
        }
        return village;
    }

    public LiveData<String> getSocietyInfo() {
        if (society == null) {
            society = new MutableLiveData<>();
            loadSocietyInfo();
        }
        return society;
    }

    public LiveData<String> getWrecksInfo() {
        if (wrecks == null) {
            wrecks = new MutableLiveData<>();
            loadWrecksInfo();
        }
        return wrecks;
    }

    public LiveData<String> getAbandonedLineInfo() {
        if (abandoned_line == null) {
            abandoned_line = new MutableLiveData<>();
            loadAbandonedLineInfo();
        }
        return abandoned_line;
    }

    public LiveData<String> getRouteInfo() {
        if (route == null) {
            route = new MutableLiveData<>();
            loadRouteInfo();
        }
        return route;
    }

    //Loads the header information with the .setValue method.
    private void loadHeaderInfo() {
        textview_firstHeader.setValue("Ma & Pa Railroad History");
    }

    //Loads the credit information with the .setValue method.
    private void loadCreditInfo() {
        credit.setValue("The \"Champagne Special\" crossing the Sharon Trestle - Sept. 14, 1947");
    }

    //Loads the brief information with the .setValue method.
    private void loadBriefInfo() {
        brief.setValue("Brief History");
    }

    //Loads the detailed information with the .setValue method.
    private void loadDetailedInfo() {
        detailed.setValue("Detailed History");
    }

    //Loads the village information with the .setValue method.
    private void loadVillageInfo() {
        village.setValue("Village History");
    }

    //Loads the society information with the .setValue method.
    private void loadSocietyInfo() {
        society.setValue("Preservation Society History");
    }

    //Loads the wrecks information with the .setValue method.
    private void loadWrecksInfo() {
        wrecks.setValue("Wrecks");
    }

    //Loads the abandoned line information with the .setValue method.
    private void loadAbandonedLineInfo() {
        abandoned_line.setValue("View the Ma & Pa Railroad's Abandoned Line");
    }

    //Loads the route information with the .setValue method.
    private void loadRouteInfo() {
        brief.setValue("View the route of the Ma & Pa Railroad, showing some pictures of the existing route.");
    }
}
