package com.ethosa.ktc_app;

import android.util.Log;

public interface APIInterface {
    default void onHTMLUpdate(String html) {
        Log.i("APIInterface", "HTML updated!");
    }
}
