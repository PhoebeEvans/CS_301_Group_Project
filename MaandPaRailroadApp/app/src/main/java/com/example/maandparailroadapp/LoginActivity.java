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

public class LoginActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private SessionManager sessionManager;
    private UserSessionManager userSessionManager; // Add UserSessionManager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        dbHelper = DBHelper.getInstance(this);
        sessionManager = new SessionManager(this);
        userSessionManager = new UserSessionManager(this); // Initialize UserSessionManager

        TextView btn = findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        TextView btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean allFieldsFilled = true;

                // Gets the values in the text fields
                EditText usernameTextField = findViewById(R.id.enterUsername);
                String username = usernameTextField.getText().toString();
                if (usernameTextField.getText().toString().isEmpty()) {
                    usernameTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                EditText passwordTextField = findViewById(R.id.enterPassword);
                String password = passwordTextField.getText().toString();
                if (passwordTextField.getText().toString().isEmpty()) {
                    passwordTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                if (allFieldsFilled) {
                    User correctUser = null;
                    for (User user : dbHelper.getAllUsers()) {
                        if (username.equals(user.getUsername())) {
                            // Finds the correct user
                            correctUser = user;
                        }
                    }

                    if (correctUser != null) {
                        if (password.equals(correctUser.getPassword())) {
                            sessionManager.createLoginSession(correctUser);
                            userSessionManager.saveUsername(correctUser.getUsername()); // Save username
                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {
                            passwordTextField.setError("Incorrect Password");
                        }
                    } else {
                        usernameTextField.setError("This user does not exist.");
                    }
                }
            }
        });
    }
}
