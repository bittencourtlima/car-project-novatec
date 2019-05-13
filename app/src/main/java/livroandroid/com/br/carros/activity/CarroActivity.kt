package livroandroid.com.br.carros.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_carro.*
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.domain.Carro
import livroandroid.com.br.carros.extensions.loadImage
import livroandroid.com.br.carros.extensions.setupToolbar

class CarroActivity : AppCompatActivity() {

    val carro by lazy { intent.getSerializableExtra("carro") as Carro }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carro)
        setupToolbar(R.id.toolbar, carro.nome,true);

        tDesc.text = carro?.desc
        img.loadImage(carro?.urlFoto)
    }
}
