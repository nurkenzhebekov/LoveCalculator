package com.example.lovecalculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.local.LoveDao
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.remote.LoveCalcModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: LoveApi,
    private val loveDao: LoveDao
) {

    fun insertLoveCompatibility(loveCalcModel: LoveCalcModel) {
        loveDao.insertLoveCompatibility(loveCalcModel)
    }

    fun getAllLoveCompatibilities():List<LoveCalcModel> {
        return loveDao.getAll()
    }

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