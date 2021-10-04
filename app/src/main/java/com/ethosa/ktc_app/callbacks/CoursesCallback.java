package com.ethosa.ktc_app.callbacks;

import com.ethosa.ktc_app.APIInterface;
import com.ethosa.ktc_app.databinding.FragmentTimetableBinding;
import com.ethosa.ktc_app.objects.Course;
import com.ethosa.ktc_app.objects.Courses;
import com.ethosa.ktc_app.ui.timetable.TimetableFragment;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;


public class CoursesCallback implements APIInterface<Courses> {
    private FragmentTimetableBinding binding;
    private TimetableFragment timetableFragment;

    public CoursesCallback(TimetableFragment timetableFragment, FragmentTimetableBinding binding) {
        this.binding = binding;
        this.timetableFragment = timetableFragment;
    }

    private void fillCourse(List<Course> data, ChipGroup group) {
        for (Course course : data) {
            Chip btn = new Chip(timetableFragment.getContext());
            btn.setPadding(0, 0, 0, 0);
            btn.setText(course.title);
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
