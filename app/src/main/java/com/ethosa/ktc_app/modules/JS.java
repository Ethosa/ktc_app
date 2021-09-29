package com.ethosa.ktc_app.modules;

import android.webkit.JavascriptInterface;

public class JS {
    private final Interface apiInterface;

    public JS(Interface apiInterface) {
        this.apiInterface = apiInterface;
    }

    @JavascriptInterface
    public void processHTML(String html)
    {
        apiInterface.onHTMLUpdate(html);
    }
}
