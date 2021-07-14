package com.example.demoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.demoapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ImageView btnBack;

    ActivityRegisterBinding binding;

    String[] cars = {"都道府県を選択 *", "Ferrari","Lamborghini","Rolls Roys"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View regView = binding.getRoot();
        setContentView(regView);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainScreen = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(mainScreen);
            }
        });

        binding.txtProvincial.setAdapter(new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,cars ));
        binding.btnSendRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"Register",Toast.LENGTH_SHORT).show();
            }
        });

    }
}