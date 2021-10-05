package com.ethosa.ktc_app.ui;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ethosa.ktc_app.databinding.WallPostBinding;
import com.ethosa.ktc_app.objects.NewItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    public List<NewItem> data;
    private final int layout;
    private ItemClickListener listener;

    private final LayoutInflater inflater;

    public NewsAdapter(Context context, int layout, List<NewItem> data) {
        this.data = data;
        this.layout = layout;

        inflater = LayoutInflater.from(context);
        Picasso.with(inflater.getContext().getApplicationContext())
                .setLoggingEnabled(true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewItem item = data.get(position);
        holder.binding.newsTitle.setText(item.title);
        holder.binding.newsBody.setText(item.body);
        holder.binding.newsDate.setText(item.date);

        Picasso.with(inflater.getContext().getApplicationContext())
                .load(item.image)
                .into(holder.binding.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        WallPostBinding binding;

        ViewHolder(View itemView) {
            super(itemView);
            this.binding = WallPostBinding.bind(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public NewItem getItem(int id) {
        return data.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
