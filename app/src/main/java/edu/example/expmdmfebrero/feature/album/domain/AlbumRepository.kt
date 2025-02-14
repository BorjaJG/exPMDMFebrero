package edu.example.expmdmfebrero.feature.album.domain

interface AlbumRepository {
    abstract fun getAlbum(idSeta: String)
}