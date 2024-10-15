package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class VillageViewModel extends ViewModel {

    private MutableLiveData<String> villageInfo;

    public LiveData<String> getVillageInfo() {
        if (villageInfo == null) {
            villageInfo = new MutableLiveData<>();
            loadVillageInfo();
        }
        return villageInfo;
    }

    private void loadVillageInfo() {
        villageInfo.setValue("Welcome to the village! Here’s everything you need to know...");
    }
}
