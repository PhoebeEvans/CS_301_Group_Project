package com.example.maandparailroadapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Phoebe
 * @date 10/23/2024
 * @description ViewModel for the explore village page
 */
public class ExploreVillageViewModel  extends ViewModel {
    //MutableLiveData used in order to allow observers to receive updated information.
    private MutableLiveData<String> firstHeader;
    private MutableLiveData<String> first;
    private MutableLiveData<String> second;
    private MutableLiveData<String> third;
    private MutableLiveData<String> fourth;
    private MutableLiveData<String> fifth;
    private MutableLiveData<String> a_m_grove_general_store;
    private MutableLiveData<String> railroad_station_platform;
    private MutableLiveData<String> mill_race;
    private MutableLiveData<String> original_store_site;
    private MutableLiveData<String> roller_mills;
    private MutableLiveData<String> grain_elevator;
    private MutableLiveData<String> fertilizer_warehouse;
    private MutableLiveData<String> barn;
    private MutableLiveData<String> corn_cribs;
    private MutableLiveData<String> corn_husking_shed;
    private MutableLiveData<String> railroad_tool_house;
    private MutableLiveData<String> james_grove_house;
    private MutableLiveData<String> team_track;
    private MutableLiveData<String> milk_collection_building;
    private MutableLiveData<String> keisers_fertilizer_warehouse;
    private MutableLiveData<String> mill_tail_race;
    private MutableLiveData<String> mill_loading_platform;
    private MutableLiveData<String> things_that_are_now_gone;
    private MutableLiveData<String> yellow_house;
    private MutableLiveData<String> stone_house;
    private MutableLiveData<String> a_m_grove_house;
    private MutableLiveData<String> credit;

    //Returns the LiveDate object
    public LiveData<String> getFirstHeaderInfo() {
        if (firstHeader == null) {
            firstHeader = new MutableLiveData<>();
            loadFirstHeaderInfo();
        }
        return firstHeader;
    }

    public LiveData<String> getFirstInfo() {
        if (first == null) {
            first = new MutableLiveData<>();
            loadFirstInfo();
        }
        return first;
    }

    public LiveData<String> getSecondInfo() {
        if (second == null) {
            second = new MutableLiveData<>();
            loadSecondInfo();
        }
        return second;
    }

    public LiveData<String> getThirdInfo() {
        if (third == null) {
            third = new MutableLiveData<>();
            loadThirdInfo();
        }
        return third;
    }

    public LiveData<String> getFourthInfo() {
        if (fourth == null) {
            fourth = new MutableLiveData<>();
            loadFourthInfo();
        }
        return fourth;
    }

    public LiveData<String> getFifthInfo() {
        if (fifth == null) {
            fifth = new MutableLiveData<>();
            loadFifthInfo();
        }
        return fifth;
    }

    public LiveData<String> getAMGroveGeneralStoreInfo() {
        if (a_m_grove_general_store == null) {
            a_m_grove_general_store = new MutableLiveData<>();
            loadAMGroveGeneralStoreInfo();
        }
        return a_m_grove_general_store;
    }

    public LiveData<String> getRailroadStationPlatformInfo() {
        if (railroad_station_platform == null) {
            railroad_station_platform = new MutableLiveData<>();
            loadRailroadStationPlatformInfo();
        }
        return railroad_station_platform;
    }

    public LiveData<String> getMillRaceInfo() {
        if (mill_race == null) {
            mill_race = new MutableLiveData<>();
            loadMillRaceInfo();
        }
        return mill_race;
    }

    public LiveData<String> getOriginalStoreSiteInfo() {
        if (original_store_site == null) {
            original_store_site = new MutableLiveData<>();
            loadOriginalStoreSiteInfo();
        }
        return original_store_site;
    }

    public LiveData<String> getRollerMillsInfo() {
        if (roller_mills == null) {
            roller_mills = new MutableLiveData<>();
            loadRollerMillsInfo();
        }
        return roller_mills;
    }

