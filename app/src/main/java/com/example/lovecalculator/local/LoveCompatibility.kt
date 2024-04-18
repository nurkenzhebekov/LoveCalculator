package com.example.lovecalculator.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoveCompatibility(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0, // Добавляем поле id
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "second_name")
    val secondName: String,
    @ColumnInfo(name = "percentage")
    val percentage: String,
    @ColumnInfo(name = "result")
    val result: String
)
