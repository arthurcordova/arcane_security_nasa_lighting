package com.arcanesecurity.nasalightning.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcanesecurity.nasalightning.model.LightningStrike
import com.arcanesecurity.nasalightning.repository.NasaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NasaRepository) : ViewModel() {

    private val _lights = MutableLiveData<List<LightningStrike>>()
    val lights: LiveData<List<LightningStrike>> = _lights

    fun fetchLights() {
        viewModelScope.launch {
            _lights.value = repository.fetchLights()
        }
    }

}