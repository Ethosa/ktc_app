package com.ethosa.ktc_app.callbacks;

import android.util.Log;
import com.ethosa.ktc_app.APIInterface;

public class HTMLUpdateCallback implements APIInterface {
    @Override
    public void onHTMLUpdate(String html) {
        Log.i("APIInterface", html);
    }
}
