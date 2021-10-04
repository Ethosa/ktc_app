package com.ethosa.ktc_app.ui.timetable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ethosa.ktc_app.callbacks.CoursesCallback;
import com.ethosa.ktc_app.databinding.FragmentTimetableBinding;
import com.ethosa.ktc_app.modules.College;
import com.ethosa.ktc_app.objects.Courses;

public class TimetableFragment extends Fragment {
    private FragmentTimetableBinding binding;
    private College college;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTimetableBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        college = new College(getContext());
        initUI();

        return root;
    }

    private void initUI() {
        college.loadCourses(new CoursesCallback(this, binding));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}