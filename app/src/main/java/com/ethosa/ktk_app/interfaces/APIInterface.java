package com.ethosa.ktk_app.interfaces;

import android.util.Log;

public interface APIInterface {
    default void onHTMLUpdate(String html) {
        Log.i("APIInterface", "HTML updated!");
    }
}
