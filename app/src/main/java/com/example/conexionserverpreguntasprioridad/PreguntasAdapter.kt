package com.example.conexionserverpreguntasprioridad

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.conexionserverpreguntasprioridad.databinding.ItemPreguntasBinding

data class PreguntasAdapter(var user:User) : RecyclerView.Adapter<PreguntasAdapter.TextoViewHolder>() {
    class TextoViewHolder(var itemBinding : ItemPreguntasBinding) : RecyclerView.ViewHolder(itemBinding.root)
    lateinit var holderP:TextoViewHolder
    var respuesta=user.id.toString()
    override fun getItemCount(): Int {
        return user.listaDePreguntas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextoViewHolder {
        val binding= ItemPreguntasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextoViewHolder(binding)
    }
    override fun onBindViewHolder(holder: TextoViewHolder, position: Int) {
        holderP=holder
        holder.itemBinding.pregunta.text=user.listaDePreguntas[position].pregunta

        holder.itemBinding.opcion1.text=user.listaDePreguntas[position].listaOpciones[0].opcion
        holder.itemBinding.opcion2.text=user.listaDePreguntas[position].listaOpciones[1].opcion
        holder.itemBinding.opcion3.text=user.listaDePreguntas[position].listaOpciones[2].opcion
        holder.itemBinding.opcion4.text=user.listaDePreguntas[position].listaOpciones[3].opcion
        holder.itemBinding.opciones11.forEach {
            val radioButton:RadioButton= it as RadioButton

        }

    }



    fun comprobar(radioGroup: RadioGroup){
        radioGroup.forEach {
            val radioGroupP=it as RadioButton
            if (radioGroupP.isChecked)
                respuesta+=",${radioGroupP.text}"
        }
    }



    fun comprobarRespuesta(radioButton1: RadioButton,radioButton2: RadioButton,radioButton3: RadioButton,radioButton4: RadioButton){

        val listaOpciones= listOf(
            radioButton1,
            radioButton2,
            radioButton3,
            radioButton4
        )

        listaOpciones.forEach {
            if (it.isChecked)
                respuesta+=",${it.text}"
        }

    }
    fun comprobarClick(holder: TextoViewHolder){

        /*comprobarRespuesta(holder.itemBinding.valor11,holder.itemBinding.valor12,holder.itemBinding.valor13,holder.itemBinding.valor14)
        comprobarRespuesta(holder.itemBinding.valor21,holder.itemBinding.valor22,holder.itemBinding.valor23,holder.itemBinding.valor24)
        comprobarRespuesta(holder.itemBinding.valor31,holder.itemBinding.valor32,holder.itemBinding.valor33,holder.itemBinding.valor34)
        comprobarRespuesta(holder.itemBinding.valor41,holder.itemBinding.valor42,holder.itemBinding.valor43,holder.itemBinding.valor44)*/

        comprobar(holder.itemBinding.opciones11)
        comprobar(holder.itemBinding.opciones21)
        comprobar(holder.itemBinding.opciones31)
        comprobar(holder.itemBinding.opciones41)
    }


}