package edu.example.expmdmfebrero.feature.seta.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.example.expmdmfebrero.feature.seta.domain.Seta

class SetaViewModel : ViewModel() {

        private val _myItems = MutableLiveData<List<Seta>>()
        val myItems: LiveData<List<Seta>> get() = _myItems

        private val _loading = MutableLiveData<Boolean>()
        val loading: LiveData<Boolean> get() = _loading

        private val _error = MutableLiveData<String?>()
        val error: MutableLiveData<String?> get() = _error


        fun fetchData() {
            _loading.value = true
            _error.value = null
            Thread {
                try {
                    Thread.sleep(2000)
                    // Simulamos éxito
                    val data = listOf(
                        Seta("Item 1", "seta 1","https://example.com/image1.jpg"),
                        Seta("Item 2", "seta 1", "https://example.com/image2.jpg"),
                        Seta("Item 3", "seta 1", "https://example.com/image3.jpg")
                    )
                    _myItems.postValue(data)
                    _loading.postValue(false)
                } catch (e: Exception) {
                    _loading.postValue(false)
                    _error.postValue("Error de conexión simulado.")
                }
            }.start()
        }
    }

