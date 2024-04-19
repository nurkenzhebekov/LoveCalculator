package com.example.lovecalculator.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator.remote.LoveCalcModel

@Database(
    entities =[LoveCalcModel::class],
    version = 1,
    exportSchema = false
)
abstract class LoveDatabase :RoomDatabase() {

    abstract fun loveDao(): LoveDao

}