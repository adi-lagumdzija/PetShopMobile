package com.example.petshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginActivity extends AppCompatActivity {
private Button button;
private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.registerbutton);
        button1 = findViewById(R.id.loginbutton);
    }
    public void openRegisterActivity(View view) {
        Intent intent = new Intent(this, registerActivity.class);
        startActivity(intent);
    }
    public void openMainPageActivity(View view) {
        Intent intent = new Intent(this, mainPage.class);
        startActivity(intent);
    }
}