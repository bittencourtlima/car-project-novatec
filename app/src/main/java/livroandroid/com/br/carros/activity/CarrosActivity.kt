package livroandroid.com.br.carros.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.domain.TipoCarro
import livroandroid.com.br.carros.extensions.setupToolbar

class CarrosActivity : BaseActivity() {

    private var tipo: TipoCarro = TipoCarro.Classicos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)
        this.tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val tipoCarro = getString(tipo.tipoCarro)
        setupToolbar(R.id.toolbar, tipoCarro, true)
        val text = findViewById<TextView>(R.id.text);
        text.text = "Carros $tipoCarro"
    }
}
