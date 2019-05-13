package livroandroid.com.br.carros.activity

import android.os.Bundle
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.domain.TipoCarro
import livroandroid.com.br.carros.extensions.setupToolbar
import livroandroid.com.br.carros.fragments.CarrosFragment

class CarrosActivity : BaseActivity() {

    private var tipo: TipoCarro = TipoCarro.Classicos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)
        this.tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val tipoCarro = getString(tipo.tipoCarro)
        setupToolbar(R.id.toolbar, tipoCarro, true)

        if(savedInstanceState == null){
            val fragment = CarrosFragment()

            fragment.arguments = intent.extras

            supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
        }

    }

}
