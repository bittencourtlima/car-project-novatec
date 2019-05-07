package livroandroid.com.br.carros.domain

import android.support.annotation.IdRes
import livroandroid.com.br.carros.R

enum class TipoCarro(val tipoCarro: Int) {
    Classicos(R.string.classicos),
    Esportivos(R.string.esportivos),
    Luxo(R.string.luxo),
}