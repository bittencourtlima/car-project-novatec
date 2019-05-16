package livroandroid.com.br.carros.domain

import android.content.Context
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.extensions.fromJson

object CarroService {

    private const val TAG = "livro"

    fun getCarros(context: Context, tipo: TipoCarro): List<Carro>{
        val raw = getArquivoRaw(tipo)

        val resources = context.resources

        val inputStream = resources.openRawResource(raw)
        inputStream.bufferedReader().use {
            val json = it.readText()
            val carros = fromJson<List<Carro>>(json)
            return carros
        }
    }

    private fun getArquivoRaw(tipo: TipoCarro) = when(tipo){
        TipoCarro.Classicos -> R.raw.carros_classicos
        TipoCarro.Esportivos -> R.raw.carros_esportivos
        else -> R.raw.carros_luxo
    }

//    private fun parserXML(xmlString: String): List<Carro>{
//        val carros = mutableListOf<Carro>()
//        val xml = xmlString.getXml()
//
//        val nodeCarros = xml.getChildren("carro")
//
//        for(node in nodeCarros){
//            val c = Carro()
//
//            c.nome = node.getText("nome")
//            c.desc = node.getText("desc")
//            c.urlFoto = node.getText("url_foto")
//            Log.d("carro",c.urlFoto)
//
//            carros.add(c)
//        }
//        Log.d(TAG, "${carros.size} carros encontrados")
//        return carros
//    }
//
//    private fun parserJson(json: String): List<Carro>{
//        val carros = mutableListOf<Carro>()
//
//        val array = JSONArray(json)
//        for(i in 0 until array.length()){
//            val jsonCarro = array.getJSONObject(i)
//            val c = Carro()
//
//            c.nome = jsonCarro.optString("nome")
//            c.desc = jsonCarro.optString("desc")
//            c.urlFoto = jsonCarro.optString("url_foto")
//
//            carros.add(c)
//        }
//        Log.d(TAG, "${carros.size} carros encontrados")
//        return carros
//    }



}