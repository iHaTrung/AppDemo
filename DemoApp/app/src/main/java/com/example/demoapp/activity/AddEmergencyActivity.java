package com.example.demoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.demoapp.databinding.ActivityAddEmergencyBinding;
import com.example.demoapp.databinding.ActivityAddNotificationBinding;
import com.example.demoapp.model.ScheduleAddingResponse;
import com.example.demoapp.network.RetrofitClient;
import com.example.demoapp.utils.Globals;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEmergencyActivity extends AppCompatActivity {

    ActivityAddEmergencyBinding binding;
    Calendar c;
    DatePickerDialog dpd;
    private int mHour, mMinute;
    double mLatitude, mLongitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        binding = ActivityAddEmergencyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (getIntent().getExtras() != null) {
            com.example.demoapp.model.Place mPlace = (com.example.demoapp.model.Place) getIntent().getSerializableExtra("place");
            String address = mPlace.getAddress();
            mLatitude = mPlace.getLatitude();
            mLongitude = mPlace.getLongitude();
            binding.textAddressStreet.setText(address);
        }


        binding.btnBackAddNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(nextScreen);
            }
        });

        binding.textAddressStreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainScreen = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(mainScreen);
                finish();
            }
        });

        binding.textTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(AddEmergencyActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = year + "/" + (month + 1) + "/" + dayOfMonth;
                        //binding.textTimeStart.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        TimePickerDialog timePickerDialog = new TimePickerDialog(AddEmergencyActivity.this,
                                new TimePickerDialog.OnTimeSetListener() {

                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay,
                                                          int minute) {

                                        binding.textTimeStart.setText(date + "\t" + hourOfDay + ":" + minute);
                                    }
                                }, mHour, mMinute, false);
                        timePickerDialog.show();
                    }

                }, day, month, year);

                dpd.show();
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog

            }
        });

        binding.textTimeEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(AddEmergencyActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = year + "/" + (month + 1) + "/" + dayOfMonth;
                        //binding.textTimeStart.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        TimePickerDialog timePickerDialog = new TimePickerDialog(AddEmergencyActivity.this,
                                new TimePickerDialog.OnTimeSetListener() {

                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay,
                                                          int minute) {

                                        binding.textTimeEnd.setText(date + "\t" + hourOfDay + ":" + minute);
                                    }
                                }, mHour, mMinute, false);
                        timePickerDialog.show();
                    }

                }, day, month, year);

                dpd.show();
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);
            }
        });

        binding.btnSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = binding.textAddressStreet.getText().toString();
                String content = binding.textAddTitle.getText().toString();
                String detail_address = binding.textAddPlace.getText().toString();
                String time_start = binding.textTimeStart.getText().toString();
                String time_end = binding.textTimeEnd.getText().toString();
                int type = 1;
                double latitude = mLatitude;
                double longitude = mLongitude;

                callApiAddNoti(title, content, time_start, time_end, type, title, detail_address, latitude, longitude);

            }
        });

    }


    private void callApiAddNoti(String title, String content, String time_start,
                                String time_end, int type, String title_address, String detail_address,
                                double latitude, double longitude) {
        Call<ScheduleAddingResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .addNotification(title, content, time_start, time_end, type, title_address, detail_address, latitude, longitude, getToken());

        call.enqueue(new Callback<ScheduleAddingResponse>() {
            @Override
            public void onResponse(Call<ScheduleAddingResponse> call, Response<ScheduleAddingResponse> response) {

                ScheduleAddingResponse scheduleAddingResponse = response.body();
                if (scheduleAddingResponse.getCode() == 200) {
                    Toast.makeText(AddEmergencyActivity.this, scheduleAddingResponse.getMessage(), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(AddEmergencyActivity.this, scheduleAddingResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ScheduleAddingResponse> call, Throwable t) {
                Toast.makeText(AddEmergencyActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getToken() {
        String token = Globals.getInstance().getUserToken();
        return "Bearer " + token.concat("R9W1oXsUwU");
    }
}