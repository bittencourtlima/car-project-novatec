package livroandroid.com.br.carros.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_carro.*
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.domain.Carro
import livroandroid.com.br.carros.extensions.loadImage
import livroandroid.com.br.carros.extensions.setupToolbar

class CarroActivity : AppCompatActivity() {

    var carro: Carro? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carro)
        setupToolbar(R.id.toolbar, upNavigation = true);

        carro = intent.getSerializableExtra("carro") as Carro
        supportActionBar?.title = carro?.nome

        tDesc.text = carro?.desc
        img.loadImage(carro?.urlFoto)
    }
}
