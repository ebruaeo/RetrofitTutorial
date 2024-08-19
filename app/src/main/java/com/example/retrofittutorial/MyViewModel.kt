package com.example.retrofittutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _harryPotterData = MutableLiveData("No data")
    val harryPotterData: LiveData<String> get() = _harryPotterData

    fun getHouses() {
        viewModelScope.launch {
            _harryPotterData.value = RetrofitClient.wizardWorldAPIService.getHouses().toString()
        }
    }

      fun getWizard(firstName: String? = null, lastName: String? = null) {
          viewModelScope.launch {
              _harryPotterData.value =
                  RetrofitClient.wizardWorldAPIService.getWizards(firstName, lastName).toString()
          }

    }
}