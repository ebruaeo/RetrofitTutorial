package com.example.retrofittutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.UUID

class MyViewModel : ViewModel() {
    private val _harryPotterData = MutableLiveData("No data")
    val harryPotterData: LiveData<String> get() = _harryPotterData
     val suggestion = Feedback(
        "Suggestion",
        feedback = "Perhaps rename the Wizards endpoint to smt like WizardInventors.",
        entityId = UUID.randomUUID().toString()

    )

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

    fun submitFeedback(feedback: Feedback) {
        viewModelScope.launch {
            _harryPotterData.value =
                RetrofitClient.wizardWorldAPIService.submitFeedback(feedback).toString()

        }
    }
}