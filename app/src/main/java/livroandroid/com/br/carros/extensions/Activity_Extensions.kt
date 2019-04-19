package livroandroid.com.br.carros.extensions

import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Toast

fun AppCompatActivity.setupToolbar(@IdRes id: Int, title: String? = null, upNavigation: Boolean = false): ActionBar {
    val toolbar = findViewById<Toolbar>(id)
    setSupportActionBar(toolbar)

    if(title != null) supportActionBar?.setTitle(title)

    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)

    return supportActionBar!!
}

fun AppCompatActivity.addFragment(@IdRes layoutId: Int, fragment: Fragment) {
    fragment.arguments = intent.extras
    val ft = supportFragmentManager.beginTransaction()
    ft.add(layoutId, fragment)
    ft.commit()
}

fun AppCompatActivity.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()

fun AppCompatActivity.toast(@StringRes message: Int, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()
