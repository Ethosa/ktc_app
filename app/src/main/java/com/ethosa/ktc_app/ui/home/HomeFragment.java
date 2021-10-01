package com.ethosa.ktc_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.ethosa.ktc_app.R;
import com.ethosa.ktc_app.databinding.FragmentHomeBinding;
import com.ethosa.ktc_app.modules.NewsAdapter;
import com.ethosa.ktc_app.objects.NewItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        List<NewItem> list = new ArrayList<>();
        list.add(new NewItem(1, "Hello, world!", "First new!", "Today", ""));
        list.add(new NewItem(2, "Hello, world!!", "First new!", "Today", ""));
        list.add(new NewItem(3, "Hello, world!!!", "First new!", "Today", ""));
        list.add(new NewItem(4, "Hello, world!!!!", "First new!", "Today", ""));
        list.add(new NewItem(5, "Hello, world!!!!!", "First new!", "Today", ""));
        NewsAdapter adapter = new NewsAdapter(getContext(), R.layout.wall_post, list);
        binding.newsList.setAdapter(adapter);

        System.out.println(list.size());

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