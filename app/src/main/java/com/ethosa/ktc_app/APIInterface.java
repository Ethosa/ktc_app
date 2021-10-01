package com.ethosa.ktc_app;

import android.util.Log;

public interface APIInterface<T> {
    default void onResult(T html) {
        Log.i("APIInterface", "HTML updated!");
    }
}
