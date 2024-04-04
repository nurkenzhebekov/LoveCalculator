package com.example.lovecalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.remote.LoveCalcModel
import com.example.lovecalculator.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    val api = RetrofitService.api

    fun getData(firstName: String, secondName: String): MutableLiveData<LoveCalcModel> {
        val liveData = MutableLiveData<LoveCalcModel>()
        api.getLoveCalc(firstName, secondName).enqueue(object : Callback<LoveCalcModel> {
            override fun onResponse(p0: Call<LoveCalcModel>, response: Response<LoveCalcModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        liveData.postValue(it)
                    }
                }
            }

            override fun onFailure(p0: Call<LoveCalcModel>, error: Throwable) {
                Log.e("loge", "onFailure: ${error.message}")
            }

        })
        return liveData
    }
}