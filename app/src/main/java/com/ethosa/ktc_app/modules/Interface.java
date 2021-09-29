package com.ethosa.ktc_app.modules;

import android.util.Log;
import com.ethosa.ktc_app.interfaces.APIInterface;

public class Interface implements APIInterface {
    @Override
    public void onHTMLUpdate(String html) {
        Log.i("APIInterface", html);
    }
}
