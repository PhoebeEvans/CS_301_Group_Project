package com.example.maandparailroadapp;

import static java.lang.String.valueOf;
import static java.sql.Types.NULL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        TextView btn=findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        TextView btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
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

                EditText emailTextField = findViewById(R.id.inputEmail);
                String email = emailTextField.getText().toString();
                if (emailTextField.getText().toString().isEmpty()) {
                    emailTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                EditText passwordTextField = findViewById(R.id.enterPassword);
                String password = passwordTextField.getText().toString();
                if (passwordTextField.getText().toString().isEmpty()) {
                    passwordTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                EditText cPasswordTextField = findViewById(R.id.inputConfirmPassword);
                String cPassword = cPasswordTextField.getText().toString();
                if (cPasswordTextField.getText().toString().isEmpty()) {
                    cPasswordTextField.setError("This field is required");
                    allFieldsFilled = false;
                }

                if (allFieldsFilled){
                    if(!password.equals(cPassword)){
                        // Password and Confirm Password do not match
                        // TODO: throw error message
                    } else {
                        // Creates a new user and navigates to account
                        User newUser = new User(username, email, password, false);
                        SharedList.users.add(newUser);

                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                }
            }
        });
    }
}