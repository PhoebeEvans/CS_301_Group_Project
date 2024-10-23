package com.example.maandparailroadapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author Phoebe
 * @date 10/23/2024
 * @description Fragment for the explore village page
 */

public class ExploreVillageFragment  extends Fragment {
    //ViewModel for this fragment
    private ExploreVillageViewModel exploreViewModel;

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return Return the View for the fragment's UI, or null.
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_explore_village, container, false);

        //Instantiate the firstHeader TextView in the layout.
        TextView first_header = root.findViewById(R.id.textview_firstHeader);
        //Instantiate the first TextView in the layout.
        TextView first = root.findViewById(R.id.textview_first);
        //Instantiate the second TextView in the layout.
        TextView second = root.findViewById(R.id.textview_second);
        //Instantiate the third TextView in the layout.
        TextView third = root.findViewById(R.id.textview_third);
        //Instantiate the fourth TextView in the layout.
        TextView fourth = root.findViewById(R.id.textview_fourth);
        //Instantiate the fifth TextView in the layout.
        TextView fifth = root.findViewById(R.id.textview_fifth);
        //Instantiate the general store TextView in the layout.
        TextView a_m_grove_general_store = root.findViewById(R.id.a_m_grove_general_store);
        //Instantiate the railroad_station_platform TextView in the layout.
        TextView railroad_station_platform = root.findViewById(R.id.railroad_station_platform);
        //Instantiate the mill_race TextView in the layout.
        TextView mill_race = root.findViewById(R.id.mill_race);
        //Instantiate the original_store_site TextView in the layout.
        TextView original_store_site = root.findViewById(R.id.original_store_site);
        //Instantiate the roller_mills TextView in the layout.
        TextView roller_mills = root.findViewById(R.id.roller_mills);
        //Instantiate the grain_elevator TextView in the layout.
        TextView grain_elevator = root.findViewById(R.id.grain_elevator);
        //Instantiate the fertilizer_warehouse TextView in the layout.
        TextView fertilizer_warehouse = root.findViewById(R.id.fertilizer_warehouse);
        //Instantiate the barn TextView in the layout.
        TextView barn = root.findViewById(R.id.barn);
        //Instantiate the corn_cribs TextView in the layout.
        TextView corn_cribs = root.findViewById(R.id.corn_cribs);
        //Instantiate the corn_husking_shed TextView in the layout.
        TextView corn_husking_shed = root.findViewById(R.id.corn_husking_shed);
        //Instantiate the railroad_tool_house TextView in the layout.
        TextView railroad_tool_house = root.findViewById(R.id.railroad_tool_house);
        //Instantiate the james_grove_house TextView in the layout.
        TextView james_grove_house = root.findViewById(R.id.james_grove_house);
        //Instantiate the team_track TextView in the layout.
        TextView team_track = root.findViewById(R.id.team_track);
        //Instantiate the milk_collection_building TextView in the layout.
        TextView milk_collection_building = root.findViewById(R.id.milk_collection_building);
        //Instantiate the keisers_fertilizer_warehouse TextView in the layout.
        TextView keisers_fertilizer_warehouse = root.findViewById(R.id.keisers_fertilizer_warehouse);
        //Instantiate the mill_tail_race TextView in the layout.
        TextView mill_tail_race = root.findViewById(R.id.mill_tail_race);
        //Instantiate the mill_loading_platform TextView in the layout.
        TextView mill_loading_platform = root.findViewById(R.id.mill_loading_platform);
        //Instantiate the things TextView in the layout.
        TextView things = root.findViewById(R.id.things_that_are_now_gone);
        //Instantiate the yellow house TextView in the layout.
        TextView yellow_house = root.findViewById(R.id.yellow_house);
        //Instantiate the stone_house TextView in the layout.
        TextView stone_house = root.findViewById(R.id.stone_house);
        //Instantiate the A M Grove House TextView in the layout.
        TextView a_m_grove_house = root.findViewById(R.id.a_m_grove_house);
        //Instantiate the credit TextView in the layout.
        TextView credit = root.findViewById(R.id.credit);



        // Initialize the ViewModel for this fragment
        exploreViewModel = new ViewModelProvider(this).get(ExploreVillageViewModel.class);

        //This observes live data and will update the TextView with new information.
        exploreViewModel.getFirstHeaderInfo().observe(getViewLifecycleOwner(), info -> {
            first_header.setText(info);
        });

        exploreViewModel.getFirstInfo().observe(getViewLifecycleOwner(), info -> {
            first.setText(info);
        });

        exploreViewModel.getSecondInfo().observe(getViewLifecycleOwner(), info -> {
            second.setText(info);
        });

        exploreViewModel.getThirdInfo().observe(getViewLifecycleOwner(), info -> {
            third.setText(info);
        });

        exploreViewModel.getFourthInfo().observe(getViewLifecycleOwner(), info -> {
            fourth.setText(info);
        });

        exploreViewModel.getFifthInfo().observe(getViewLifecycleOwner(), info -> {
            fifth.setText(info);
        });

        exploreViewModel.getAMGroveGeneralStoreInfo().observe(getViewLifecycleOwner(), info -> {
            a_m_grove_general_store.setText(info);
        });

        exploreViewModel.getRailroadStationPlatformInfo().observe(getViewLifecycleOwner(), info -> {
            railroad_station_platform.setText(info);
        });

        exploreViewModel.getMillRaceInfo().observe(getViewLifecycleOwner(), info -> {
            mill_race.setText(info);
        });

        exploreViewModel.getOriginalStoreSiteInfo().observe(getViewLifecycleOwner(), info -> {
            original_store_site.setText(info);
        });

        exploreViewModel.getRollerMillsInfo().observe(getViewLifecycleOwner(), info -> {
            roller_mills.setText(info);
        });

        exploreViewModel.getGrainElevatorInfo().observe(getViewLifecycleOwner(), info -> {
            grain_elevator.setText(info);
        });

        exploreViewModel.getFertilizerWarehouseInfo().observe(getViewLifecycleOwner(), info -> {
            fertilizer_warehouse.setText(info);
        });

        exploreViewModel.getBarnInfo().observe(getViewLifecycleOwner(), info -> {
            barn.setText(info);
        });

        exploreViewModel.getCornCribsInfo().observe(getViewLifecycleOwner(), info -> {
            corn_cribs.setText(info);
        });

        exploreViewModel.getCornHuskingShedInfo().observe(getViewLifecycleOwner(), info -> {
            corn_husking_shed.setText(info);
        });

        exploreViewModel.getRailroadToolHouseInfo().observe(getViewLifecycleOwner(), info -> {
            railroad_tool_house.setText(info);
        });

        exploreViewModel.getJamesGroveHouseInfo().observe(getViewLifecycleOwner(), info -> {
            james_grove_house.setText(info);
        });

        exploreViewModel.getTeamTrackInfo().observe(getViewLifecycleOwner(), info -> {
            team_track.setText(info);
        });

        exploreViewModel.getMilkCollectionBuildingInfo().observe(getViewLifecycleOwner(), info -> {
            milk_collection_building.setText(info);
        });

        exploreViewModel.getKeisersFertilizerWarehouseInfo().observe(getViewLifecycleOwner(), info -> {
            keisers_fertilizer_warehouse.setText(info);
        });

        exploreViewModel.getMillTailRaceInfo().observe(getViewLifecycleOwner(), info -> {
            mill_tail_race.setText(info);
        });

        exploreViewModel.getMillLoadingPlatformInfo().observe(getViewLifecycleOwner(), info -> {
            mill_loading_platform.setText(info);
        });

        exploreViewModel.getThingsInfo().observe(getViewLifecycleOwner(), info -> {
            things.setText(info);
        });

        exploreViewModel.getYellowHouseInfo().observe(getViewLifecycleOwner(), info -> {
            yellow_house.setText(info);
        });

        exploreViewModel.getStoneHouseInfo().observe(getViewLifecycleOwner(), info -> {
            stone_house.setText(info);
        });

        exploreViewModel.getAMGroveHouseInfo().observe(getViewLifecycleOwner(), info -> {
            a_m_grove_house.setText(info);
        });

        exploreViewModel.getCreditInfo().observe(getViewLifecycleOwner(), info -> {
            credit.setText(info);

        });


            //Returns the actual view of the fragment.
        return root;
    }

}
