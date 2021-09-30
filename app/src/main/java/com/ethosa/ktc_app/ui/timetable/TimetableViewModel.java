package com.ethosa.ktc_app.ui.timetable;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class TimetableViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TimetableViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is timetable fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}