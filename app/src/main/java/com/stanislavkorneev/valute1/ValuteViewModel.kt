package com.stanislavkorneev.valute1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class ValuteViewModel : ViewModel() {

    private val valuteLoader = ValuteLoader()
    var valuteList = MutableLiveData<List<Valute>>()
    var isCalling = false

    fun getContent() {
        viewModelScope.launch {
            valuteList.value = valuteLoader.loadContent()
        }

        isCalling = true
    }

}