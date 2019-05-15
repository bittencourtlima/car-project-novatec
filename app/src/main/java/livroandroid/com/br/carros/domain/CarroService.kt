package livroandroid.com.br.carros.domain

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.util.Log
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.extensions.getText
import livroandroid.com.br.carros.extensions.getXml

object CarroService {

    private const val TAG = "livro"

    fun getCarros(context: Context, tipo: TipoCarro): List<Carro>{
        val raw = getArquivoRaw(tipo)

        val resources = context.resources

        val inputStream = resources.openRawResource(raw)
        inputStream.bufferedReader().use {
            val xml = it.readText()
            val carros = parserXML(xml)
            return carros
        }
    }

    private fun getArquivoRaw(tipo: TipoCarro) = when(tipo){
        TipoCarro.Classicos -> R.raw.carros_classicos
        TipoCarro.Esportivos -> R.raw.carros_esportivos
        else -> R.raw.carros_luxo
    }

    private fun parserXML(xmlString: String): List<Carro>{
        val carros = mutableListOf<Carro>()
        val xml = xmlString.getXml()

        val nodeCarros = xml.getChildren("carro")

        for(node in nodeCarros){
            val c = Carro()

            c.nome = node.getText("nome")
            c.desc = node.getText("desc")
            c.urlFoto = node.getText("url_foto")
            Log.d("carro",c.urlFoto)

            carros.add(c)
        }
        Log.d(TAG, "${carros.size} carros encontrados")
        return carros
    }



}