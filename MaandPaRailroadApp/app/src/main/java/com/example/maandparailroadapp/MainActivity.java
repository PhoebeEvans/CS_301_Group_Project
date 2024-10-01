package com.example.maandparailroadapp;

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

        // Handle menu item clicks in NavigationView using if-else
        binding.navView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                navController.navigate(R.id.FirstFragment); // Navigate to FirstFragment (Home)
            } else if (itemId == R.id.nav_second_fragment) {
                navController.navigate(R.id.SecondFragment); // Navigate to SecondFragment (Details)
            } else if (itemId == R.id.action_settings) {
                // Handle settings navigation, if applicable
            } else if (itemId == R.id.login){
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            } else if (itemId == R.id.register){
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }

            drawerLayout.closeDrawers(); // Close drawer after selecting
            return true;
        });


        Button btn = findViewById(R.id.signIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}
