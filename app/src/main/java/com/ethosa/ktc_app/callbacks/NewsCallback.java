package com.ethosa.ktc_app.callbacks;

import android.content.Context;

import com.ethosa.ktc_app.APIInterface;
import com.ethosa.ktc_app.modules.NewsAdapter;
import com.ethosa.ktc_app.objects.NewItem;

import java.util.List;

public class NewsCallback implements APIInterface<List<NewItem>> {
    private NewsAdapter adapter;
    private Context context;

    public NewsCallback(Context context, NewsAdapter adapter) {
        this.adapter = adapter;
        this.context = context;
    }

    @Override
    public void onResult(List<NewItem> value) {
        System.out.println(value.get(0).id);
        adapter.data = value;
    }
}
