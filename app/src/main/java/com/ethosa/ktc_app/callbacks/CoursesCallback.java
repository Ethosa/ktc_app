package com.ethosa.ktc_app.callbacks;

import com.ethosa.ktc_app.APIInterface;
import com.ethosa.ktc_app.databinding.FragmentTimetableBinding;
import com.ethosa.ktc_app.objects.Course;
import com.ethosa.ktc_app.objects.Courses;
import com.ethosa.ktc_app.ui.timetable.TimetableFragment;
import com.google.android.material.chip.Chip;

public class CoursesCallback implements APIInterface<Courses> {
    private FragmentTimetableBinding binding;
    private TimetableFragment timetableFragment;

    public CoursesCallback(TimetableFragment timetableFragment, FragmentTimetableBinding binding) {
        this.binding = binding;
        this.timetableFragment = timetableFragment;
    }

    private Chip createButton(String text) {
        Chip btn = new Chip(timetableFragment.getContext());
        btn.setPadding(0, 0, 0, 0);
        btn.setText(text);
        return  btn;
    }

    @Override
    public void onResult(Courses courses) {
        timetableFragment.getActivity().runOnUiThread(() -> {
            for (Course course : courses.data.get(0)) {
                Chip btn = createButton(course.title);
                binding.first.addView(btn);
            }
            for (Course course : courses.data.get(1)) {
                Chip btn = createButton(course.title);
                binding.second.addView(btn);
            }
            for (Course course : courses.data.get(2)) {
                Chip btn = createButton(course.title);
                binding.third.addView(btn);
            }
            for (Course course : courses.data.get(3)) {
                Chip btn = createButton(course.title);
                binding.fourth.addView(btn);
            }
        });
    }
}
