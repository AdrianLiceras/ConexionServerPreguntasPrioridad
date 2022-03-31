package com.example.conexionserverpreguntasprioridad

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.conexionserverpreguntasprioridad.databinding.ItemPreguntasBinding

data class PreguntasAdapter(var user:User) : RecyclerView.Adapter<PreguntasAdapter.TextoViewHolder>() {
    class TextoViewHolder(var itemBinding : ItemPreguntasBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun getItemCount(): Int {
        return user.listaDePreguntas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextoViewHolder {
        val binding= ItemPreguntasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextoViewHolder(binding)
    }
    class Option(var opcion:TextView)
    override fun onBindViewHolder(holder: TextoViewHolder, position: Int) {
     /*   var option1= holder.itemBinding.opcion1
        var option2= holder.itemBinding.opcion2
        var option3= holder.itemBinding.opcion3
        var option4= holder.itemBinding.opcion4
        val listaOption= listOf<TextView>(
            option1,
            option2,
            option3,
            option4
        )*/

        holder.itemBinding.pregunta.text=user.listaDePreguntas[position].pregunta

        holder.itemBinding.opcion1.text=user.listaDePreguntas[position].listaOpciones[0].opcion
        holder.itemBinding.opcion2.text=user.listaDePreguntas[position].listaOpciones[1].opcion
        holder.itemBinding.opcion3.text=user.listaDePreguntas[position].listaOpciones[2].opcion
        holder.itemBinding.opcion4.text=user.listaDePreguntas[position].listaOpciones[3].opcion
    }

}