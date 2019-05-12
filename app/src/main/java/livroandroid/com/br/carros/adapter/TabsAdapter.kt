package livroandroid.com.br.carros.adapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import livroandroid.com.br.carros.domain.TipoCarro
import livroandroid.com.br.carros.fragments.CarrosFragment

class TabsAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val tipo = getTipoCarro(position)
        val fragment = CarrosFragment()
        val arguments = Bundle()
        arguments.putSerializable("tipo", tipo)
        fragment.arguments = arguments
        return fragment
    }

    private fun getTipoCarro(position: Int) = when(position){
            0 -> TipoCarro.Classicos
            1 -> TipoCarro.Esportivos
            else -> TipoCarro.Luxo
    }


    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.getString(getTipoCarro(position).tipoCarro)
    }

}