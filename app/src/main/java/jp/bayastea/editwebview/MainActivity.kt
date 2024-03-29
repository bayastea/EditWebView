package jp.bayastea.editwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import jp.bayastea.editwebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val webView = binding?.webview
        webView?.settings?.javaScriptEnabled = true
        webView?.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                // ヘッダーを非表示
                view?.loadUrl(
                    "javascript:(function() { " +
                            "document.getElementsByClassName('devsite-top-logo-row-wrapper-wrapper')[0].style.display = 'none';" +
                            "})()"
                )
                // YouTubeの位置までスクロール
                view?.loadUrl(
                    "javascript:document.getElementsByClassName('devsite-footer-promo')[1].scrollIntoView({behavior: 'smooth'});"
                )
            }
        }

        webView?.loadUrl("https://developer.android.com/?hl=ja")
    }
}