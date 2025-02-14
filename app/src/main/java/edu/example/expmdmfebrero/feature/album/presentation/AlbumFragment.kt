package edu.example.expmdmfebrero.feature.album.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.example.expmdmfebrero.R

class AlbumFragment : Fragment(R.layout.album_fragment) {

    private lateinit var albumAdapter: AlbumAdapter
    private val albumViewModel: AlbumViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewAlbums)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        albumAdapter = AlbumAdapter(emptyList()) { updatedAlbum ->


        }
        recyclerView.adapter = albumAdapter


        albumViewModel.albums.observe(viewLifecycleOwner) { albums ->


        }
    }
}
