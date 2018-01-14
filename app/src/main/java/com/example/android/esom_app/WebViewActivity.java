package com.example.android.esom_app;

/**
 * Created by MAHE on 1/14/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import static com.example.android.esom_app.R.layout.webview;

public class WebViewActivity extends Activity {

    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(webview);

        Intent intent = this.getIntent();

      /* Obtain String from Intent  */
            if(intent !=null)
            {
                String link = intent.getExtras().getString("linkArticle");


                webView = (WebView) findViewById(R.id.webView1);

                webView.getSettings().setJavaScriptEnabled(true);

                if (Build.VERSION.SDK_INT >= 19) {
                    webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                }
                else {
                    webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                }

                webView.loadUrl(link);
            }



    }

}