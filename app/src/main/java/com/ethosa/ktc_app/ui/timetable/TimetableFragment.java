package com.ethosa.ktc_app.ui.timetable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ethosa.ktc_app.R;
import com.ethosa.ktc_app.callbacks.CoursesCallback;
import com.ethosa.ktc_app.callbacks.TimetableCallback;
import com.ethosa.ktc_app.databinding.FragmentTimetableBinding;
import com.ethosa.ktc_app.modules.College;
import com.ethosa.ktc_app.objects.Lesson;
import com.ethosa.ktc_app.ui.TimetableAdapter;

import java.util.ArrayList;
import java.util.List;

public class TimetableFragment extends Fragment {
    private FragmentTimetableBinding binding;
    public College college;
    public TimetableAdapter adapter;
    public TimetableCallback callback;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTimetableBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        college = new College(getContext());
        callback = new TimetableCallback(this, binding.timetable);
        initUI();

        return root;
    }

    private void initUI() {
        college.loadCourses(new CoursesCallback(this, binding));
        List<Lesson> items = new ArrayList<>();
        adapter = new TimetableAdapter(getContext(), R.layout.lesson, items);

        binding.timetable.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.timetable.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.timetable.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}