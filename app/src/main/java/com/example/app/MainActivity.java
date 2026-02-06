package com.slymax.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // 1. We create the WebView manually to avoid XML 'ID' bugs
        mWebView = new WebView(this);
        
        // 2. Standard settings for modern apps
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        // 3. Keep the user INSIDE the app
        mWebView.setWebViewClient(new WebViewClient());

        // 4. Load the content
        setContentView(mWebView);
        mWebView.loadUrl("https://YOUR-SITE.netlify.app");
    }

    // Prevents crash when hitting the back button
    @Override
    public void onBackPressed() {
        if (mWebView != null && mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
