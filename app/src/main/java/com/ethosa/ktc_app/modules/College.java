package com.ethosa.ktc_app.modules;


import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ethosa.ktc_app.callbacks.HTMLUpdateCallback;

public class College {

    private static final String URL = "https://pro.kansk-tc.ru/";
    private final WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    public College(Context context) {
        webView = new WebView(context);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUserAgentString("Mozilla");
        webView.addJavascriptInterface(new JavaScriptInterface(new HTMLUpdateCallback(this)), "Android");
    }

    public void updateHTML() {
        webView.loadUrl("javascript:window.Android.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
    }

    public void auth(String login, String password) {
        final String js = "javascript:" +
                "document.getElementById('username').value='" + login + "';" +
                "document.getElementById('password').value='" + password + "';" +
                "document.getElementById('loginbtn').click();";

        webView.loadUrl(URL + "login");
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url){
                view.evaluateJavascript(js, val -> updateHTML());
            }
        });
    }
}
