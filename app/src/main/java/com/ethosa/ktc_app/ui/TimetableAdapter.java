package com.ethosa.ktc_app.ui;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ethosa.ktc_app.databinding.LessonBinding;
import com.ethosa.ktc_app.objects.Lesson;

import java.util.List;

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.ViewHolder> {
    public List<Lesson> data;
    private final int layout;
    private ItemClickListener listener;

    private final LayoutInflater inflater;

    public TimetableAdapter(Context context, int layout, List<Lesson> data) {
        this.data = data;
        this.layout = layout;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lesson item = data.get(position);

        holder.binding.dayHeaderBlock.setVisibility(View.GONE);
        if (position == 0 || (position > 0 && item.weekDay > getItem(position-1).weekDay)) {
            holder.binding.dayHeaderBlock.setVisibility(View.VISIBLE);
            holder.binding.dayHeader.setText(item.weekDayHeader);
        }

        holder.binding.lessonNumber.setText(item.lessonNumber);
        holder.binding.lessonFrom.setText(item.from);
        holder.binding.lessonTo.setText(item.to);
        holder.binding.lessonTitle.setText(item.title);
        holder.binding.lessonClassroom.setText(item.classroom);
        holder.binding.lessonTeacher.setText(item.teacher);
        System.out.println(holder.binding.dayHeader.getText().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LessonBinding binding;
        TextView dayHeader;

        ViewHolder(View itemView) {
            super(itemView);
            this.binding = LessonBinding.bind(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public Lesson getItem(int id) {
        return data.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
