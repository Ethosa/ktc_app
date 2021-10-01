package com.ethosa.ktc_app.ui.home;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.ethosa.ktc_app.R;
import com.ethosa.ktc_app.callbacks.NewsCallback;
import com.ethosa.ktc_app.databinding.FragmentHomeBinding;
import com.ethosa.ktc_app.modules.College;
import com.ethosa.ktc_app.modules.NewsAdapter;
import com.ethosa.ktc_app.objects.NewItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private NewsAdapter adapter;
    private College college;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        college = new College(getContext());
        List<NewItem> items = new ArrayList<>();
        adapter = new NewsAdapter(getContext(), R.layout.wall_post, items);

        binding.news.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.news.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.news.setAdapter(adapter);
        System.out.println(1);
//        college.getNews(new NewsCallback(getContext(), adapter));

        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> {
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}