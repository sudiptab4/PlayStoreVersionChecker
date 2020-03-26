package com.sudipta.versionchecker;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class PlayStoreVersionChecker {

    Context c;
    String packageName;
    WebView webView;
    String versionCode="";
    VersionCallBack back;
    public PlayStoreVersionChecker(Activity c,String packageName,VersionCallBack back) {
        this.c = c;
        this.packageName = packageName;
        this.back = back;
        webView = new WebView(c);
    }

    public void VersionChecker() {
        Log.d("ssss",packageName);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        //webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webView.addJavascriptInterface(new MyJavaScriptInterface(), "HtmlViewer");
        webView.loadUrl("https://play.google.com/store/apps/details?id="+packageName+"&hl=en");
        webView.setWebViewClient(new MyBrowser());
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    public String getPlaystoreVersion(){

        Log.d("sssss",versionCode);
        return versionCode;
    }

   public class MyJavaScriptInterface {

        @JavascriptInterface
        public void showHTML(String html) {
            Log.v("showHTML", "showHTML: " + html);
            versionCode=html;

            back.callback(html);
        }

    }

   public class MyBrowser extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            webView.loadUrl("javascript:window.HtmlViewer.showHTML(document.querySelector('div.hAyfc:nth-child(4)>span.htlgb>.IQ1z0d>.htlgb').innerHTML);");
        }
    }

}
