package livroandroid.com.br.carros.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_carros.*
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.adapter.CarroAdapter
import livroandroid.com.br.carros.domain.Carro
import livroandroid.com.br.carros.domain.CarroService
import livroandroid.com.br.carros.domain.TipoCarro
import livroandroid.com.br.carros.extensions.setupToolbar
import org.jetbrains.anko.toast

class CarrosActivity : BaseActivity() {

    private var tipo: TipoCarro = TipoCarro.Classicos
    private var carros = listOf<Carro>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)
        this.tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val tipoCarro = getString(tipo.tipoCarro)
        setupToolbar(R.id.toolbar, tipoCarro, true)

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
        recyclerView.adapter = CarroAdapter(carros, { toast("@Clicou no carro ${it.nome}")})
    }
}
