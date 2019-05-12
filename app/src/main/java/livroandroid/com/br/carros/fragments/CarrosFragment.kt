package livroandroid.com.br.carros.fragments

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_carros.*
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.activity.CarroActivity
import livroandroid.com.br.carros.adapter.CarroAdapter
import livroandroid.com.br.carros.domain.Carro
import livroandroid.com.br.carros.domain.CarroService
import livroandroid.com.br.carros.domain.TipoCarro
import livroandroid.com.br.carros.fragments.BaseFragment
import org.jetbrains.anko.startActivity

class CarrosFragment : BaseFragment() {

    private var tipo: TipoCarro = TipoCarro.Classicos
    private var carros = listOf<Carro>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_carros, container, false)
        this.tipo = arguments?.getSerializable("tipo") as TipoCarro

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskCarros()
    }

    private fun taskCarros() {
        val carros = CarroService.getCarros(context, tipo)
        recyclerView.adapter = CarroAdapter(carros) { onClickCarro(it) }
    }

    private fun onClickCarro(carro: Carro) {
        activity?.startActivity<CarroActivity>("carro" to carro)
    }
}
