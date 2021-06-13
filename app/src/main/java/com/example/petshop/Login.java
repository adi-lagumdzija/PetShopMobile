package com.example.petshop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button l_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        l_Button = findViewById(R.id.loginbutton);
    }

    public void onLoginClick (View view) {
        int[] userExists = new int[1];
        User user = new User(username.getText().toString(), password.getText().toString());
        if (validate(user)) {
            PetShopDatabase database = PetShopDatabase.getPetShopDatabase(getApplicationContext());
            UserDao userDao = database.userDao();
            userExists[0] = userDao.login(username.getText().toString(), password.getText().toString());
            Log.d("app", userExists[0] + "  " + username.getText().toString());
            if (userExists[0] == 1) {
                Toast.makeText(getApplicationContext(), "Successfully Logged In!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, mainPage.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Try logging in again. Check your credentials!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Some fields are missing!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate(User user) {
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }
        return true;
    }
    public void onCreateAccount (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

