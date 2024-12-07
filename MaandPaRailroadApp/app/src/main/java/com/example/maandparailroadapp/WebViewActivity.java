package com.example.maandparailroadapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();

                // Handle "fb://" and other custom schemes
                if (url.startsWith("fb://")) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    } catch (Exception e) {
                        // If Facebook app is not installed, redirect to browser
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.facebook.com/MaandPaRailroad"));
                        startActivity(intent);
                    }
                    return true; // Indicate WebView should not handle this URL
                }

                // Allow WebView to handle other URLs
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        // Load the initial URL
        String initialUrl = getIntent().getStringExtra("url");
        webView.loadUrl(initialUrl);
    }
}
