package com.example.maandparailroadapp;

import androidx.lifecycle.ViewModel;
import java.util.List;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import java.util.Arrays;

public class GalleryViewModel extends ViewModel {
    private MutableLiveData<List<String>> galleryItems;

    public LiveData<List<String>> getGalleryItems() {
        if (galleryItems == null) {
            galleryItems = new MutableLiveData<>();
            loadGalleryItems();
        }
        return galleryItems;
    }

    private void loadGalleryItems() {

        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
        galleryItems.setValue(items);
    }
}
