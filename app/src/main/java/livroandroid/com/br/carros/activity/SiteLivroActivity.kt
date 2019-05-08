package livroandroid.com.br.carros.activity

import android.graphics.Bitmap
import android.view.View

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_site_livro.*
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.dialog.AboutDialog
import livroandroid.com.br.carros.extensions.setupToolbar

class SiteLivroActivity : BaseActivity() {

    private val URL_SOBRE = "http://www.livroandroid.com.br/sobre.htm"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site_livro)

        setupToolbar(R.id.toolbar, getString(R.string.site_do_livro), true)

        setWebViewClient(webview)
        webview.loadUrl(URL_SOBRE)

        swipeToRefresh.setOnRefreshListener {
            webview.reload()
        }

        swipeToRefresh?.setColorSchemeResources(
            R.color.refresh_progress_1,
            R.color.refresh_progress_2,
            R.color.refresh_progress_3
        )
    }

    private fun setWebViewClient(webview: WebView) {
        webview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progress.visibility = View.VISIBLE
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                progress.visibility = View.INVISIBLE
                swipeToRefresh?.isRefreshing = false
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request?.url.toString()
                if(url.endsWith("sobre.htm")){
                    AboutDialog.showAbout(supportFragmentManager)
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
    }
}
