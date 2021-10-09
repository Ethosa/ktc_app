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
    private TimetableCallback callback;

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
        String savedGroup = "";
        if (!((savedGroup = preferences.getString("groupId", "")).equals(""))) {
            Course course = Course.from(savedGroup);
            college.loadTimetable(course, callback);
            binding.titlebar.setVisibility(View.VISIBLE);
            binding.coursesScroll.setVisibility(View.GONE);
        } else {
            loadCourses();
        }
    }

    private void initUI() {
        List<Lesson> items = new ArrayList<>();
        TimetableAdapter adapter = new TimetableAdapter(getContext(), R.layout.lesson, items);

        binding.timetable.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        binding.timetable.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.timetable.setAdapter(adapter);

        binding.back.setOnClickListener(view -> {
            preferences.edit().putString("groupId", "").apply();
            binding.titlebar.setVisibility(View.GONE);
            binding.coursesScroll.setVisibility(View.VISIBLE);
            binding.timetable.setVisibility(View.GONE);
            binding.first.removeAllViews();
            binding.second.removeAllViews();
            binding.third.removeAllViews();
            binding.fourth.removeAllViews();
            loadCourses();
        });
    }

    private void loadCourses() {
        college.loadCourses(new CoursesCallback(this, binding));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}