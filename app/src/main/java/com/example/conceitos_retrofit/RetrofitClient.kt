package com.example.conceitos_retrofit


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient private constructor() {


    companion object {
        private lateinit var retrofit: Retrofit

        //precissa do barra no final,Retrofit da erro sem o /
        private const val baseUrl = "https://jsonplaceholder.typicode.com/"
        private val httpClient = OkHttpClient.Builder()
        private fun createService(): Retrofit {
            if (!::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()

            }
            return retrofit
        }

        //assim deixo minha funcao generica,se eu colcoar um valor no generic(<>) vou estar limitando apenas para um tipo
        fun <T> serviceClient(classService: Class<T>): T {
            return createService().create(classService)
        }

    }


}