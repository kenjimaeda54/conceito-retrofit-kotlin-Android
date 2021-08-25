package com.example.conceitos_retrofit


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient private constructor() {


    companion object {
        private lateinit var retrofit: Retrofit

        //precissa do barra no final Retrofit da erro sem o /
        private const val baseUrl = "https://jsonplaceholder.typicode.com/"
        private val httpClient = OkHttpClient.Builder()
        private fun getInstance(): Retrofit {
            if (!::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .client(httpClient.build())
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return retrofit

        }

        //assim deixo minha funcao generica,se eu colcoar um valor no generic(<>) vou estar limitando apenas para um tipo
        fun <T> serviceInstance(service: Class<T>): T {
            return getInstance().create(service)
        }


    }

}