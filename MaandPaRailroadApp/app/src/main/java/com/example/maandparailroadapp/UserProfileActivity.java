package com.example.maandparailroadapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.maandparailroadapp.database.DBHelper;

public class UserProfileActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.user_profile);

        dbHelper = DBHelper.getInstance(this);
        sessionManager = new SessionManager(this);

        if (sessionManager.isLoggedIn()) {
            String username = sessionManager.getUsername();
            String email = sessionManager.getEmail();
        } else { // Handle the case where the user is not logged in
            startActivity(new Intent(UserProfileActivity.this, LoginActivity.class));
            finish();
        }
    /*
        TextView btn = findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserSavedEventsFragment fragment = new UserSavedEventsFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });*/

        EditText usernameTextField = findViewById(R.id.userProfileUsername);
        EditText emailTextField = findViewById(R.id.userProfileEmail);

        // Sets the field with the user information
        usernameTextField.setText(sessionManager.getUsername());
        emailTextField.setText(sessionManager.getEmail());

        TextView backBtn = findViewById(R.id.backTitle);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this, MainActivity.class));
            }
        });

        TextView btnUpdate = findViewById(R.id.newBtn);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean allFieldsFilled = true;

                // Gets the values in the text fields
                String username = usernameTextField.getText().toString();
                if (usernameTextField.getText().toString().isEmpty()) {
                    usernameTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                String email = emailTextField.getText().toString();
                if (emailTextField.getText().toString().isEmpty()) {
                    emailTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                EditText currentPasswordTextField = findViewById(R.id.userProfileCurrentPassword);
                String currentPassword = currentPasswordTextField.getText().toString();
                if (currentPasswordTextField.getText().toString().isEmpty()) {
                    currentPasswordTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                EditText newPasswordTextField = findViewById(R.id.userProfileNewPassword);
                String newPassword = newPasswordTextField.getText().toString();
                if (newPasswordTextField.getText().toString().isEmpty()) {
                    newPasswordTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                EditText confirmPasswordTextField = findViewById(R.id.userProfileConfirmPassword);
                String confirmPassword = confirmPasswordTextField.getText().toString();
                if (confirmPasswordTextField.getText().toString().isEmpty()) {
                    confirmPasswordTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                if (allFieldsFilled) {
                    User user = sessionManager.getUser();
                    if (currentPassword.equals(user.getPassword())) {
                        if (!newPassword.equals(confirmPassword)) {
                            // Password and Confirm Password do not match
                            confirmPasswordTextField.setError("Passwords do not match.");
                        } else {
                            // Updates the user and navigates to account
                            User updatedUser = new User(username, email, newPassword, 0);
                            /**
                             int isUpdated = dbHelper.updateUser(updatedUser);
                             if (isUpdated == 0) {
                             Toast.makeText(UserProfileActivity.this, "User updated successfully", Toast.LENGTH_SHORT).show();
                             sessionManager.createLoginSession(updatedUser);
                             } else {
                             Toast.makeText(UserProfileActivity.this, "Update failed", Toast.LENGTH_SHORT).show();
                             } **/

                        }
                    } else {
                        currentPasswordTextField.setError("Incorrect Password");
                    }
                }
            }
        });

        // This is for navigating to the Event Management page
        TextView btn2 = findViewById(R.id.saveButton);
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
