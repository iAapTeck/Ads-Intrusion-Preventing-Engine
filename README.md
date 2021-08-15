# Ads Intrusion Preventing Engine Library 
Ads Intrusion Preventing Engine is a simple library to block ads Intrusion in web dataserver. this code is basicaly stop the ads and remove the html from it and render it again.

[![](https://jitpack.io/v/iAapTeck/Ads-Intrusion-Preventing-Engine.svg)](https://jitpack.io/#iAapTeck/Ads-Intrusion-Preventing-Engine)

## How can you use this to your project?

### Step 1

Add it in your root build.gradle at the end of repositories:
 
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 
 ### Step 2
 
 Add the dependency in app level build.gradle file
 
 ```gradle
 	dependencies {
	        implementation 'com.github.iAapTeck:Ads-Intrusion-Preventing-Engine:1.0'
	}
```
	
### Step 3

Inisialize the webview in your activity where you have the webview.

```java
new AdsIntrusionPreventingEninge.init(this).initializeWebView(webView);
```

### Step 4

Now to block ads intrusion, we need to add this code in the WebViewClient so extentd the WebViewClient for your webview like this and then in the class overide this method.


```java
webView.setWebViewClient(new Browser_home());
```

```java
private class Browser_home extends WebViewClient {

        Browser_home() {}

        @SuppressWarnings("deprecation")
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {

            return AdsIntrusionPreventingEninge.blockAds(view,url) ? AdsIntrusionPrevention.createEmptyResource() :
                    super.shouldInterceptRequest(view, url);

        }

    }
```


Now you can run your app to see if the ads instrusion are blocked. You can always use other webview features and add fetures to the webview.
