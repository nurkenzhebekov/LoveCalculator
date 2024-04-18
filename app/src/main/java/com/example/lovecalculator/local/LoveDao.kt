package com.example.lovecalculator.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoveDao {

    @Insert
    fun insertLoveCompatibility(loveComp: LoveCompatibility)

    @Delete
    fun deleteLoveCompatibility(loveComp: LoveCompatibility)

    @Query("SELECT * FROM lovecompatibility")
    fun getAll() : LiveData<List<LoveCompatibility>>

}