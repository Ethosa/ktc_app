package com.ethosa.ktk_app.modules;

import android.util.Log;
import com.ethosa.ktk_app.interfaces.APIInterface;

public class Interface implements APIInterface {
    @Override
    public void onHTMLUpdate(String html) {
        Log.i("APIInterface", html);
    }
}
