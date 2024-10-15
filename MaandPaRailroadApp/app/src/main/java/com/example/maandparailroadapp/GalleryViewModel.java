package com.example.maandparailroadapp;

import androidx.lifecycle.ViewModel;
import java.util.List;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import java.util.Arrays;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description ViewModel for the gallery page
 */
public class GalleryViewModel extends ViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<List<String>> galleryItems;

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<List<String>> getGalleryItems() {
        if (galleryItems == null) {
            galleryItems = new MutableLiveData<>();
            loadGalleryItems();
        }
        return galleryItems;
    }

    //Loads the village information with the .setValue method.
    private void loadGalleryItems() {

        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
        galleryItems.setValue(items);
    }
}
