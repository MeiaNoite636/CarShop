package com.meianoitedev.carshop.home_feature.data.source.response


import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("ano")
    val year: Int,

    @SerializedName("combustivel")
    val fuel: String,

    @SerializedName("cor")
    val color: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("modelo_id")
    val modelId: Int,

    @SerializedName("nome_modelo")
    val modelName: String,

    @SerializedName("num_portas")
    val doorsNumber: Int,

    @SerializedName("timestamp_cadastro")
    val registerTimestamp: Long,

    @SerializedName("valor")
    val price: Double

)
