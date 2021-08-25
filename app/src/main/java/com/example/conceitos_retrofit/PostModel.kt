package com.example.conceitos_retrofit

import com.google.gson.annotations.SerializedName

class PostModel {
    // SerializedName e para garantir que a conversao do valor da api,para o valor que estou determinando na minha variavel
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("userId")
    var userId: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("body")
    var body: String = ""

}