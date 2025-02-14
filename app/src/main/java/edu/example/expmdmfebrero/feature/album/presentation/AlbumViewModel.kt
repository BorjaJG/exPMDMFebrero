package edu.example.expmdmfebrero.feature.album.presentation

import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.example.expmdmfebrero.R
import edu.example.expmdmfebrero.feature.album.domain.Album
import edu.example.expmdmfebrero.feature.seta.domain.Seta

class AlbumViewModel : ViewModel() {

    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> get() = _albums


    fun loadAlbums() {

        _albums.value = listOf(
            Album(
                "Álbum 1",
                "2025-02-14",
                "Descripción 1",
                "imagen_url_1",
                Seta("1", "Seta Roja", "seta_roja_url"),
                true
            ),
            Album(
                "Álbum 2",
                "2025-02-13",
                "Descripción 2",
                "imagen_url_2",
                Seta("2", "Seta Azul", "seta_azul_url"),
                false
            )
        )
    }

    fun toggleAlbumState(album: Album, imageView: ImageView) {

        val updatedAlbum = album.copy(estado = !album.estado)

        // Cambiar el color de la imagen dependiendo del nuevo estado
        val color = if (updatedAlbum.estado) {
            ContextCompat.getColor(requireContext(updatedAlbum), R.color.black)
        } else {
            ContextCompat.getColor(requireContext(updatedAlbum), R.color.white)
        }
        imageView.setColorFilter(color)
        _albums.value = _albums.value?.map {
            if (it.nombre == album.nombre) updatedAlbum else it
        }
    }

}

