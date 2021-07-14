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
import com.example.demoapp.databinding.ActivityHomeBinding;
import com.example.demoapp.databinding.ActivityScheduleBinding;
import com.example.demoapp.model.LoginResponse;
import com.example.demoapp.model.NotiNotification;
import com.example.demoapp.model.NotiSchedule;
import com.example.demoapp.model.ScheduleAddingResponse;
import com.example.demoapp.model.others.BaseData;
import com.example.demoapp.model.response.ScheduleResponse;
import com.example.demoapp.network.RetrofitClient;
import com.example.demoapp.utils.Globals;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleActivity extends AppCompatActivity {

    ActivityScheduleBinding binding;
    List<NotiSchedule> notiScheduleList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScheduleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        callApiSchedule(2,10,0);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewScheduleMore);
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
        notiScheduleList.add(new NotiSchedule("タイトル: Thai1103-2",
                "内容: Hi",
                "時間:  2021/03/11    13:23  ~  2021/03/11    14:23",
                "名所: 58 Tố Hữu, Trung Văn, Thanh Trì, Hà Nội, Việt Nam",
                "住所: 58 Tố Hữu, Trung Văn, Thanh Trì, Hà Nội, Việt Nam"));
        notiScheduleList.add(new NotiSchedule("タイトル: abc",
                "内容: hello a Hai 1234",
                "時間:  2021/03/12    02:09  ~  2021/03/12    02:09",
                "名所: Tầng 10 Tháp A3, ,P Q, 58 Tố Hữu, Trung Văn, Nam Từ Liêm, Hà Nội, Vietnam",
                "住所: Tầng 10 Tháp A3, ,P Q, 58 Tố Hữu, Trung Văn, Nam Từ Liêm, Hà Nội, Vietnam"));
        notiScheduleList.add(new NotiSchedule("タイトル: abcdefghikelmsn",
                "内容: hello how are you",
                "時間:  2021/03/10    09:19  ~  2021/03/10    09:19",
                "名所: 6 Lê Thạch, French Quarter, Hoàn Kiếm, Hà Nội, Vietnam",
                "住所: 6 Lê Thạch, French Quarter, Hoàn Kiếm, Hà Nội, Vietnam"));

        NotiScheduleAdapter adapter = new NotiScheduleAdapter(this,notiScheduleList);
        recyclerView.setAdapter(adapter);

        binding.btnBackAddNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(nextScreen);
            }
        });
    }

    private void callApiSchedule(int type,int limit, int page){
        Call<ScheduleResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .userScheduleLoadMore(type,limit,page, getToken());

        call.enqueue(new Callback<ScheduleResponse>() {
            @Override
            public void onResponse(Call<ScheduleResponse> call, Response<ScheduleResponse> response) {
                ScheduleResponse scheduleResponse = response.body();
                if (scheduleResponse.getCode() == 200) {
                    Toast.makeText(ScheduleActivity.this, scheduleResponse.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ScheduleActivity.this, scheduleResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ScheduleResponse> call, Throwable t) {
                Toast.makeText(ScheduleActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private String getToken() {
        String token = Globals.getInstance().getUserToken();
        return "Bearer " + token.concat("R9W1oXsUwU");
    }
}