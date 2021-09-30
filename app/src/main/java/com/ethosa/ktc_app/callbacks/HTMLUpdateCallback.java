package com.ethosa.ktc_app.callbacks;

import android.util.Log;
import com.ethosa.ktc_app.APIInterface;
import com.ethosa.ktc_app.modules.College;

public class HTMLUpdateCallback implements APIInterface {
    private College college;

    public HTMLUpdateCallback(College obj) {
        college = obj;
    }

    @Override
    public void onHTMLUpdate(String html) {
        Log.i("APIInterface", html);
    }
}
