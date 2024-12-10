package com.example.maandparailroadapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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

        User currentUser;
        if (sessionManager.isLoggedIn()) {
            String username = sessionManager.getUsername();
            String email = sessionManager.getEmail();

            List<User> userList = dbHelper.getAllUsers();
            for(User user: userList){
                if(user.getUsername().equals(username) && user.getEmail().equals(email)){
                    currentUser = user;

                    if(currentUser.getIsAdmin()==0){
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
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminDashboardActivity.this, MainActivity.class));
            }
        });

        TextView btn = findViewById(R.id.userManagementBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminDashboardActivity.this, UserManagementActivity.class));
            }
        });

        // This is for navigating to the Event Management page
        /**
        TextView btn2 = findViewById(R.id.eventManagementBtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminDashboardActivity.this, LoginActivity.class));
            }
        }); **/

    }
}
