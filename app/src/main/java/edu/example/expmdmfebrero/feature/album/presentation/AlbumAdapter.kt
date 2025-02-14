package edu.example.expmdmfebrero.feature.album.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import edu.example.expmdmfebrero.R
import edu.example.expmdmfebrero.feature.album.domain.Album

class AlbumAdapter(
    private val albums: List<Album>,
    private val onAlbumStateChanged: (Album) -> Unit
) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
    }

    override fun getItemCount() = albums.size

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageViewAlbum)
        private val textViewEstado: TextView = itemView.findViewById(R.id.imageViewEstado)
        private val albumImage: ImageView = itemView.findViewById(R.id.imageViewAlbum)

        fun bind(album: Album) {

            if (album.estado) {
                textViewEstado.text = "Activo"
                albumImage.setColorFilter(ContextCompat.getColor(itemView.context, R.color.black))
            } else {
                textViewEstado.text = "Inactivo"
                albumImage.setColorFilter(ContextCompat.getColor(itemView.context, R.color.white))
            }


            imageView.setOnClickListener {

                val updatedAlbum = album.copy(estado = !album.estado)
                onAlbumStateChanged(updatedAlbum)


                if (updatedAlbum.estado) {
                    albumImage.setColorFilter(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.black
                        )
                    )
                    textViewEstado.text = "Activo"
                } else {
                    albumImage.setColorFilter(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.white
                        )
                    )
                    textViewEstado.text = "Inactivo"
                }
            }
        }
    }
}
