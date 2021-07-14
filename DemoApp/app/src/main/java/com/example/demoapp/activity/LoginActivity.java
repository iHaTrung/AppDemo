package com.example.demoapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import com.example.demoapp.databinding.ActivityLoginBinding;
import com.example.demoapp.model.LoginResponse;
import com.example.demoapp.network.RetrofitClient;
import com.example.demoapp.utils.Globals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               callApiLogin(binding.txtEmail.getText().toString(),binding.txtPassword.getText().toString());
            }
        });

        binding.txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent forgotPassScreen = new Intent(getApplicationContext(), ForgotPassActivity.class);
                    startActivity(forgotPassScreen);
            }
        });

        String text = "新規登録の方はこちら";
        SpannableString ss = new SpannableString(text);

        ClickableSpan btnReg = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent nextScreen = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(nextScreen);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(ds.linkColor);
            }
        };
        ss.setSpan(btnReg, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.txtRegister.setText(ss);
        binding.txtRegister.setMovementMethod(LinkMovementMethod.getInstance());

        binding.txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(registerScreen);
            }
        });

        binding.txtEmail.setText("hungdv.jvb@gmail.com");
        binding.txtPassword.setText("12345678");
    }

    private void callApiLogin(String userId,String password){
        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .apiLogin(userId,password,"1234","2");

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse=response.body();
                if (loginResponse.getCode()==200){
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent nextSceen = new Intent(getApplicationContext(), HomeActivity.class);
                    Globals.getInstance().setLoggedIn(true);
                    Globals.getInstance().setUserToken(loginResponse.getData().getToken_login());
                    startActivity(nextSceen);
                }else {
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}