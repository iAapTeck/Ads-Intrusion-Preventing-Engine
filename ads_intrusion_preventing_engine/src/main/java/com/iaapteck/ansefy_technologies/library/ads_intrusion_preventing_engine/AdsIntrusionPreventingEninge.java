package com.iaapteck.ansefy_technologies.library.ads_intrusion_preventing_engine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.iaapteck.ansefy_technologies.library.ads_intrusion_preventing_engine.util.AdsIntrusionPrevention;

import java.util.HashMap;
import java.util.Map;

public class AdsIntrusionPreventingEninge {

    static Map<String, Boolean> loadedUrls = new HashMap<>();

    public static boolean blockAds(WebView view, String url) {
        boolean ad;
        if (!loadedUrls.containsKey(url)) {
            ad = AdsIntrusionPrevention.isAd(url);
            loadedUrls.put(url, ad);
        } else {
            ad = loadedUrls.get(url);
        }
        return ad;
    }

    public static class init {
            Context context;

        public init(Context context) {
            AdsIntrusionPrevention.init(context);
            this.context = context;
        }

        @SuppressLint("SetJavaScriptEnabled")
        public void initializeWebView(WebView mWebView) {
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            webSettings.setDomStorageEnabled(true);
        }
    }
}
