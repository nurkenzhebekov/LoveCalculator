package com.example.lovecalculator.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
//"https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John"
    @GET("getPercentage")
    fun getLoveCalc(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "059bb08cd9mshc850d76d7d3a130p1832a7jsn0e331ad57361",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ) : Call<LoveCalcModel>

}