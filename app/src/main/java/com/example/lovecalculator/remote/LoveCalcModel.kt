package com.example.lovecalculator.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love_table")
data class LoveCalcModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
)

//fname:"John"
//sname:"Alice"
//percentage:"46"
//result:"Can choose someone better."

