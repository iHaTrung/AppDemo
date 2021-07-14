package com.example.demoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.demoapp.R;
import com.example.demoapp.adapter.NotiScheduleAdapter;
import com.example.demoapp.adapter.NotificationAdapter;
import com.example.demoapp.databinding.ActivityNotificationBinding;
import com.example.demoapp.databinding.ActivityScheduleBinding;
import com.example.demoapp.model.NotiNotification;
import com.example.demoapp.model.NotiSchedule;
import com.example.demoapp.model.response.ScheduleResponse;
import com.example.demoapp.network.RetrofitClient;
import com.example.demoapp.utils.Globals;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {


    ActivityNotificationBinding binding;
    List<NotiNotification> notificationsList;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewNotificationMore);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        notificationsList = new ArrayList<NotiNotification>();

        notificationsList.add(new NotiNotification("タイトル: 緊急火災警報器",
                "内容: このエリアで緊急警報を発します。 早急 に火が 必要です。. ",
                "時間: 2019/12/23    15:00",
                "名所: Akasaka",
                null));
        notificationsList.add(new NotiNotification("タイトル: bao chay",
                "内容: bao chay ",
                "時間: 2021/06/03     22:57",
                "名所: Hanoi",
                null));
        notificationsList.add(new NotiNotification("タイトル: bao chay",
                "内容: bao chay ",
                "時間: 2021/03/31     08:07",
                "名所: Hanoi",
                null));
        notificationsList.add(new NotiNotification("タイトル: abc",
                "内容: abc ",
                "時間: 2021/03/22     07:53",
                "名所: Tầng 10 Tháp A3, ,P Q, 58 Tố Hữu, Trung Văn, Nam Từ Liêm, Hà Nội, Vietnam",
                "Tầng 10 Tháp A3, ,P Q, 58 Tố Hữu, Trung Văn, Nam Từ Liêm, Hà Nội, Vietnam"));
        notificationsList.add(new NotiNotification("タイトル: Thai1103-2",
                "内容: Hi ",
                "時間: 2021/03/12     10:56",
                "名所: 58 Tố Hữu, Trung Văn, Thanh Trì, Hà Nội, Việt Nam",
                "58 Tố Hữu, Trung Văn, Thanh Trì, Hà Nội, Việt Nam"));
        notificationsList.add(new NotiNotification("タイトル: abc",
                "内容: hello a Hai 1234 ",
                "時間: 2021/03/11     03:19",
                "名所: Tầng 10 Tháp A3, ,P Q, 58 Tố Hữu, Trung Văn, Nam Từ Liêm, Hà Nội, Vietnam",
                "Tầng 10 Tháp A3, ,P Q, 58 Tố Hữu, Trung Văn, Nam Từ Liêm, Hà Nội, Vietnam"));


        NotificationAdapter adapterNoti = new NotificationAdapter(this,notificationsList);
        recyclerView.setAdapter(adapterNoti);

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(nextScreen);
            }
        });
    }


}
