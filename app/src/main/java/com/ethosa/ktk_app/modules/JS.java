package com.ethosa.ktk_app.modules;

import android.webkit.JavascriptInterface;

public class JS {
    private final Interface apiInterface;

    public JS(Interface apiInterface) {
        this.apiInterface = apiInterface;
    }

    @JavascriptInterface
    @SuppressWarnings("unused")
    public void processHTML(String html)
    {
        apiInterface.onHTMLUpdate(html);
    }
}
