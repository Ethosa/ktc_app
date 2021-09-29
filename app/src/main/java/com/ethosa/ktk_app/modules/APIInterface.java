package com.ethosa.ktk_app.modules;

import android.util.Log;

public class APIInterface implements com.ethosa.ktk_app.interfaces.APIInterface {
    @Override
    public void onHTMLUpdate(String html) {
        Log.i("APIInterface", html);
    }
}
