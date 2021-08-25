package com.example.conceitos_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val remote = RetrofitClient.serviceInstance(PostService::class.java)
        val call: Call<List<PostModel>> = remote.list()
        //enqueue e assincrono , existe outro metodo porem e sincrono
        val reponse = call.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                val response = response.body()
            }

            //se aplicar um debug nas linha de reponse ira verificar a reponsta e um status 200
            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val error = t.message
            }


        })

    }
}