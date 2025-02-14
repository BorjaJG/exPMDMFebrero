package edu.example.expmdmfebrero.feature.album.domain

import edu.example.expmdmfebrero.feature.seta.domain.Seta

class Album
    (
    val nombre: String,
    val fecha: String,
    val descripcion: String,
    val imagen: String,
    val listSetas: Seta,
    val estado: Boolean
)