package livroandroid.com.br.carros.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.widget.TextView
import livroandroid.com.br.carros.R

class AboutDialog: DialogFragment() {

    @Suppress("DEPRECATION")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val aboutBody = SpannableStringBuilder()

        val versionName = getAppVersionName()
        val html = Html.fromHtml(getString(R.string.about_dialog_text, versionName))

        aboutBody.append(html)

        val view = LayoutInflater.from(activity).inflate(R.layout.dialog_about, null) as TextView
        view.text = aboutBody
        view.movementMethod = LinkMovementMethod()

        return AlertDialog.Builder(activity)
            .setTitle(R.string.about_dialog_title)
            .setView(view)
            .setPositiveButton(R.string.ok){dialog, _ ->  dialog.dismiss()}
            .create()
    }

    private fun getAppVersionName(): String? {
        val pm = activity?.packageManager
        val packageName = activity?.packageName
        var versionName: String?
        try{
            val info = pm?.getPackageInfo(packageName, 0)
            versionName = info?.versionName
        }catch(ex: PackageManager.NameNotFoundException){
            versionName = "N/A"
        }

        return versionName
    }

    companion object{

        fun showAbout(fm: FragmentManager){
            val ft = fm.beginTransaction()
            val prev = fm.findFragmentByTag("about_dialog")
            if(prev != null){
                ft.remove(prev)
            }
            ft.addToBackStack(null)
            AboutDialog().show(ft, "about_dialog")
        }
    }
}