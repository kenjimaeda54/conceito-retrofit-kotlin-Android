# conceito-retrofit-kotlin-Android

Conceito de retrofit


## Retrofit

Pequena aplicação para aplicar os conceitos do retrofit </br>

Apliquei conceito genérico para possibilidade de minha função receber N tipos. </br>
Retrofit tem uma camada representada por uma  interface, ela conte  o verbo http, neste verbo précia descrever o recurso que deseja consumir no meu caso posts</br>
Ela possui um modelo singleton para instância da classe. Entao criei meu membro estático para garantir apenas uma instância da classe
Para receber uma reposta de um recurso http com retrofit possuímos enqueue e create. Um, assíncrono e outro síncrono, no meu caso usei assíncrono.


```kotlin
  override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val error = t.message
   }
   
   
//--------------//

interface PostService {
    //recurso da url
    @GET("posts")
    fun list(): Call<List<PostModel>>
}


//--------------------//
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

 ```
