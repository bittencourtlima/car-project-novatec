package livroandroid.com.br.carros.activity

import android.graphics.Bitmap
import android.view.View
import livroandroid.com.br.carros.activity.BaseActivity


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_site_livro.*
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.extensions.setupToolbar

class SiteLivroActivity : BaseActivity() {

    private val URL_SOBRE = "http://www.livroandroid.com.br/sobre.htm"
    var webview: WebView? = null
    var progress: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site_livro)

        setupToolbar(R.id.toolbar, upNavigation = true)

        webview = findViewById(R.id.webview)
        progress = findViewById(R.id.progress)

        setWebViewClient(webview)
        webview?.loadUrl(URL_SOBRE)
    }

    private fun setWebViewClient(webview: WebView?) {
        webview?.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progress?.visibility = View.VISIBLE
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                progress?.visibility = View.INVISIBLE
            }
        }
    }
}
