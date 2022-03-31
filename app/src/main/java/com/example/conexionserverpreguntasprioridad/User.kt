package com.example.conexionserverpreguntasprioridad

import android.os.Parcelable
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
class User (var id:Int):Parcelable{
    var listaDePreguntas= mutableListOf<Preguntas>()

    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}