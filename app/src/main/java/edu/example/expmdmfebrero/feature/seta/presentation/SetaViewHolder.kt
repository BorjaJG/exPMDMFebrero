package edu.example.expmdmfebrero.feature.seta.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import edu.example.expmdmfebrero.R
import edu.example.expmdmfebrero.feature.seta.domain.Seta

class SetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.item_image)
    val image: ImageView = itemView.findViewById(R.id.item_name)


    fun bind(myItem: Seta) {
        title.text = myItem.nombre

        image.load(myItem.imag) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_background)
            error(R.drawable.ic_launcher_foreground)
        }
    }


    companion object {
        fun create(parent: ViewGroup): SetaViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.seta_item, parent, false)
            return SetaViewHolder(view)
        }
    }
}

