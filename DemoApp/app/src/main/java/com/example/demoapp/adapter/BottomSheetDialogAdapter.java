package com.example.demoapp.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.demoapp.R;
import com.example.demoapp.activity.AddEmergencyActivity;
import com.example.demoapp.activity.AddNotificationActivity;
import com.example.demoapp.activity.CommunicationsActivity;
import com.example.demoapp.activity.ForgotPassActivity;
import com.example.demoapp.activity.HomeActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialogAdapter extends BottomSheetDialogFragment {

    TextView btnAddSchedule;
    TextView btnCancelDialog;
    TextView btnCreateNotification;
    TextView btnCommunication;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        btnAddSchedule = v.findViewById(R.id.btnAddSchedule);
        btnAddSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity(), AddNotificationActivity.class);
                startActivity(nextScreen);
            }
        });

        btnCancelDialog = v.findViewById(R.id.btnCancelDialog);
        btnCancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnCreateNotification = v.findViewById(R.id.btnEditArticle);
        btnCreateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity(), AddEmergencyActivity.class);
                startActivity(nextScreen);
            }
        });

        btnCommunication = v.findViewById(R.id.btnCommi);
        btnCommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getActivity(), CommunicationsActivity.class);
                startActivity(nextScreen);
            }
        });


//        algo_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Toast.makeText(getActivity(),
//                        "Algorithm Shared", Toast.LENGTH_SHORT)
//                        .show();
//                dismiss();
//            }
//        });
//
//        course_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Toast.makeText(getActivity(),
//                        "Course Shared", Toast.LENGTH_SHORT)
//                        .show();
//                dismiss();
//            }
//        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogAdapter.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }
}
