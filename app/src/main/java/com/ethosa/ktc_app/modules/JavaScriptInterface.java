package com.ethosa.ktc_app.modules;

import android.webkit.JavascriptInterface;

import com.ethosa.ktc_app.callbacks.HTMLUpdateCallback;

public class JavaScriptInterface {
    private final HTMLUpdateCallback apiInterface;

    public JavaScriptInterface(HTMLUpdateCallback apiInterface) {
        this.apiInterface = apiInterface;
    }

    @JavascriptInterface
    public void processHTML(String html)
    {
        apiInterface.onResult(html);
    }
}
