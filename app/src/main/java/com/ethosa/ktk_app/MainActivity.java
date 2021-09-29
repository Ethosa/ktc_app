package com.ethosa.ktk_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ethosa.ktk_app.databinding.ActivityMainBinding;
import com.ethosa.ktk_app.modules.College;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private College college;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        college = new College(this);

        initUI();
    }

    private void initUI() {
        binding.login.setOnClickListener(view -> college.auth(
                Objects.requireNonNull(binding.username.getEditText()).toString(),
                Objects.requireNonNull(binding.password.getEditText()).toString()));
    }

}