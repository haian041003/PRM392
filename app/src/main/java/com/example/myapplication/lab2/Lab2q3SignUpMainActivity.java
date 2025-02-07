 package com.example.myapplication.lab2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.R;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

 public class Lab2q3SignUpMainActivity extends AppCompatActivity {
     private EditText editTextNewUsername;
     private EditText editTextNewPassword;
     private EditText editTextConfirmPassword;
     private Button buttonSignUp;

     private final String REQUIRE = "Require";

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         EdgeToEdge.enable(this);
         setContentView(R.layout.activity_lab2q3__signup_main);

         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
             Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
             return insets;
         });

         editTextNewUsername = findViewById(R.id.editTextNewUsername);
         editTextNewPassword = findViewById(R.id.editTextNewPassword);
         editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
         buttonSignUp = findViewById(R.id.buttonSignUp);

         // Handle sign up
         buttonSignUp.setOnClickListener(v -> handleSignUp());
     }

     private void handleSignUp() {
         String email = editTextNewUsername.getText().toString().trim();
         String password = editTextNewPassword.getText().toString().trim();
         String confirmPassword = editTextConfirmPassword.getText().toString().trim();

         if (email.isEmpty()) {
             editTextNewUsername.setError("Email is required");
             editTextNewUsername.requestFocus();
             return;
         }

         if (password.isEmpty()) {
             editTextNewPassword.setError("Password is required");
             editTextNewPassword.requestFocus();
             return;
         }

         if (password.length() < 6) {
             editTextNewPassword.setError("Password should be at least 6 characters");
             editTextNewPassword.requestFocus();
             return;
         }

         if (!password.equals(confirmPassword)) {
             editTextConfirmPassword.setError("Passwords do not match");
             editTextConfirmPassword.requestFocus();
             return;
         }

         // TODO: Add your registration logic here
         // For demo purposes, we'll just show a success message
         Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
         finish(); // Return to login screen
     }
 }