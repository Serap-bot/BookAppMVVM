package com.serapbekar.bookappmvvm

import android.app.Application
import com.serapbekar.bookappmvvm.common.Contants.BASE_URL
import com.serapbekar.bookappmvvm.data.source.remote.BookService
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class MainApplication: Application()
