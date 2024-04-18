package com.example.lovecalculator.di

import android.content.Context
import androidx.room.Room
import com.example.lovecalculator.local.LoveDao
import com.example.lovecalculator.local.LoveDatabase
import com.example.lovecalculator.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideLoveDao(appDataBase: LoveDatabase): LoveDao {
        return appDataBase.loveDao()
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): LoveDatabase {
        return Room.databaseBuilder(
            context,
            LoveDatabase::class.java, "love_database"
        ).build()
    }

}