    public LiveData<String> getGrainElevatorInfo() {
        if (grain_elevator == null) {
            grain_elevator = new MutableLiveData<>();
            loadGrainElevatorInfo();
        }
        return grain_elevator;
    }

    public LiveData<String> getFertilizerWarehouseInfo() {
        if (fertilizer_warehouse == null) {
            fertilizer_warehouse = new MutableLiveData<>();
            loadFertilizerWarehouseInfo();
        }
        return fertilizer_warehouse;
    }

    public LiveData<String> getBarnInfo() {
        if (barn == null) {
            barn = new MutableLiveData<>();
            loadBarnInfo();
        }
        return barn;
    }

    public LiveData<String> getCornCribsInfo() {
        if (corn_cribs == null) {
            corn_cribs = new MutableLiveData<>();
            loadCornCribsInfo();
        }
        return corn_cribs;
    }

    public LiveData<String> getCornHuskingShedInfo() {
        if (corn_husking_shed == null) {
            corn_husking_shed = new MutableLiveData<>();
            loadCornHuskingShedInfo();
        }
        return corn_husking_shed;
    }

    public LiveData<String> getRailroadToolHouseInfo() {
        if (railroad_tool_house == null) {
            railroad_tool_house = new MutableLiveData<>();
            loadRailroadToolHouseInfo();
        }
        return railroad_tool_house;
    }

    public LiveData<String> getJamesGroveHouseInfo() {
        if (james_grove_house == null) {
            james_grove_house = new MutableLiveData<>();
            loadJamesGroveHouseInfo();
        }
        return james_grove_house;
    }

    public LiveData<String> getTeamTrackInfo() {
        if (team_track == null) {
            team_track = new MutableLiveData<>();
            loadTeamTrackInfo();
        }
        return team_track;
    }

    public LiveData<String> getMilkCollectionBuildingInfo() {
        if (milk_collection_building == null) {
            milk_collection_building = new MutableLiveData<>();
            loadMilkCollectionBuildingInfo();
        }
        return milk_collection_building;
    }

    public LiveData<String> getKeisersFertilizerWarehouseInfo() {
        if (keisers_fertilizer_warehouse == null) {
            keisers_fertilizer_warehouse = new MutableLiveData<>();
            loadKeisersFertilizerWarehouseInfo();
        }
        return keisers_fertilizer_warehouse;
    }

    public LiveData<String> getMillTailRaceInfo() {
        if (mill_tail_race == null) {
            mill_tail_race = new MutableLiveData<>();
            loadMillTailRaceInfo();
        }
        return mill_tail_race;
    }

    public LiveData<String> getMillLoadingPlatformInfo() {
        if (mill_loading_platform == null) {
            mill_loading_platform = new MutableLiveData<>();
            loadMillLoadingPlatformInfo();
        }
        return mill_loading_platform;
    }

    public LiveData<String> getThingsInfo() {
        if (things_that_are_now_gone == null) {
            things_that_are_now_gone = new MutableLiveData<>();
            loadThingsInfo();
        }
        return things_that_are_now_gone;
    }

    public LiveData<String> getYellowHouseInfo() {
        if (yellow_house == null) {
            yellow_house = new MutableLiveData<>();
            loadYellowHouseInfo();
        }
        return yellow_house;
    }

    public LiveData<String> getStoneHouseInfo() {
        if (stone_house == null) {
            stone_house = new MutableLiveData<>();
            loadStoneHouseInfo();
        }
        return stone_house;
    }

    public LiveData<String> getAMGroveHouseInfo() {
        if (a_m_grove_house == null) {
            a_m_grove_house = new MutableLiveData<>();
            loadAMGroveHouseInfo();
        }
        return a_m_grove_house;
    }

    public LiveData<String> getCreditInfo() {
        if (credit == null) {
            credit = new MutableLiveData<>();
            loadCreditInfo();
        }
        return credit;
    }

