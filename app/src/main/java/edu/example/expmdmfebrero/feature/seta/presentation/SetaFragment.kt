package edu.example.expmdmfebrero.feature.seta.presentation


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.example.expmdmfebrero.R
import edu.example.expmdmfebrero.feature.seta.domain.Seta

class SetaFragment : Fragment(R.layout.setas_fragment) {

        private lateinit var recyclerView: RecyclerView
        private lateinit var adapter: SetaAdapter
        private lateinit var setViewModel: SetaViewModel

        private val myItemList = mutableListOf<Seta>()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.setas_fragment, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            recyclerView = view.findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            setViewModel = ViewModelProvider(this)[SetaViewModel::class.java]

            adapter = SetaAdapter(myItemList)
            recyclerView.adapter = adapter

            setViewModel.myItems.observe(viewLifecycleOwner) { items ->
                if (items.isNotEmpty()) {
                    adapter.updateItems(items)
                    adapter.hideLoading()
                }
            }

            setViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
                if (isLoading) {
                    adapter.showLoading()
                } else {
                    adapter.hideLoading()
                }
            }

            setViewModel.error.observe(viewLifecycleOwner) { error ->
                if (error != null) {
                    if (error.isNotEmpty()) {

                        AlertDialog.Builder(requireContext())
                            .setTitle("Error")
                            .setMessage(error)
                            .setPositiveButton("Aceptar") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .show()
                    }
                }
            }

            setViewModel.fetchData()
        }
    }


