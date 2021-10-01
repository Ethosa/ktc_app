package com.ethosa.ktc_app.modules;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ethosa.ktc_app.R;
import com.ethosa.ktc_app.objects.NewItem;

import java.util.Collections;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<List<NewItem>> {
    private int resourceLayout;
    private Context mContext;
    private List<NewItem> items;

    public NewsAdapter(Context context, int resource, List<NewItem> items) {
        super(context, resource, Collections.singletonList(items));
        this.resourceLayout = resource;
        this.mContext = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        NewItem data = items.get(position);
        System.out.println(position);

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        if (data != null) {
            final TextView title = v.findViewById(R.id.new_title);
            final TextView body = v.findViewById(R.id.new_body);
            final ImageView image = v.findViewById(R.id.image);

            title.setText(data.title);
            body.setText(data.body);
        }

        return v;
    }
}
