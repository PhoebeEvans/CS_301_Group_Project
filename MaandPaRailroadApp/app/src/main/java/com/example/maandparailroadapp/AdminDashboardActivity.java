package com.example.maandparailroadapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.maandparailroadapp.database.DBHelper;

import java.util.List;

public class AdminDashboardActivity extends AppCompatActivity {

    private SessionManager sessionManager;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.admin_dashboard);

        sessionManager = new SessionManager(this);
        dbHelper = DBHelper.getInstance(this);

        User currentUser = null;
        if (sessionManager.isLoggedIn()) {
            String username = sessionManager.getUsername();
            String email = sessionManager.getEmail();

            List<User> userList = dbHelper.getAllUsers();
            for (User user : userList) {
                if (user.getUsername().equals(username) && user.getEmail().equals(email)) {
                    currentUser = user;

                    if (currentUser.getIsAdmin() == 0) {
                        Toast.makeText(AdminDashboardActivity.this, "This User does not have Admin Roles", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AdminDashboardActivity.this, MainActivity.class));
                    }
                }
            }
        } else { // Handle the case where the user is not logged in
            startActivity(new Intent(AdminDashboardActivity.this, LoginActivity.class));
            finish();
        }

        TextView backBtn = findViewById(R.id.backTitle2);
        backBtn.setOnClickListener(view -> startActivity(new Intent(AdminDashboardActivity.this, MainActivity.class)));

        TextView btn = findViewById(R.id.userManagementBtn);
        btn.setOnClickListener(view -> startActivity(new Intent(AdminDashboardActivity.this, UserManagementActivity.class)));

        // This is for navigating to the Event Management page
        TextView btn2 = findViewById(R.id.eventManagementBtn);
        btn2.setOnClickListener(view -> navigateToFragment(new AdminSavedEventsFragment()));
    }

    /**
     * Navigate to a specified fragment.
     *
     * @param fragment The fragment to navigate to.
     */
    private void navigateToFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment); // Make sure fragment_container exists in your layout
        transaction.addToBackStack(null); // Optional: to add the transaction to the back stack
        transaction.commit();
    }
}
