package com.arcanesecurity.nasalightning.di

import com.arcanesecurity.nasalightning.services.NasaEndpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    /**
     * Apply the NASA base url here
     */
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://nasa.api")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideNasaEndpoints(retrofit: Retrofit): NasaEndpoints =
        retrofit.create(NasaEndpoints::class.java)


}