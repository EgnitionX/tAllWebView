package com.example.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    mWebView = findViewById(R.id.activity_main_webview);
    WebSettings webSettings = mWebView.getSettings(); // Fixed the dash to an equals sign
    
    // The "Magic Three" lines for React/Vite apps:
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDomStorageEnabled(true);           // Fixed the 'truel' typo
    webSettings.setDatabaseEnabled(true);            // Added for extra stability
    
    mWebView.setWebViewClient(new MyWebViewClient());
    
    // Make sure this line exists to actually start the load!
    mWebView.loadUrl(getString(R.string.website_url));
}


        // REMOTE RESOURCE
        // mWebView.loadUrl("https://cool-chaja-b1ab61.netlify.app/");

        // LOCAL RESOURCE
        // mWebView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
