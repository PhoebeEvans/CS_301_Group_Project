package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
/**
 * @author Phoebe
 * @date 10/23/2024
 * @description ViewModel for the memories page
 */
public class MemoriesViewModel  extends ViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
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


    public LiveData<String> getWebLinkInfo() {
        if (web_link == null) {
            web_link = new MutableLiveData<>();
            loadWebLinkInfo();
        }
        return web_link;
    }

    //Loads the village information with the .setValue method.
    private void loadHeaderInfo() {
        textview_firstHeader.setValue("Memories of the Ma &amp; Pa Railroad");
    }


    //Loads the village information with the .setValue method.
    private void loadWebLinkInfo() {
        web_link.setValue("Click the link below to be taken to the memories page on our webpage. ");
    }
}
