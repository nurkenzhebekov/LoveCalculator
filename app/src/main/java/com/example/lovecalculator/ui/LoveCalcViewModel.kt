package com.example.lovecalculator.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.Repository
import com.example.lovecalculator.local.LoveCompatibility
import com.example.lovecalculator.remote.LoveCalcModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveCalcViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val allLoveCompatibilities: LiveData<List<LoveCompatibility>> = repository.getAllLoveCompatibilities()

    fun insertLoveCompatibility(loveComp: LoveCompatibility) {
        repository.insertLoveCompatibility(loveComp)
    }

    suspend fun getLiveData2(firstName: String, secondName: String): LoveCalcModel {
        return repository.getLoveCompatibility(firstName, secondName)
    }

    fun getLiveData(firstName: String, secondName: String) : LiveData<LoveCalcModel> {
        return repository.getData(firstName, secondName)
    }
}