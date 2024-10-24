package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description ViewModel for the village page
 */
public class VillageViewModel extends ViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> villageInfo;

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<String> getVillageInfo() {
        if (villageInfo == null) {
            villageInfo = new MutableLiveData<>();
            loadVillageInfo();
        }
        return villageInfo;
    }

    //Loads the village information with the .setValue method.
    private void loadVillageInfo() {
        villageInfo.setValue("Come visit our authentic circa 1900's historic Ma & Pa Railroad Heritage Village at Muddy Creek Forks in York County, Pennsylvania. The train, store, and buildings are open during our operating season (June - Sept). The grounds are open for self-guided tours year-round.");
    }
}
