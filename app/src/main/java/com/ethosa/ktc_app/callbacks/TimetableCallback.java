package com.ethosa.ktc_app.callbacks;

import androidx.recyclerview.widget.RecyclerView;

import com.ethosa.ktc_app.APIInterface;
import com.ethosa.ktc_app.R;
import com.ethosa.ktc_app.objects.Day;
import com.ethosa.ktc_app.objects.Lesson;
import com.ethosa.ktc_app.objects.Timetable;
import com.ethosa.ktc_app.ui.TimetableAdapter;
import com.ethosa.ktc_app.ui.timetable.TimetableFragment;

import java.util.ArrayList;
import java.util.List;

public class TimetableCallback implements APIInterface<Timetable> {
    private final TimetableFragment timetableFragment;
    private final RecyclerView recyclerView;

    public TimetableCallback(TimetableFragment timetableFragment, RecyclerView recyclerView) {
        this.timetableFragment = timetableFragment;
        this.recyclerView = recyclerView;
    }

    private List<Lesson> loadFromTimetable(Timetable timetable) {
        List<Lesson> result = new ArrayList<>();

        for (int i = 0; i < timetable.week.size(); ++i) {
            Day day = timetable.week.get(i);
            for (Lesson lesson : day.lessons) {
                if (lesson.title.equals("")) {
                    continue;
                }
                lesson.weekDay = i;
                lesson.weekDayHeader = day.day;
                result.add(lesson);
            }
        }

        return result;
    }

    @Override
    public void onResult(Timetable result) {
        System.out.println(result);
        timetableFragment.getActivity().runOnUiThread(() -> {
            recyclerView.setAdapter(new TimetableAdapter(
                    timetableFragment.getActivity().getApplicationContext(), R.layout.lesson, loadFromTimetable(result)));
            recyclerView.getAdapter().notifyDataSetChanged();
        });
    }
}
