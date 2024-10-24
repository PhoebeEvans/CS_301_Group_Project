package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Griffin
 * @date 10/15/2024
 * @description ViewModel for the directions page
 */
public class DirectionsViewModel extends ViewModel {

    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> directions;

    //Returns the LiveData object for the village information. If not there, initializes and loads.
    public LiveData<String> getDirectionsInfo() {
        if (directions == null) {
            directions = new MutableLiveData<>();
            loadDirections();
        }
        return directions;
    }

    //Loads the village information with the .setValue method.
    private void loadDirections() {
        directions.setValue("Directions\n" +
                "The Ma & Pa Railroad Heritage Village is located at Muddy Creek Forks in York County, Pennsylvania." +
                "From the city of York\n" +
                "We are located in the town of Muddy Creek Forks in Southern York County, Pennsylvania. From the city of York, Pennsylvania take Route 74 south, off of Interstate 83. Continue on Route 74 south until you reach the town of Brogue. At Brogue turn right on to Muddy Creek Forks Road just before Brogue General Store. Follow Muddy Creek Forks Road about five miles to the Village of Muddy Creek Forks.\n" +
                "\n" +
                "From the city of Baltimore\n" +
                "If you are coming from Baltimore, Maryland, proceed north on Interstate 83 to Pennsylvania. Take Exit 4, Shrewsbury, and proceed east on Route 851. Continue east on 851 to New Park. At New Park follow the left fork onto New Park Road. Follow New Park Road about six miles through Gatchellville to the Village of Muddy Creek Forks.\n" +
                "\n" +
                "From the town of Bel Air\n" +
                "From Bel Air, from Main Street take Route 24 North. At the intersection in Forest Hill, continue North through Rocks State Park on Rocks Road. Continue North to PA Route 851. Turn left (East Main St) to the deer little town of Fawn Grove. At the intersection in Fawn Grove, turn right, proceeding North on North Market Street (Fawn Grove Rd) for three miles where the road ends at Gatchellville. At the stop sign, turn right on New Park Road and proceed three miles to the Village of Muddy Creek Forks.");
    }
}
