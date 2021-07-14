package com.example.demoapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.demoapp.R;
import com.example.demoapp.adapter.BottomSheetDialogAdapter;
import com.example.demoapp.adapter.NotiScheduleAdapter;
import com.example.demoapp.adapter.NotificationAdapter;
import com.example.demoapp.databinding.ActivityHomeBinding;
import com.example.demoapp.databinding.NavigationbarHeaderBinding;
import com.example.demoapp.model.NotiNotification;
import com.example.demoapp.model.NotiSchedule;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity  {

    ActivityHomeBinding binding;

    NavigationbarHeaderBinding headerBinding;

    List<NotiSchedule> notiScheduleList;
    List<NotiNotification> notificationsList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        headerBinding = NavigationbarHeaderBinding.inflate(getLayoutInflater(), binding.navView,false);
        binding.navView.addHeaderView(headerBinding.getRoot());


        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:{
                        Toast.makeText(HomeActivity.this,"HOME", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.action_information: {
                        Toast.makeText(HomeActivity.this,"INFORMATION", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.action_contact:{
                        Toast.makeText(HomeActivity.this,"CONTACT", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewSchedule);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        notiScheduleList = new ArrayList<>();

        notiScheduleList.add(new NotiSchedule("タイトル: 最初のトレーニングスケジュール",
                "内容: このエリアで緊急警報を発します。 早急 に火が 必要です。. ",
                "時間:  2019/12/23    15:00  ~  2019/12/23    18:00",
                "名所: Akasaka",
                "住所: 東京都文京区本郷７丁目３−１ copy"));
        notiScheduleList.add(new NotiSchedule("タイトル: bao chay",
                "内容: bao chay ",
                "時間:  2020/04/23    19:00  ~  2020/04/24    21:00",
                "名所: Hanoi",
                "住所: Hanoi"));
        notiScheduleList.add(new NotiSchedule("タイトル: abc",
                "内容: abc",
                "時間:  2021/03/22   07:52  ~  2021/03/22    07:52",
                "名所: Tầng 10 Tháp A3, ,P Q, 58 Tố Hữu, Trung Văn, Nam Từ Liêm, Hà Nội, Vietnam",
                "住所: Tầng 10 Tháp A3, ,P Q, 58 Tố Hữu, Trung Văn, Nam Từ Liêm, Hà Nội"));

        NotiScheduleAdapter adapter = new NotiScheduleAdapter(this,notiScheduleList);
        recyclerView.setAdapter(adapter);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewNotification);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        notificationsList = new ArrayList<NotiNotification>();

        notificationsList.add(new NotiNotification("タイトル: 緊急火災警報器",
                "内容: このエリアで緊急警報を発します。 早急 に火が 必要です。. ",
                "時間: 2019/12/23    15:00",
                "名所: Akasaka",
                null));
        notificationsList.add(new NotiNotification("タイトル: 緊急火災警報器",
                "内容: このエリアで緊急警報を発します。 早急 に火が 必要です。. ",
                "時間: 2019/12/23    15:00",
                "名所: Akasaka",
                null));
        notificationsList.add(new NotiNotification("タイトル: 緊急火災警報器",
                "内容: このエリアで緊急警報を発します。 早急 に火が 必要です。. ",
                "時間: 2019/12/23    15:00",
                "名所: Akasaka",
                "住所: 東京都文京区本郷７丁目３−１ copy 2"));


        NotificationAdapter adapterNoti = new NotificationAdapter(this,notificationsList);
        recyclerView.setAdapter(adapterNoti);

        binding.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerLayout.openDrawer(binding.navView);
            }
        });

        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_noti:{
                        Toast.makeText(HomeActivity.this,"Clicked!!!!!!",Toast.LENGTH_SHORT).show();
                        binding.drawerLayout.closeDrawer(binding.navView);}
                    case R.id.item_profile:{
                        Toast.makeText(HomeActivity.this,"Clicked!!!!!!",Toast.LENGTH_SHORT).show();
                        binding.drawerLayout.closeDrawer(binding.navView);}
                    case R.id.item_logout:{
                        Intent nextScreen = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(nextScreen);
                        binding.drawerLayout.closeDrawer(binding.navView);}
                }
                return true;
            }
        });

        headerBinding.btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerLayout.closeDrawer(binding.navView);
            }
        });
        binding.btnCreateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogAdapter bottomSheetDialogAdapter = new BottomSheetDialogAdapter();
                bottomSheetDialogAdapter.show(getSupportFragmentManager(), "demoBottomSheet");
            }
        });

        binding.btnMoreSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), ScheduleActivity.class);
                startActivity(nextScreen);
            }
        });
        binding.btnMoreNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), NotificationActivity.class);
                startActivity(nextScreen);
            }
        });

    }
}