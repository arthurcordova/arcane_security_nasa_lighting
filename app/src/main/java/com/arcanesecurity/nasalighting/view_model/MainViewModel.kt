package com.arcanesecurity.nasalighting.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcanesecurity.nasalighting.model.LightingStrike
import com.arcanesecurity.nasalighting.repository.NasaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NasaRepository) : ViewModel() {

    private val _lights = MutableLiveData<List<LightingStrike>>()
    val lights: LiveData<List<LightingStrike>> = _lights

    fun fetchLights() {
        viewModelScope.launch {
            _lights.value = repository.fetchLights()
        }
    }

}