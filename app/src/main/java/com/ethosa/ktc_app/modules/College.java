package com.ethosa.ktc_app.modules;


import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ethosa.ktc_app.callbacks.CoursesCallback;
import com.ethosa.ktc_app.callbacks.HTMLUpdateCallback;
import com.ethosa.ktc_app.callbacks.NewsCallback;
import com.ethosa.ktc_app.objects.Courses;
import com.ethosa.ktc_app.objects.NewItems;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class College {

    private static final String API_URL = "http://api.kansk-tc.ru/";
    private static final String PRO_URL = "https://pro.kansk-tc.ru/";
    private final WebView webView;
    private final OkHttpClient client;
    private final Connection session;
    private final Gson gson;

    @SuppressLint("SetJavaScriptEnabled")
    public College(Context context) {
        webView = new WebView(context);
        client = new OkHttpClient();
        session = Jsoup.newSession();
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        gson = builder.create();

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

        webView.loadUrl(PRO_URL + "login");
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url){
                view.evaluateJavascript(js, val -> updateHTML());
            }
        });
    }

    public void loadCourses(CoursesCallback callback) {
        final String url = PRO_URL + "blocks/manage_groups/website/list.php?id=1";

        new Thread(() -> {
            try {
                Document doc = session.newRequest().url(url).get();
                Courses courses = Courses.parse(doc);
                callback.onResult(courses);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void getNews(NewsCallback callback) {
        Request request = new Request.Builder()
                .url(API_URL + "news/")
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String r = response.body().string();
                NewItems data = gson.fromJson(r, NewItems.class);
                callback.onResult(data.anonce);
            }
        });
    }
}
