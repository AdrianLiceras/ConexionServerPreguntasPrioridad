package com.example.conexionserverpreguntasprioridad

import com.google.gson.Gson

class Preguntas(var id:Int , var pregunta:String, var listaOpciones: List<ValoresRespuesta> ) {



    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}