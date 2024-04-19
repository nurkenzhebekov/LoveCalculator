package com.example.lovecalculator.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.remote.LoveCalcModel

@Dao
interface LoveDao {

    @Insert
    fun insertLoveCompatibility(loveCalcModel: LoveCalcModel)

    @Delete
    fun deleteLoveCompatibility(loveCalcModel: LoveCalcModel)

    @Query("SELECT * FROM love_table ORDER BY firstName ASC")
    fun getAll() : List<LoveCalcModel>

}