    //load the information with the .setValue method
    private void loadFirstHeaderInfo() {
        firstHeader.setValue("Ma &amp; Pa Railroad Heritage Village Map - Walking Tour");
    }

    private void loadFirstInfo() {
        first.setValue("Come visit the historic Ma &amp; Pa Railroad Heritage Village at Muddy Creek Forks. The buildings are open during our operating season (June-Sept). The grounds are open for self-guided tours year-round.");
    }

    private void loadSecondInfo() {
        second.setValue("Take a walking tour of Muddy Creek Forks. Click on the building you would like to know more about.");
    }

    private void loadThirdInfo() {
        third.setValue("Walking Tour Buildings:");
    }

    private void loadFourthInfo() {
        fourth.setValue("This walking tour is designed to give you an overview of the village and some understanding of what life was like here when Muddy Creek Forks was an important commercial hub centered about the Maryland &amp; Pennsylvania Railroad (the Ma &amp; Pa).");
    }

    private void loadFifthInfo() {
        fifth.setValue("Much of what we know about this village in the early part of the twentieth century is based on the detailed recollections of Dr. Bruce Grove who was born in Muddy Creek Forks in 1900 and grew up here helping our in many business activities of his uncle, A.M. Grove. Before his death in 1996, Dr. Grove shared these recollections in a series of oral history interviews.");
    }

    private void loadAMGroveGeneralStoreInfo() {
        a_m_grove_general_store.setValue("1. A.M. Grove General Store");
    }

    private void loadRailroadStationPlatformInfo() {
        railroad_station_platform.setValue("2. Railroad Station Platform");
    }

    private void loadMillRaceInfo() {
        mill_race.setValue("3. Mill Race");
    }

    private void loadOriginalStoreSiteInfo() {
        original_store_site.setValue("4. Original Store Site");
    }

    private void loadRollerMillsInfo() {
        roller_mills.setValue("5. Roller Mills");
    }

    private void loadGrainElevatorInfo() {
        grain_elevator.setValue("6. Grain Elevator, Grain Chute, and Scale House");
    }

    private void loadFertilizerWarehouseInfo() {
        fertilizer_warehouse.setValue("7. Fertilizer Warehouse and Coal Bins");
    }

    private void loadBarnInfo() {
        barn.setValue("8. Barn");
    }

    private void loadCornCribsInfo() {
        corn_cribs.setValue("9. Corn Cribs");
    }

    private void loadCornHuskingShedInfo() {
        corn_husking_shed.setValue("10. Corn Husking Shed (Garage) and Cannery Ruins");
    }

    private void loadRailroadToolHouseInfo() {
        railroad_tool_house.setValue("11. Railroad Tool House");
    }

    private void loadJamesGroveHouseInfo() {
        james_grove_house.setValue("12. James Grove House");
    }

    private void loadTeamTrackInfo() {
        team_track.setValue("13. Team Track");
    }

    private void loadMilkCollectionBuildingInfo() {
        milk_collection_building.setValue("14. Milk Collection Building");
    }

    private void loadKeisersFertilizerWarehouseInfo() {
        keisers_fertilizer_warehouse.setValue("15. Keiser's Fertilizer Warehouse");
    }

    private void loadMillTailRaceInfo() {
        mill_tail_race.setValue("16. Mill Tail Race");
    }

    private void loadMillLoadingPlatformInfo() {
        mill_loading_platform.setValue("17. Mill Loading Platform");
    }

    private void loadThingsInfo() {
        things_that_are_now_gone.setValue("18. Things that are now gone");
    }

    private void loadYellowHouseInfo() {
        yellow_house.setValue("19. Yellow House");
    }

    private void loadStoneHouseInfo() {
        stone_house.setValue("20. Stone House");
    }

    private void loadAMGroveHouseInfo() {
        a_m_grove_house.setValue("21. A.M. Grove House");
    }

    private void loadCreditInfo() {
        credit.setValue("All information for the walking tour was compiled by Craig Sansonetti.");
    }


}
