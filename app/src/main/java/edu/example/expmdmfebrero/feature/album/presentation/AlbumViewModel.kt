package edu.example.expmdmfebrero.feature.album.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import edu.example.expmdmfebrero.feature.album.domain.Album
import edu.example.expmdmfebrero.feature.seta.domain.Seta

class AlbumViewModel : ViewModel() {
    // Lista de álbumes (puede provenir de una base de datos, una API, etc.)
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> get() = _albums

    // Inicializamos la lista de álbumes
    fun loadAlbums() {
        // Aquí podrías cargar la lista desde una base de datos, API, etc.
        _albums.value = listOf(
            Album("Álbum 1", "2025-02-14", "Descripción 1", "imagen_url_1", Seta("1"), true),
            Album("Álbum 2", "2025-02-13", "Descripción 2", "imagen_url_2", false)
        )
    }

    // Cambiar el estado de un álbum (activo/inactivo)
    fun toggleAlbumState(album: Album) {
        val updatedAlbum = album.copy(estado = !album.estado)
        _albums.value = _albums.value?.map {
            if (it.nombre == album.nombre) updatedAlbum else it
        }
    }
}

}