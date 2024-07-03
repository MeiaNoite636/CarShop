package com.meianoitedev.carshop.data.source.remote.model


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

    @SerializedName("nome_modelo")
    val modelName: String,

    @SerializedName("num_portas")
    val doorsNumber: Int,

    @SerializedName("timestamp_cadastro")
    val registerTimestamp: Long,

    @SerializedName("valor")
    val price: Double
)