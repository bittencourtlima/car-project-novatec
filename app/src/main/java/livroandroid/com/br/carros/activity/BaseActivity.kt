package livroandroid.com.br.carros.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    protected val context: Context get() = this
}