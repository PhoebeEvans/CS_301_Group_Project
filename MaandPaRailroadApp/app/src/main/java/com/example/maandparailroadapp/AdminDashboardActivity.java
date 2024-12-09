package com.example.maandparailroadapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.maandparailroadapp.database.DBHelper;

public class AdminDashboardActivity extends AppCompatActivity {

    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.admin_dashboard);

        sessionManager = new SessionManager(this);

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
