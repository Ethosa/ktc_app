package com.ethosa.ktk_app.modules;

import android.webkit.JavascriptInterface;

public class JS {
    private final APIInterface apiInterface;

    public JS(APIInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    @JavascriptInterface
    @SuppressWarnings("unused")
    public void processHTML(String html)
    {
        apiInterface.onHTMLUpdate(html);
    }
}
