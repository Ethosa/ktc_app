package com.ethosa.ktc_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ethosa.ktc_app.modules.College;
import com.ethosa.ktc_app.databinding.ActivityMainBinding;

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