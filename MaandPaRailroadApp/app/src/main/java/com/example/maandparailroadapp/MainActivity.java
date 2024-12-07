package com.example.maandparailroadapp;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import android.view.MenuItem;
import com.example.maandparailroadapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import android.content.Intent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        DrawerLayout drawerLayout = binding.drawerLayout;
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Set up AppBarConfiguration for drawer navigation
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setOpenableLayout(drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        /*
        @author Griffin
         */
        // Handle menu item clicks in NavigationView using if-else
        binding.navView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                navController.navigate(R.id.FirstFragment); // Navigate to FirstFragment (Home)
            } else if (itemId == R.id.nav_second_fragment) {
                navController.navigate(R.id.SecondFragment); // Navigate to SecondFragment (Details)
            } else if (itemId == R.id.nav_gallery) {
                navController.navigate(R.id.GalleryFragment); // Navigate to GalleryFragment
            } else if (itemId == R.id.nav_village) {
                navController.navigate(R.id.VillageFragment); // Navigate to VillageFragment
            } else if (itemId == R.id.nav_train_ride) {
                navController.navigate(R.id.TrainRideFragment); // Navigate to TrainRideFragment
            } else if (itemId == R.id.nav_hours) {
                navController.navigate(R.id.HoursFragment); // Navigate to HoursFragment
            } else if (itemId == R.id.nav_events) {
                navController.navigate(R.id.EventsFragment); // Navigate to EventsFragment
            } else if (itemId == R.id.nav_directions) {
                navController.navigate(R.id.DirectionsFragment); // Navigate to DirectionsFragment
            } else if (itemId == R.id.nav_contact) {
                navController.navigate(R.id.ContactFragment); // Navigate to ContactFragment
            } else if (itemId == R.id.action_settings) {
                // Handle settings navigation, if applicable
            } else if (itemId == R.id.login){
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            } else if (itemId == R.id.register){
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }else if (itemId == R.id.nav_equipment) {
                navController.navigate(R.id.EquipmentFragment); // Navigate to EquipmentFragment
            }else if (itemId == R.id.nav_explore) {
                navController.navigate(R.id.ExploreVillageFragment); // Navigate to ExploreVillageFragment
            }else if (itemId == R.id.nav_history) {
                navController.navigate(R.id.HistoryFragment); // Navigate to HistoryFragment
            }else if (itemId == R.id.nav_industries) {
                navController.navigate(R.id.IndustriesFragment); // Navigate to IndustriesFragment
            }else if (itemId == R.id.nav_join) {
                navController.navigate(R.id.JoinFragment); // Navigate to JoinFragment
            }else if (itemId == R.id.nav_links) {
                navController.navigate(R.id.LinksFragment); // Navigate to LinksFragment
            }else if (itemId == R.id.nav_memories) {
                navController.navigate(R.id.MemoriesFragment); // Navigate to MemoriesFragment
            }else if (itemId == R.id.nav_newsletter) {
                navController.navigate(R.id.NewsletterFragment); // Navigate to NewsletterFragment
            }

            drawerLayout.closeDrawers(); // Close drawer after selecting
            return true;
        });

    /*
    @author Lauren
     */
        Button btn = findViewById(R.id.signIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        Button facebookButton = findViewById(R.id.button_facebook);
        Button amazonButton = findViewById(R.id.button_amazon);
        facebookButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            intent.putExtra("url", "https://www.facebook.com/MaAndPaRailroad");
            startActivity(intent);
        });
        amazonButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            intent.putExtra("url", "https://www.amazon.com/gp/product/B0013JWTHY/ref=as_li_tf_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=B0013JWTHY&linkCode=as2&tag=maparaipresoc-20");
            startActivity(intent);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}
