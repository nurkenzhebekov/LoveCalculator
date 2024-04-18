package com.example.lovecalculator.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities =[LoveCompatibility::class],
    version = 1,
    exportSchema = false
)
abstract class LoveDatabase :RoomDatabase() {

    abstract fun loveDao(): LoveDao

}