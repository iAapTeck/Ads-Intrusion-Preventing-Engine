package com.iaapteck.ansefy_technologies.library.ads_intrusion_preventing_engine;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.iaapteck.ansefy_technologies.library.ads_intrusion_preventing_engine.util.AdsIntrusionPrevention;
//import com.iaapteck.ansefy_technologies.library.

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        new AdsIntrusionPreventingEninge.init(this).initializeWebView(webView);
        webView.setWebViewClient(new Browser_home());
        //webView.loadUrl("https://www.tutorialspoint.com/css/index.htm");
        webView.loadUrl("https://stackoverflow.com/questions/51902629/how-to-allow-all-network-connection-types-http-and-https-in-android-9-pie");
    }

    private static class Browser_home extends WebViewClient {
        Browser_home() {}

        @Nullable
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            return AdsIntrusionPreventingEninge.blockAds(view, url) ? AdsIntrusionPrevention.createEmptyResource() :
                    super.shouldInterceptRequest(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}