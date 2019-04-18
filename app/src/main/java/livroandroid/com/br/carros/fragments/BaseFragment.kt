package livroandroid.com.br.carros.fragments

import android.content.Context
import android.support.v4.app.Fragment

class BaseFragment: Fragment() {

    override fun getContext(): Context {
        return super.getContext()!!
    }
}