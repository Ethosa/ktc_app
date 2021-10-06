package com.ethosa.ktc_app.callbacks;

import android.annotation.SuppressLint;
import android.view.View;

import com.ethosa.ktc_app.APIInterface;
import com.ethosa.ktc_app.R;
import com.ethosa.ktc_app.databinding.FragmentTimetableBinding;
import com.ethosa.ktc_app.objects.Course;
import com.ethosa.ktc_app.objects.Courses;
import com.ethosa.ktc_app.ui.timetable.TimetableFragment;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;


public class CoursesCallback implements APIInterface<Courses> {
    private final FragmentTimetableBinding binding;
    private final TimetableFragment timetableFragment;

    public CoursesCallback(TimetableFragment timetableFragment, FragmentTimetableBinding binding) {
        this.binding = binding;
        this.timetableFragment = timetableFragment;
    }

    @SuppressLint("ResourceAsColor")
    private void fillCourse(List<Course> data, ChipGroup group) {
        for (Course course : data) {
            Chip btn = new Chip(timetableFragment.getContext());
            btn.setPadding(0, 0, 0, 0);
            btn.setText(course.title);
            btn.setTextColor(timetableFragment.getResources().getColor(R.color.text_color));
            btn.setChipBackgroundColorResource(R.color.foreground_color);
            btn.setOnClickListener(view -> {
                timetableFragment.getCollege().loadTimetable(course, timetableFragment.getCallback());
                binding.coursesScroll.setVisibility(View.GONE);
                timetableFragment.getPreferences().edit().putString("groupId", course.id).apply();
            });
            group.addView(btn);
        }
    }

    @Override
    public void onResult(Courses courses) {
        timetableFragment.getActivity().runOnUiThread(() -> {
            fillCourse(courses.data.get(0), binding.first);
            fillCourse(courses.data.get(1), binding.second);
            fillCourse(courses.data.get(2), binding.third);
            fillCourse(courses.data.get(3), binding.fourth);
        });
    }
}
