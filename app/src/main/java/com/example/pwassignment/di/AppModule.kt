package com.example.pwassignment.di

import android.util.Log
import com.example.pwassignment.data.remote.QuizzyApi
import com.example.pwassignment.data.repository.StudentDashboardRepositoryImpl
import com.example.pwassignment.domain.repository.StudentDashboardRepository
import com.example.pwassignment.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule() {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message ->
            Log.d("OkHttp: ", message)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideQuizzyApi(okHttpClient: OkHttpClient): QuizzyApi {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuizzyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideStudentDashboardRepository(api: QuizzyApi): StudentDashboardRepository {
        return StudentDashboardRepositoryImpl(api)
    }
}