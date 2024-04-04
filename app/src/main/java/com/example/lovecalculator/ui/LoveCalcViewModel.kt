package com.example.lovecalculator.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.Repository
import com.example.lovecalculator.remote.LoveCalcModel

class LoveCalcViewModel : ViewModel() {

    val repository = Repository()

    fun getLiveData(firstName: String, secondName: String) : LiveData<LoveCalcModel> {
        return repository.getData(firstName, secondName)
    }
}