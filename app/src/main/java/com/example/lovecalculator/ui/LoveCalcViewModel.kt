package com.example.lovecalculator.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.Repository
import com.example.lovecalculator.remote.LoveCalcModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveCalcViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    fun insertLoveCompatibility(loveCalcModel: LoveCalcModel) {
        repository.insertLoveCompatibility(loveCalcModel)
    }

    fun getResults():List<LoveCalcModel> {
        return repository.getAllLoveCompatibilities()

    }

    fun getLiveData(firstName: String, secondName: String) : LiveData<LoveCalcModel> {
        return repository.getData(firstName, secondName)
    }
}