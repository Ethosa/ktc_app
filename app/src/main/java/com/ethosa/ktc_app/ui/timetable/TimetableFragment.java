package com.ethosa.ktc_app.ui.timetable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.ethosa.ktc_app.databinding.FragmentTimetableBinding;

public class TimetableFragment extends Fragment {
    private FragmentTimetableBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTimetableBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initUI();
        return root;
    }

    private void initUI() {
        binding.textTimetable.setText("This is timetable");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}