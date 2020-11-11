package es.dgr.obmarvel.ui.web

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import es.dgr.obmarvel.databinding.ActivityWebBinding
import es.dgr.obmarvel.ui.common.showLoading
import javax.inject.Inject

@AndroidEntryPoint
class WebActivity : AppCompatActivity() {

    companion object Builder {
        private const val URL = "URL"

        fun create(context: Context, url: String) =
            Intent(context, WebActivity::class.java).apply {
                putExtra(URL, url)
            }
    }

    @Inject
    lateinit var viewModel: WebViewModel

    private lateinit var binding: ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater).also { setContentView(it.root) }

        setUpActionBar()
        setUpWebView()
        viewModel.run {
            onViewCreated(url = intent.extras?.getString(URL) ?: "")
            model.observe(this@WebActivity, Observer(::updateUi))
        }
    }

    private fun setUpActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun setUpWebView() {
        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                load(url = url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                binding.loader.loader.showLoading(false)
                super.onPageFinished(view, url)
            }
        }
    }

    private fun updateUi(model: WebUiModel) {
        binding.loader.loader.showLoading(model == WebUiModel.Loading)

        when (model) {
            is WebUiModel.Load -> load(url = model.url)
            else -> {}
        }
    }

    private fun load(url: String) {
        binding.webView.loadUrl(url)
    }
}
