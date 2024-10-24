package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JoinViewModel  extends ViewModel {
    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> invite;
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

    public LiveData<String> getInviteInfo() {
        if (invite == null) {
            invite = new MutableLiveData<>();
            loadInviteInfo();
        }
        return invite;
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
        textview_firstHeader.setValue("Ma & Pa Railroad Preservation Society Membership");
    }

    //Loads the village information with the .setValue method.
    private void loadInviteInfo() {
        invite.setValue("If you are a railfan, a history buff, or would simply enjoy working with unusual equipment and structures, the Maryland and Pennsylvania Railroad Preservation Society affords unique opportunities to pursue your interests. We cordially invite you to join us in preserving America's transportation heritage!");
    }

    //Loads the village information with the .setValue method.
    private void loadWebLinkInfo() {
        web_link.setValue("Click here for more information and to join.");
    }
}
