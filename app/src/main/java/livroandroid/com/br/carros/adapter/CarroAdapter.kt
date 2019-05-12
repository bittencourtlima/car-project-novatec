package livroandroid.com.br.carros.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_carro.view.*
import livroandroid.com.br.carros.R
import livroandroid.com.br.carros.domain.Carro

class CarroAdapter (
    val carros: List<Carro>,
    val onClick: (Carro) -> Unit) : RecyclerView.Adapter<CarroAdapter.CarrosViewHolder>(){

    class CarrosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tNome: TextView = view.findViewById(R.id.tNome)
        var img: ImageView = view.findViewById(R.id.img)
        var progress: ProgressBar = view.findViewById(R.id.progress)
        var cardView: CardView = view.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_carro, parent, false)
        return CarrosViewHolder(view)
    }

    override fun getItemCount(): Int = carros.size

    override fun onBindViewHolder(holder: CarrosViewHolder, position: Int) {
        val context = holder.itemView.context

        val carro = carros[position]

        holder.tNome.text = carro.nome
        holder.progress.visibility = View.VISIBLE

        if(carro.urlFoto.trim().isEmpty()){
            holder.img.setImageBitmap(null)
        }else{

            Picasso.with(context).load(carro.urlFoto).fit().into(holder.img, object: Callback{
                override fun onSuccess() {
                    holder.progress.visibility = View.GONE
                }

                override fun onError() {
                    holder.progress.visibility = View.GONE
                }

            })
        }

        holder.itemView.setOnClickListener{ onClick(carro) }
    }

}