package com.ethosa.ktc_app.ui.timetable;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.ethosa.ktc_app.objects.Course;
import com.ethosa.ktc_app.objects.Lesson;
import com.ethosa.ktc_app.ui.TimetableAdapter;

import java.util.ArrayList;
import java.util.List;

public class TimetableFragment extends Fragment {
    private FragmentTimetableBinding binding;
    private SharedPreferences preferences;
    private College college;
    private TimetableAdapter adapter;
    private TimetableCallback callback;
    private String savedGroup = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTimetableBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        college = new College(getContext());
        callback = new TimetableCallback(this, binding.timetable);
        preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        initUI();
        initPreferences();

        return root;
    }

    public TimetableCallback getCallback() {
        return callback;
    }

    public College getCollege() {
        return college;
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    private void initPreferences() {
        if (!((savedGroup = preferences.getString("groupId", "")).equals(""))) {
            Course course = Course.from(savedGroup);
            college.loadTimetable(course, callback);
            binding.coursesScroll.setVisibility(View.GONE);
        } else {
            college.loadCourses(new CoursesCallback(this, binding));
        }
    }

    private void initUI() {
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