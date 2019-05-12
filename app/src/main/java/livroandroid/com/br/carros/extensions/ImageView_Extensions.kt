package livroandroid.com.br.carros.extensions

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String?, progress: ProgressBar? = null){

    if(url == null || url.trim().isEmpty()){
        setImageBitmap(null)
        return
    }

    if(progress == null){
        Picasso.with(context).load(url).fit().into(this)
        return
    }

    Picasso.with(context).load(url).fit().into(this, object: Callback {
        override fun onSuccess() {
            progress.visibility = View.GONE
        }

        override fun onError() {
            progress.visibility = View.GONE
        }

    })

}