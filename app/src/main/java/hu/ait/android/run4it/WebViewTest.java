package hu.ait.android.run4it;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Jwatto01 on 5/20/16.
 */
public class WebViewTest extends AppCompatActivity {

        WebView mywebView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_webview);
            String url = "https://www.fitbit.com/oauth2/authorize?response_type=token&client_id=227LZV&redirectUri=&scope=activity%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight&expires_in=604800\n";

            mywebView = (WebView) findViewById(R.id.webView);

            mywebView.getSettings().setJavaScriptEnabled(true);

            mywebView.setWebViewClient(new WebViewClient());
            mywebView.setWebChromeClient(new WebChromeClient());
            mywebView.loadUrl(url);

            mywebView.setWebViewClient(new MyAppWebViewClient());

        }
    }

