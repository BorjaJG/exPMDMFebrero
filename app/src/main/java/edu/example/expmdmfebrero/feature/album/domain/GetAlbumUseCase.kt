package edu.example.expmdmfebrero.feature.album.domain

class GetAlbumUseCase(private val albumRepository: AlbumRepository) {

    fun execute(idSeta: String) {
        return albumRepository.getAlbum(idSeta)
    }

}