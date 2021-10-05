package com.ethosa.ktc_app.callbacks;

import androidx.recyclerview.widget.RecyclerView;

import com.ethosa.ktc_app.APIInterface;
import com.ethosa.ktc_app.R;
import com.ethosa.ktc_app.ui.NewsAdapter;
import com.ethosa.ktc_app.objects.NewItem;
import com.ethosa.ktc_app.ui.home.HomeFragment;

import java.util.List;

public class NewsCallback implements APIInterface<List<NewItem>> {
    private RecyclerView recyclerView;
    private HomeFragment homeFragment;

    public NewsCallback(HomeFragment homeFragment, RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.homeFragment = homeFragment;
    }

    @Override
    public void onResult(List<NewItem> value) {
        homeFragment.getActivity().runOnUiThread(() -> {
            recyclerView.setAdapter(new NewsAdapter(homeFragment.getContext(), R.layout.wall_post, value));
            recyclerView.getAdapter().notifyDataSetChanged();
        });
    }
}
