package com.example.conexionserverpreguntasprioridad

import com.google.gson.Gson

class ValoresRespuesta(var idPreg:Int,  var opcion:String , var valor:Int) {


    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}