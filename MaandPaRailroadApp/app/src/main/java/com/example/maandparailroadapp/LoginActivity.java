package com.example.maandparailroadapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        TextView btn=findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        TextView btnLogin=findViewById(R.id.btnLogin);
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

                if(allFieldsFilled){
                    User correctUser = null;
                    for (User user : SharedList.users) {
                        if(username.equals(user.getUsername())){
                            // Finds the correct user
                            correctUser = user;
                        }
                    }

                    if(correctUser != null){
                        if(password.equals(correctUser.getPassword())){
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                        else {
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